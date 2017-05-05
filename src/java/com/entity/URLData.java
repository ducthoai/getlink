/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "urldata", catalog = "getlink", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "URLData.findAll", query = "SELECT u FROM URLData u")
    , @NamedQuery(name = "URLData.findById", query = "SELECT u FROM URLData u WHERE u.id = :id")
    , @NamedQuery(name = "URLData.findByOriginRequestURL", query = "SELECT u FROM URLData u WHERE u.originRequestURL = :originRequestURL")
    , @NamedQuery(name = "URLData.findByPassword", query = "SELECT u FROM URLData u WHERE u.password = :password")
    , @NamedQuery(name = "URLData.findByOriginProcessURI", query = "SELECT u FROM URLData u WHERE u.originProcessURI = :originProcessURI")
    , @NamedQuery(name = "URLData.findByOriginResultURL", query = "SELECT u FROM URLData u WHERE u.originResultURL = :originResultURL")
    , @NamedQuery(name = "URLData.findByIdentity", query = "SELECT u FROM URLData u WHERE u.identity = :identity")
    , @NamedQuery(name = "URLData.findByStatus", query = "SELECT u FROM URLData u WHERE u.status = :status")
    , @NamedQuery(name = "URLData.findByRetry", query = "SELECT u FROM URLData u WHERE u.retry = :retry")
    , @NamedQuery(name = "URLData.findByIsProcessed", query = "SELECT u FROM URLData u WHERE u.isProcessed = :isProcessed")
    , @NamedQuery(name = "URLData.findByIsLeech", query = "SELECT u FROM URLData u WHERE u.isLeech = :isLeech")
    , @NamedQuery(name = "URLData.findByIsServe", query = "SELECT u FROM URLData u WHERE u.isServe = :isServe")
    , @NamedQuery(name = "URLData.findByReceiveTime", query = "SELECT u FROM URLData u WHERE u.receiveTime = :receiveTime")
    , @NamedQuery(name = "URLData.findByFinalURL", query = "SELECT u FROM URLData u WHERE u.finalURL = :finalURL")})
public class URLData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "originRequestURL", length = 255)
    private String originRequestURL;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "originProcessURI", length = 255)
    private String originProcessURI;
    @Column(name = "originResultURL", length = 255)
    private String originResultURL;
    @Column(name = "identity", length = 255)
    private String identity;
    @Column(name = "status")
    private Integer status;
    @Column(name = "retry")
    private Integer retry;
    @Column(name = "isProcessed")
    private Boolean isProcessed;
    @Column(name = "isLeech")
    private Boolean isLeech;
    @Column(name = "isServe")
    private Boolean isServe;
    @Column(name = "receiveTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveTime;
    @Column(name = "finalURL", length = 255)
    private String finalURL;

    public URLData() {
    }

    public URLData(String originRequestURL, String password, String originProcessURI, String originResultURL, String identity, Integer status, Integer retry, Boolean isProcessed, Boolean isLeech, Boolean isServe, Date receiveTime, String finalURL) {
        this.originRequestURL = originRequestURL;
        this.password = password;
        this.originProcessURI = originProcessURI;
        this.originResultURL = originResultURL;
        this.identity = identity;
        this.status = status;
        this.retry = retry;
        this.isProcessed = isProcessed;
        this.isLeech = isLeech;
        this.isServe = isServe;
        this.receiveTime = receiveTime;
        this.finalURL = finalURL;
    }
    
    public URLData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginRequestURL() {
        return originRequestURL;
    }

    public void setOriginRequestURL(String originRequestURL) {
        this.originRequestURL = originRequestURL;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginProcessURI() {
        return originProcessURI;
    }

    public void setOriginProcessURI(String originProcessURI) {
        this.originProcessURI = originProcessURI;
    }

    public String getOriginResultURL() {
        return originResultURL;
    }

    public void setOriginResultURL(String originResultURL) {
        this.originResultURL = originResultURL;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }

    public Boolean getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(Boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public Boolean getIsLeech() {
        return isLeech;
    }

    public void setIsLeech(Boolean isLeech) {
        this.isLeech = isLeech;
    }

    public Boolean getIsServe() {
        return isServe;
    }

    public void setIsServe(Boolean isServe) {
        this.isServe = isServe;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getFinalURL() {
        return finalURL;
    }

    public void setFinalURL(String finalURL) {
        this.finalURL = finalURL;
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
        if (!(object instanceof URLData)) {
            return false;
        }
        URLData other = (URLData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.URLData[ id=" + id + " ]";
    }
    
}
