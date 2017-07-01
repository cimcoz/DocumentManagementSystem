/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Invoice;
import com.documentsystem.model.OrderItem;

/**
 *
 * @author User
 */
public class SOSaveInvoice extends OpstaSO{
        
    private Invoice invoice;
    double totalCost = 0;
    int orderNumber = 0;
   
    
    public SOSaveInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    

       
    @Override
    protected void izvrsiOperaciju() throws Exception {
        for (OrderItem s : invoice.getOrderItemList()) {
            orderNumber++;
            s.setOrderNumber(orderNumber);
            totalCost = totalCost + s.getCost();
        }
        invoice.setTotalCost(totalCost);
     db.saveInvoice(invoice);
    }

}
