/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author Asus
 */

@Entity
@Table(name = "orderitem")
@IdClass(OrderItemID.class)
public class OrderItem {

//    @EmbeddedId
//    protected com.documentsystem.model.OrderItemID orderItemID;
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private double cost;

    @Id
   @Column(name = "orderNumber")
     int orderNumber;
   @MapsId
    @Id
   @JoinColumn(name = "productID" ) 
    @OneToOne
    Products product;
   //@MapsId
     @Id
   @JoinColumn(name = "InvoiceID" )
    @OneToOne
     Invoice invoice;
     
//     public OrderItem() {
//   
//    }
     
    public OrderItem(){
        
      product = new Products();
    }

    public OrderItem(int orderNumber, int quantity, double cost, Products product) {
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.cost = cost;
        this.product = product;
    }

    public OrderItem(Invoice invoice, int orderNumber, int quantity, double cost, Products c) {
        this.orderNumber = orderNumber;
        this.quantity = quantity;
        this.cost = cost;
        this.product = c;
        this.invoice = invoice;
    }

    
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }


    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
    
    
}
