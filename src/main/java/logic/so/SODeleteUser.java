/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Users;
import logic.so.OpstaSO;

/**
 *
 * @author Asus
 */
public class SODeleteUser extends OpstaSO{

    private Users u;
    int userID;

    public SODeleteUser(int userID) {
        this.userID= userID;
    }
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.delUser(userID);
    }
    
}
