/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Customer;

/**
 *
 * @author Asus
 */
public class SOUpdateCustomer extends OpstaSO {
    private Customer c;

    public SOUpdateCustomer(Customer c) {
        this.c = c;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
       db.updateCustomerInfo(c);
    }
}
