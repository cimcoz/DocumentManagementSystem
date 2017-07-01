/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    @Column(name = "totalCost")
    private Double totalCost;

    @Column(name = "invoiceID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int invoiceID;
    @Column(name = "invoiceDate")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    //@MapsId
    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "customerID")
    private Customer customer;
//@ElementCollection
//@CollectionTable(name = "orderitem" )
    @OneToMany(targetEntity = OrderItem.class, mappedBy = "invoice", fetch = FetchType.EAGER)
    //@OneToMany
    private List<OrderItem> orderItemList;

    
   @ManyToOne
    @JoinColumn(name = "businessPartnerID", referencedColumnName = "BpID")
  
     private Businesspartner bp;
    

    public Invoice(int invoiceID, Customer customer, Date invoiceDate, double totalCost, Businesspartner bp) {
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.totalCost = totalCost;
        this.customer = customer;
        this.bp = bp;
    }

    public Invoice(Customer customer, Date invoiceDate, double totalCost) {
        //this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.totalCost = totalCost;
        this.customer = customer;
    }

    public Invoice() {
        orderItemList = new ArrayList<>();
    }

    public Invoice(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Businesspartner getBp() {
        return bp;
    }

    public void setBp(Businesspartner bp) {
        this.bp = bp;
    }

//    public Invoice(int invoiceID, Date date, double totalCost, int customerID) {
//        this.invoiceID = invoiceID;
//        this.invoiceDate = date;
//        this.totalCost = totalCost;
//        this.customerid = customerID;
//    }
    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void addOrderItem() {
        orderItemList.add(new OrderItem());

    }

    public OrderItem getOrderItem(Products p) {
        for (OrderItem o : orderItemList) {
            if (o.getProduct() == p) {
                return o;
            }
        }

        return null;

    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

}
