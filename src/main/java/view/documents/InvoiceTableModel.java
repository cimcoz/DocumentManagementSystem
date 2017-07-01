/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.documents;

import com.documentsystem.model.Invoice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class InvoiceTableModel extends AbstractTableModel{
  private List<Invoice> invoices;
  private final String[] columns = { "invoiceID", "Customer ID", "Date", "Total Cost" , "Business Partner"};
  
  public InvoiceTableModel(List<Invoice> invoices)
  {
    this.invoices= invoices;
  }
  
  @Override
  public int getRowCount()
  {
    if (invoices == null) {
      return 0;
    }
    return invoices.size();
  }
  
  @Override
  public int getColumnCount()
  {
    return columns.length;
  }
  

  @Override
  public Object getValueAt(int row, int column)
  {
   Invoice p = invoices.get(row);
    switch (column)
    {
    case 0: 
      return p.getInvoiceID();
    case 1: 
      return p.getCustomer().getCustomerID();
    case 2: 
      return p.getInvoiceDate();
    case 3:
        return p.getTotalCost();
        case 4:
        return p.getBp();
    
    }
    return "n/a";
  }
  


  @Override
  public String getColumnName(int column)
  {
    return columns[column];
  }
  


  
  public Invoice getInvoice(int row)
  {
    return invoices.get(row);
  }
  
  public void addRow()
  {
    invoices.add(new Invoice());
    System.out.println("New Invoice Added!");
    fireTableDataChanged();
  }
  
  public void deleteRow(int row) {
    invoices.remove(row);
    System.out.println("Row deleted!");
    fireTableDataChanged();
  }
  
  public List<Invoice> getInvoices()
  {
    return invoices;
  }
    
    
}
