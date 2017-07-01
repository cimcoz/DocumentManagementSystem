/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Businesspartner;
import java.util.List;
import view.BusinessPartnerTableModel;

/**
 *
 * @author Asus
 */
public class SOGetPartnerListConditional extends OpstaSO{
    List<Businesspartner> partners;
    
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
       partners=db.getPartnersConditional();
    }
    
    public List<Businesspartner> getPartnersConditional(){
    return partners;
    }
}
