/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "businesspartner")
public class Businesspartner implements Serializable {

    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bpID")
    private Collection<Positions> positionsCollection;

//    @ManyToMany
//    private Collection<Positions> positionsCollection;

    @OneToMany(mappedBy = "busPartner_fk")
    private Collection<Users> usersCollection;

    @OneToMany(mappedBy = "businessPartnerID")
    private Collection<Customer> customerCollection;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BpID")
    private int bpID;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "City", referencedColumnName = "cityName")

    private City cityName;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "Address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "zip", referencedColumnName = "Zip")
    private City zip;

    public Businesspartner() {
    }

    public Businesspartner(int bpID, String name) {
        this.bpID = bpID;
        this.name = name;
    }

    public Businesspartner(String name, City city, String accountNumber, String address) {
        this.name = name;
        this.cityName = city;
        this.accountNumber = accountNumber;
        this.address = address;
        this.zip = city;

    }

//    public Businesspartner(Integer bpID, String name, City city, String accountNumber, String address, int zipc) {
//        this.bpID = bpID;
//        this.name = name;
//        this.cityName = city;
//        this.accountNumber = accountNumber;
//        this.address = address;
//        this.zipc = zipc;
//       
//    }
//    public Businesspartner(Integer bpID, String name, City city, String accountNumber, String address) {
//        this.bpID = bpID;
//        this.name = name;
//        this.cityName = city;
//        this.accountNumber = accountNumber;
//        this.address = address;
//        
//    }
    public Businesspartner(Integer bpID, String name, City city, String accountNumber, String address, City zip) {
        this.bpID = bpID;
        this.name = name;
        this.cityName = city;
        this.accountNumber = accountNumber;
        this.address = address;
        this.zip = zip;

    }

    public City getZip() {
        return zip;
    }

    public void setZip(City zip) {
        this.zip = zip;
    }

    public Businesspartner(int bpID) {
        this.bpID = bpID;
    }

    public Businesspartner(String bp) {
        this.name = bp;
    }

    public Integer getBpID() {
        return bpID;
    }

    public void setBpID(Integer bpID) {
        this.bpID = bpID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return cityName;
    }

    public void setCity(City city) {
        this.cityName = city;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return bpID + " " + name;
    }

//    @XmlTransient
//    public Collection<Positions> getPositionsCollection() {
//        return positionsCollection;
//    }
//
//    @Cascade (org.hibernate.annotations.CascadeType.ALL)
//    public void setPositionsCollection(Collection<Positions> positionsCollection) {
//        this.positionsCollection = positionsCollection;
//    }
//
    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }



    @XmlTransient
    public Collection<Positions> getPositionsCollection() {
        return positionsCollection;
    }

    public void setPositionsCollection(Collection<Positions> positionsCollection) {
        this.positionsCollection = positionsCollection;
    }
}
