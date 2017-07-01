/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.documentsystem.model.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class RoleCollection {
    
    private List<Role> rc;
    
    public RoleCollection(){
    
    rc = new ArrayList();
    
    }
    
    public void addRole(Role r){
    
    rc.add(r);
    }
    public List<Role> getRoleList(){
    return rc;
    }
    
    
 }
    

