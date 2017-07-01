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
 * @author Asus
 */
public class SOSavePartnerList extends OpstaSO{

    Businesspartner bp;
    List<Businesspartner> pl;
    
    public SOSavePartnerList(List<Businesspartner> pl) {
        this.pl = pl;
    }
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
       for (Businesspartner bp : pl) {
            db.savePartner(bp);
            System.out.println("Saved Partner Id = " + bp.getBpID());
        } 
    }
    
}
