/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "supportserver", catalog = "getlink", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupportServer.findAll", query = "SELECT s FROM SupportServer s")
    , @NamedQuery(name = "SupportServer.findById", query = "SELECT s FROM SupportServer s WHERE s.id = :id")
    , @NamedQuery(name = "SupportServer.findByName", query = "SELECT s FROM SupportServer s WHERE s.name = :name")
    , @NamedQuery(name = "SupportServer.findByIsActive", query = "SELECT s FROM SupportServer s WHERE s.isActive = :isActive")})
public class SupportServer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Column(name = "isActive")
    private Boolean isActive;
    @OneToMany(mappedBy = "server")
    private List<AccountData> accountDataList;

    public SupportServer() {
    }

    public SupportServer(Integer id) {
        this.id = id;
    }

    public SupportServer(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public List<AccountData> getAccountDataList() {
        return accountDataList;
    }

    public void setAccountDataList(List<AccountData> accountDataList) {
        this.accountDataList = accountDataList;
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
        if (!(object instanceof SupportServer)) {
            return false;
        }
        SupportServer other = (SupportServer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.SupportServer[ id=" + id + " ]";
    }
    
}
