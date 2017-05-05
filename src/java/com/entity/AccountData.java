/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "accountdata", catalog = "getlink", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountData.findAll", query = "SELECT a FROM AccountData a")
    , @NamedQuery(name = "AccountData.findById", query = "SELECT a FROM AccountData a WHERE a.id = :id")
    , @NamedQuery(name = "AccountData.findByName", query = "SELECT a FROM AccountData a WHERE a.name = :name")
    , @NamedQuery(name = "AccountData.findByEmail", query = "SELECT a FROM AccountData a WHERE a.email = :email")
    , @NamedQuery(name = "AccountData.findByPassword", query = "SELECT a FROM AccountData a WHERE a.password = :password")
    , @NamedQuery(name = "AccountData.findByIsAlive", query = "SELECT a FROM AccountData a WHERE a.isAlive = :isAlive")
    , @NamedQuery(name = "AccountData.findByIsActive", query = "SELECT a FROM AccountData a WHERE a.isActive = :isActive")})
public class AccountData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "isAlive")
    private Boolean isAlive;
    @Column(name = "isActive")
    private Boolean isActive;
    @JoinColumn(name = "server", referencedColumnName = "id")
    @ManyToOne
    private SupportServer server;

    public AccountData() {
    }

    public AccountData(Integer id) {
        this.id = id;
    }

    public AccountData(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public SupportServer getServer() {
        return server;
    }

    public void setServer(SupportServer server) {
        this.server = server;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountData)) {
            return false;
        }
        AccountData other = (AccountData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.AccountData[ id=" + id + " ]";
    }
    
}
