/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Positions;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SOSavePositionList extends OpstaSO{
    Positions p;
    List<Positions> pl;

    public SOSavePositionList(List<Positions> pl) {
        this.pl = pl;
    }
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
     for (Positions p : pl) {
            db.savePosition(p);
            System.out.println("Saved Position Id = " + p.getPosID());
        }
    }
    
}
