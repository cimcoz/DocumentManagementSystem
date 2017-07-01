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
public class SODeleteCustomer  extends OpstaSO{

    Customer c;
    int customerID;

    public SODeleteCustomer(int customerID) {
        this.customerID = customerID;
    }
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
       db.delCustomer(customerID);
    }
    
}
