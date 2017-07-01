/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentsystem.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class OrderItemID implements Serializable{
     private int orderNumber;
     private int product;
     private int invoice;
     
      @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.orderNumber;
        hash = 17 * hash + Objects.hashCode(this.product);
        hash = 17 * hash + Objects.hashCode(this.invoice);
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
        final OrderItem other = (OrderItem) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.invoice, other.invoice)) {
            return false;
        }
        return true;
    }
}
