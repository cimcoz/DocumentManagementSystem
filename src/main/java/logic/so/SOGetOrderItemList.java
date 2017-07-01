/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Invoice;
import com.documentsystem.model.OrderItem;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SOGetOrderItemList extends OpstaSO{    
    Invoice invoice;
   // int invoiceID = invoice.getInvoiceID();
    List<OrderItem> oil;
    
    public SOGetOrderItemList(Invoice invoice) {
        this.invoice = invoice;
    }
    @Override
    protected void izvrsiOperaciju() throws Exception {
      oil = db.getOrderItemList(invoice);
    }
    public List<OrderItem> getOrderItemList(){
    return oil;
    }
}
