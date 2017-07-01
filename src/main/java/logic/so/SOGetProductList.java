/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Products;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SOGetProductList extends OpstaSO{
    Products p;
    List<Products> pl;
    @Override
    protected void izvrsiOperaciju() throws Exception {
       pl= db.getProductList();
    }
    public List<Products> getProductList(){
    
    return pl;
    };
}
