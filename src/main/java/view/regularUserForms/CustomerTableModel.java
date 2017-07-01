/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.regularUserForms;

import com.documentsystem.model.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class CustomerTableModel 
      extends AbstractTableModel
{
  private List<Customer> c;
  private final String[] columns = { "ID", "Customer Name", "Address", "Created by", "Business Partner" };
  
  public CustomerTableModel(List<Customer> c)
  {
    this.c = c;
  }
  
  @Override
  public int getRowCount()
  {
    if (c == null) {
      return 0;
    }
    return c.size();
  }
  
  @Override
  public int getColumnCount()
  {
    return columns.length;
  }
  

  @Override
  public Object getValueAt(int row, int column)
  {
    Customer p = (Customer)c.get(row);
    switch (column)
    {
    case 0: 
      return p.getCustomerID();
    case 1: 
      return p.getCustomerName();
    case 2: 
      return p.getCustomerAddress();
    case 3:
        return p.getUser();
        //getCreatedBy() nece u hib
    case 4:
        return p.getBp().getBpID();    
        // nece sa p.getBp().getBpID();
    }
    return "n/a";
  }
  


  @Override
  public String getColumnName(int column)
  {
    return columns[column];
  }
  


//  @Override
//  public void setValueAt(Object aValue, int row, int column)
//  {
//    Customer p = (Customer)c.get(row);
//    switch (column)
//    {
//    case 0: 
//      p.setCustomerID(Integer.parseInt((String)aValue));
//      break;
//    case 1: 
//      p.setCustomerName((String)aValue);
//      break;
//    case 2: 
//      p.setCustomerAddress((String)aValue);
//    }
//    
//    
//    fireTableCellUpdated(row, column);
//  }
  
  public Customer getCustomer(int row)
  {
    return c.get(row);
  }
  
  public void addRow()
  {
    c.add(new Customer());
    System.out.println("New Customer Added!");
    fireTableDataChanged();
  }
  
  public void deleteRow(int row) {
    c.remove(row);
    System.out.println("Row deleted!");
    fireTableDataChanged();
  }
  
  public List<Customer> getCustomerListConditional()
  {
    return c;
  }
  
}
