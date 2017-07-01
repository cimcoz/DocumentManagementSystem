/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.documentsystem.model.Users;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class UserCollection {
    private List<Users> lp;
    
      public UserCollection()
  {
    lp = new ArrayList();
  }
  
  public void addUser(Users u) {
    lp.add(u);
  }
  
  public List<Users> getUsers() {
    return lp;
  }
    
}
