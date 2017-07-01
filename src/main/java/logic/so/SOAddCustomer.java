/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Customer;
import com.documentsystem.model.Products;

/**
 *
 * @author Asus
 */
public class SOAddCustomer extends OpstaSO {

    Customer c;

    public SOAddCustomer(Customer c) {
        this.c = c;
    }


    @Override
    protected void izvrsiOperaciju() throws Exception {
//        
        db.saveCustomer(c);
    }

}
