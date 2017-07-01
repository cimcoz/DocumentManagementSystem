/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;


import com.documentsystem.model.Businesspartner;
import com.documentsystem.model.Customer;
import com.documentsystem.model.Invoice;
import java.util.List;
import view.BusinessPartnerTableModel;

/**
 *
 * @author Asus
 */
public class SOGetInvoiceListConditional extends OpstaSO {
    
    List<Invoice> il;
    Businesspartner bp = new Businesspartner();
//Customer customerID = new Customer();

public SOGetInvoiceListConditional(Businesspartner bp) {
        this.bp = bp;
    }

   
    @Override
    protected void izvrsiOperaciju() throws Exception {
        il = db.getInvoiceListConditional((Businesspartner)bp);
    }

    public List<Invoice> getInvoiceListConditional(Businesspartner bp) {

        return il;
    }
}
