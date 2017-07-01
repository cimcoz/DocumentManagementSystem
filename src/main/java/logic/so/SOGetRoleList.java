/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.so;

import com.documentsystem.model.Role;
import java.util.List;

/**
 *
 * @author Asus
 */
public class SOGetRoleList extends OpstaSO{
    
    Role r;
    List<Role> roleList;

   
    
    @Override
    protected void izvrsiOperaciju() throws Exception {
       roleList = db.getRoleList();
    }
   public List<Role> getRoleList(){
    return roleList;
    }
}
