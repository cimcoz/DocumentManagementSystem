/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Users;

/**
 *
 * @author Asus
 */
public class SOAddUser extends OpstaSO{
    Users u;

    public SOAddUser(Users u) {
        this.u = u;
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
     db.saveUser(u);
    }
    
}
