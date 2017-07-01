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
public class SODeletePartner extends OpstaSO{
//   private Businesspartner bp;
   int bpid;

    public SODeletePartner(int bpid) {
        this.bpid = bpid;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.delPartner(bpid);
    }
    

    
}
