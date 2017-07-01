/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.documentsystem.model.Positions;
import com.documentsystem.model.Role;
import com.documentsystem.model.Users;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class UsersTableModel 
extends AbstractTableModel
{
  private List<Users> users;
  private final String[] columns = { "User ID", "Name", "Last Name", "Username", "Role", "Position", "Business partner" };
  
  public UsersTableModel(List<Users> users)
  {
    this.users = users;
  }
  
  @Override
  public int getRowCount()
  {
    if (users == null) {
      return 0;
    }
    return users.size();
  }
  
  @Override
  public int getColumnCount()
  {
    return columns.length;
  }
  

  @Override
  public Object getValueAt(int row, int column)
  {
   Users p = users.get(row);
    switch (column)
    {
    case 0: 
      return p.getUserID();
    case 1: 
      return p.getName();
    case 2: 
      return p.getLastName();
    case 3:
        return p.getUsername();
    //case 4:
      //  return p.getPassword();
    case 4:
        return p.getRoleFk();
    case 5:
        return p.getPos();
        case 6:
        return p.getBp();
    }
    return "n/a";
  }
  


  @Override
  public String getColumnName(int column)
  {
    return columns[column];
  }
  

//
//  @Override
//  public void setValueAt(Object aValue, int row, int column)
//  {
//    Users p = users.get(row);
//    switch (column)
//    {
//    case 0: 
//      p.setUserID(Integer.parseInt((String)aValue));
//      
//    case 1: 
//      p.setName((String)aValue);
//     
//    case 2: 
//      p.setLastName((String)aValue);
//       
//       case 3: 
//      p.setUsername((String)aValue);
//      
//       case 4: 
//      p.setPassword((String)aValue);
//       
//       case 5: 
//      p.setRoleFk((Role)aValue);
//       
//       case 6: 
//      p.setPos((Positions)aValue);
//      
//    }
//    
//    
//    fireTableCellUpdated(row, column);
//  }
  
  public Users getUser(int row)
  {
    return users.get(row);
  }
  
  public void addRow()
  {
    users.add(new Users());
    System.out.println("New User Added!");
    fireTableDataChanged();
  }
  
  public void deleteRow(int row) {
    users.remove(row);
    System.out.println("Row deleted!");
    fireTableDataChanged();
  }
  
  public List<Users> getUsers()
  {
    return users;
  }
    
    
    
}
