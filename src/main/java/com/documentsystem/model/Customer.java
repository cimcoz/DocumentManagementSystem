/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {


    @OneToMany(mappedBy = "customer")
    private Collection<Invoice> invoiceCollection;

    @Column(name = "customerID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "customerAddress")
    private String customerAddress;
    //@MapsId

    @JoinColumn(name = "createdBy", referencedColumnName = "name")
    @ManyToOne
    //@Cascade(CascadeType.ALL)
    private Users user;

    @JoinColumn(name = "businessPartnerID", referencedColumnName = "BpID")
@ManyToOne
    private Businesspartner businessPartnerID;

    public Customer() {
    }

    public Customer(int customerID) {
        this.customerID = customerID;
    }

    public Customer(int customerID, String customerName, String customerAddress, Users user, Businesspartner bp) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.user = user;
        this.businessPartnerID = bp;
    }
    
    

//    public Customer(int customerID, String customerName, String customerAddress, String user, Businesspartner bp) {
//        this.customerID = customerID;
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
//        this.users = user;
//        this.businessPartnerID = bp;
//
//    }
//    public Customer(String customerName, String customerAddress, String user, Businesspartner bp) {
//
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
//        this.users = user;
//        this.businessPartnerID = bp;
//    }
    public Customer(String customerName, String customerAddress, Users user, Businesspartner bp) {

        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.user = user;
        this.businessPartnerID = bp;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Businesspartner getBp() {
        return businessPartnerID;
    }

    public void setBp(Businesspartner bp) {
        this.businessPartnerID = bp;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
//ne diraj
    public Users getCreatedby() {
        return user;
    }

    public void setCreatedby(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return customerName + " " + customerID;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 47 * hash + this.customerID;
//
//        hash = 47 * hash + Objects.hashCode(this.businessPartnerID);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Customer other = (Customer) obj;
//        if (this.customerID != other.customerID) {
//            return false;
//        }
//
//        return true;
//    }
//    @XmlTransient
//    public Collection<Invoice> getInvoiceCollection() {
//        return invoiceCollection;
//    }
//
//    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
//        this.invoiceCollection = invoiceCollection;
//    }
//
//    public Businesspartner getBusinessPartnerID() {
//        return businessPartnerID;
//    }
//
//    public void setBusinessPartnerID(Businesspartner businessPartnerID) {
//        this.businessPartnerID = businessPartnerID;
//    }
}
