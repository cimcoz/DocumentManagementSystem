/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Businesspartner;
import java.util.List;

/**
 *
 * @author User
 */
public class SOGetPartnerList extends OpstaSO{
    List<Businesspartner> partneri;
    @Override
    protected void izvrsiOperaciju() throws Exception {
        partneri=db.getPartners();
    }

    public List<Businesspartner> getPartnerList() {
        return partneri;
    }
    
    
}
