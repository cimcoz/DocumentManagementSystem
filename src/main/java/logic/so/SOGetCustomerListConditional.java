/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Businesspartner;
import com.documentsystem.model.Customer;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SOGetCustomerListConditional extends OpstaSO {

    List<Customer> customerList;
    Businesspartner businessPartnerID = new Businesspartner();
//   int bpid = bp.getBpID();

    public SOGetCustomerListConditional(Businesspartner bpid) {
        this.businessPartnerID = bpid;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {

        customerList = db.getCustomerListConditional((Businesspartner) businessPartnerID);
    }

    public List<Customer> getCustomerListConditional(Businesspartner bpid) {
        return customerList;
    }

}
