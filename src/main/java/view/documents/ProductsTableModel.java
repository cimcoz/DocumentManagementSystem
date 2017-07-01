/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.documents;

import com.documentsystem.model.Products;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class ProductsTableModel extends AbstractTableModel{
    List<Products> productList;
    
    public ProductsTableModel(List<Products> productList){
    
    this.productList = productList;
    }
    
    @Override
    public int getRowCount() {
       return productList.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Products p =productList.get(rowIndex);
       switch(columnIndex){
           
           case 0: return p.getProductID();
           case 1: return p.getProductName();
           case 2: return p.getProductPrice();
          
           default: return "N/A"; 
           
       }}
    
     @Override
    public String getColumnName(int column) {
        switch(column){
           case 0: return "Product ID";
           case 1: return "Name";
           case 2: return "Price";
           
           default: return "N/A";
       }
    }
    
    public Products getProduct(int selectedRow){
    
    return productList.get(selectedRow);
    }
    
}
