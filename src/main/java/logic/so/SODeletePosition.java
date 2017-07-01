/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Positions;

/**
 *
 * @author Asus
 */
public class SODeletePosition extends OpstaSO{
    
    Positions p;
    int posID;

    public SODeletePosition(int posID) {
        this.posID = posID;
    }
    
    
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
    db.delPosition(posID);
    }
    
}
