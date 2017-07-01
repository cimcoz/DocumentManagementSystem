/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Users;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SOGetUserList extends OpstaSO{

    List<Users> userList;
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
        userList = db.getUserList();
    }
    
    public List<Users> getUserList(){
    
    return userList;
    }
    
}
