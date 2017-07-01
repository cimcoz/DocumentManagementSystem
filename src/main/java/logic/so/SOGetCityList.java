/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.City;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SOGetCityList extends OpstaSO{

    List<City> lc;
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
        lc = db.getCityList();
    }
   public List<City> getCityList(){
    return lc;
    }
}
