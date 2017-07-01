/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Users;

/**
 *
 * @author User
 */
public class SOLogIn extends OpstaSO{
    private Users user;

    public SOLogIn(Users user) {
        this.user=user;
    }
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
        user=db.loginUser(user);
    }
    
    public Users getUser(){
        return user;
    }
    
}
