/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Asus
 */

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
   @Column(name = "orderID")
    private int orderID;
    @Column(name = "orderDate")
     @Temporal(TemporalType.DATE)
    private Date orderDate;
     @ManyToOne  
   @JoinColumn(foreignKey = @ForeignKey(name = "customerID"))
    
    private Customer customerID;
    
    @Column(name = "totalCost")
    private int totalCost;
    
    public Order(){}

    public Order(int orderID, Date orderDate, Customer customerID, int totalCost) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customerID = customerID;
        this.totalCost = totalCost;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Order id :" + " "+orderID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.orderID;
        hash = 59 * hash + Objects.hashCode(this.customerID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderID != other.orderID) {
            return false;
        }
        if (!Objects.equals(this.customerID, other.customerID)) {
            return false;
        }
        return true;
    }

   
    
    
}
