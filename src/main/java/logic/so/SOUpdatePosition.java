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
public class SOUpdatePosition extends OpstaSO{
    Positions p;

    public SOUpdatePosition(Positions p) {
        this.p = p;
    }
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.updatePosition(p);
    }
    
    
}
