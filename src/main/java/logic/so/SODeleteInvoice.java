/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Invoice;

/**
 *
 * @author Asus
 */
public class SODeleteInvoice extends OpstaSO{

    Invoice i;
   int  invoiceID;

    public SODeleteInvoice(int invoiceID) {
        this.invoiceID = invoiceID;
    }
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.delInvoice(invoiceID);
    }
    
}
