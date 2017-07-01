/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Businesspartner;

/**
 *
 * @author Asus
 */
public class SOAddPartner extends OpstaSO{

    private Businesspartner bp;
    
    public SOAddPartner(Businesspartner bp){
    this.bp = bp;
    }
    @Override
    protected void izvrsiOperaciju() throws Exception {
     db.savePartner(bp);
    }
    
}
