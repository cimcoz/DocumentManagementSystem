/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.documents;


import com.documentsystem.model.Invoice;
import com.documentsystem.model.OrderItem;
import com.documentsystem.model.Products;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class OrderItemTableModel extends AbstractTableModel{
//     private List<OrderItem> orderItemList;
    Invoice invoice;
    //private Invoice invoice;
    private final String[] columns = {"Product", "Quantity", "Cost"};
   
   public OrderItemTableModel (Invoice invoice){
   
   this.invoice= invoice;
   }
   
//    public OrderItemTableModel(List<OrderItem> orderItemList)
//  {
//    this.orderItemList= orderItemList;
//  }

    OrderItemTableModel() {
    }
   public Invoice getInvoice(){
   return invoice;
   }
   public void setInvoice(Invoice invoice){
   
   this.invoice=invoice;
   }
    
    @Override
    public int getRowCount() {
       if (invoice != null && invoice.getOrderItemList() != null) {
            return invoice.getOrderItemList().size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderItem orderItem = invoice.getOrderItemList().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return orderItem.getProduct().getProductID();
                
            case 1:
                return orderItem.getQuantity();
            case 2:
                return orderItem.getCost();
            default:
                return "n/a";
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 2) {
            return false;
        }
        return true;
    }
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

  @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       OrderItem orderItem = invoice.getOrderItemList().get(rowIndex);
        switch (columnIndex) {
            case 0:
               orderItem.setProduct((Products) aValue);
               orderItem.setCost(orderItem.getQuantity() * orderItem.getProduct().getProductPrice());
                fireTableCellUpdated(rowIndex, columnIndex + 2);
               break;
            case 1:
                orderItem.setQuantity(Integer.parseInt((String) aValue));
                 orderItem.setCost(orderItem.getQuantity() * orderItem.getProduct().getProductPrice());
                fireTableCellUpdated(rowIndex, columnIndex + 1);
                break;
            case 2:
// total not editable
            break;
                
        } 
    }

    public void addOrderItem(){
    invoice.addOrderItem();
   fireTableDataChanged();
    }
   


    
    public void deleteOrderItem(int red) {
        invoice.getOrderItemList().remove(red);
        fireTableDataChanged();
    }
    
    
public List<OrderItem> getOrderItemList(){
return invoice.getOrderItemList();

}
public OrderItem getOrderItem(int red){

return invoice.getOrderItemList().get(red);
}

}
