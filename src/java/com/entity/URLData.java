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
@Table(name = "tblurldata", catalog = "getlink", schema = "")
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
    @Basic(optional = false)
    @Column(name = "originRequestURL", nullable = false, length = 255)
    private String originRequestURL;
    @Basic(optional = false)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic(optional = false)
    @Column(name = "originProcessURI", nullable = false, length = 255)
    private String originProcessURI;
    @Basic(optional = false)
    @Column(name = "originResultURL", nullable = false, length = 255)
    private String originResultURL;
    @Basic(optional = false)
    @Column(name = "identity", nullable = false, length = 255)
    private String identity;
    @Basic(optional = false)
    @Column(name = "status", nullable = false)
    private int status;
    @Basic(optional = false)
    @Column(name = "retry", nullable = false)
    private int retry;
    @Basic(optional = false)
    @Column(name = "isProcessed", nullable = false)
    private boolean isProcessed;
    @Basic(optional = false)
    @Column(name = "isLeech", nullable = false)
    private boolean isLeech;
    @Basic(optional = false)
    @Column(name = "isServe", nullable = false)
    private boolean isServe;
    @Basic(optional = false)
    @Column(name = "receiveTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveTime;
    @Basic(optional = false)
    @Column(name = "finalURL", nullable = false, length = 255)
    private String finalURL;

    public URLData() {
    }

    public URLData(Integer id) {
        this.id = id;
    }

    public URLData(Integer id, String originRequestURL, String password, String originProcessURI, String originResultURL, String identity, int status, int retry, boolean isProcessed, boolean isLeech, boolean isServe, Date receiveTime, String finalURL) {
        this.id = id;
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
    
    public URLData( String originRequestURL, String password, String originProcessURI, String originResultURL, String identity, int status, int retry, boolean isProcessed, boolean isLeech, boolean isServe, Date receiveTime, String finalURL) {
        
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public boolean getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public boolean getIsLeech() {
        return isLeech;
    }

    public void setIsLeech(boolean isLeech) {
        this.isLeech = isLeech;
    }

    public boolean getIsServe() {
        return isServe;
    }

    public void setIsServe(boolean isServe) {
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
        return String.valueOf(this.originProcessURI.length());
    }
    
}
