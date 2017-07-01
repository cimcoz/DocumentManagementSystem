package db;

import com.documentsystem.model.Businesspartner;
import com.documentsystem.model.City;
import com.documentsystem.model.Customer;
import com.documentsystem.model.Invoice;
import com.documentsystem.model.OrderItem;
import com.documentsystem.model.Positions;
import com.documentsystem.model.Products;
import com.documentsystem.model.Role;
import com.documentsystem.model.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DbCommunication implements DbComumunicationInterface {

    private Connection connection;

    public DbCommunication() {
    }

    public void loadDriver() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Neuspesno ucitavanje drivera!", ex);
        }
    }

    public void openConnection() throws Exception {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/docm", "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Neuspesno otvaranje konekcije!", ex);
        }
    }

    public void commitTransaction() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije!", ex);
        }
    }

    public void rollbackTransaction() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije!", ex);
        }
    }

    public void closeConnection() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno zatvaranje konekcije!", ex);
        }
    }

    public List<Role> getRoleList() throws Exception {
        try {
            List<Role> rc = new ArrayList();
            String sql = "SELECT roleid,rolename,roledescription FROM Role";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int roleID = rs.getInt(1);
                String roleName = rs.getString("RoleName");
                String roleDesc = rs.getString("RoleDescription");
                Role r = new Role(roleID, roleName, roleDesc);
                rc.add(r);
            }
            rs.close();
            sqlStatement.close();
            return rc;
        } catch (SQLException ex) {
            throw new Exception("Can not get role list!", ex);
        }
    }

    public List<City> getCityList() throws Exception {
        try {
            List<City> lc = new ArrayList();
            String sql = "SELECT zip,cityName FROM City";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int zip = rs.getInt(1);
                String cityName = rs.getString("CityName");
                City c = new City(zip, cityName);
                lc.add(c);
            }
            rs.close();
            sqlStatement.close();
            return lc;
        } catch (SQLException ex) {
            throw new Exception("Can not get city list!", ex);
        }
    }

    public Users loginUser(Users u) throws Exception {
        try {
            String sql = "Select userid,name,lastname,username,password,role_fk,positions_fk,busPartner_fk from users where username=? and password=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUsername());
            st.setString(2, u.getPassword());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                
                int userID = rs.getInt("userid");
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                
                int roleID =  rs.getInt("role_fk");
                int bpfk = rs.getInt("busPartner_fk");
                int pos = rs.getInt("positions_fk");
               Role r = new Role(roleID);
               Positions p = new Positions(pos);
               Businesspartner bp = new Businesspartner(bpfk);
               
               u = new Users(userID,name,lastName,username,pass,r,p,bp);
              

                return u;
            }

        } catch (Exception e) {

            
            e.printStackTrace();
            throw new Exception("Login error!\n" + e.getMessage());

        }
        return null;

    }

    public void savePosition(Positions pos) throws Exception {
        try {
            String sql = "INSERT INTO Positions (posname, posdescription, bpID) VALUES (?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);

            sqlStatement.setString(1, pos.getPosName());
            sqlStatement.setString(2, pos.getPosDescription());
            sqlStatement.setInt(3, pos.getBusinesspartner().getBpID());
            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("ERROR! Position not saved!", ex);
        }
    }

    public void saveUser(Users u) throws Exception {
        try {
            String sql = "INSERT INTO Users (name, lastname, username, password, role_fk, positions_fk, busPartner_fk) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);

            sqlStatement.setString(1, u.getName());
            sqlStatement.setString(2, u.getLastName());
            sqlStatement.setString(3, u.getUsername());
            sqlStatement.setString(4, u.getPassword());
            sqlStatement.setInt(5, u.getRoleFk().getRoleID());
            sqlStatement.setInt(6, u.getPos().getPosID());
            sqlStatement.setInt(7, u.getBp().getBpID());
            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("ERROR! User not saved!", ex);
        }
    }

    public void savePartner(Businesspartner bp) throws Exception {
        try {
            String sql = "INSERT INTO Businesspartner (name, city, accountNumber, address, zip) VALUES (?,?,?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sqlStatement.setString(1, bp.getName());
            sqlStatement.setString(2, bp.getCity().getCityName());
            sqlStatement.setString(3, bp.getAccountNumber());
            sqlStatement.setString(4, bp.getAddress());
            sqlStatement.setInt(5, bp.getCity().getZip());

            sqlStatement.executeUpdate();
            ResultSet rs = sqlStatement.getGeneratedKeys();
            if (rs.next()) {
                bp.setBpID(rs.getInt(1));
            }

            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("ERROR! Business Partner not saved!", ex);
        }
    }

    public void saveCustomer(Customer c) throws Exception {
        try {
            String sql = "INSERT INTO Customer (customername, customeraddress, createdby, businessPartnerID) VALUES (?,?,?,?)";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);

            sqlStatement.setString(1, c.getCustomerName());
            sqlStatement.setString(2, c.getCustomerAddress());
            sqlStatement.setString(3, c.getUser().getName());
            sqlStatement.setInt(4, c.getBp().getBpID());

            sqlStatement.executeUpdate();
//      ResultSet rs=sqlStatement.getGeneratedKeys();
//      if(rs.next()){
//          c.setCustomerID(rs.getInt(1));
//      }

            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("ERROR! Customer not saved!", ex);
        }
    }

    public void updatePartnerInfo(Businesspartner bp) throws Exception {
        try {
            String sql = "UPDATE Businesspartner SET name=?,accountNumber=?,address=?,city=?  WHERE bpid=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);

            sqlStatement.setString(1, bp.getName());
            sqlStatement.setString(2, bp.getAccountNumber());
            sqlStatement.setString(3, bp.getAddress());
            sqlStatement.setString(4, bp.getCity().getCityName());
            sqlStatement.setInt(5, bp.getBpID());

            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("ERROR! Business Partner not updated!", ex);
        }
    }

    public void updateCustomerInfo(Customer c) throws Exception {
        try {
            String sql = "UPDATE Customer SET customername=?,customeraddress=?,createdby=?, businesspartnerID=?  WHERE customerid=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);

            sqlStatement.setString(1, c.getCustomerName());
            sqlStatement.setString(2, c.getCustomerAddress());
            sqlStatement.setString(3, c.getUser().getName());
            sqlStatement.setInt(4, c.getBp().getBpID());
            sqlStatement.setInt(5, c.getCustomerID());

            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("ERROR! Customer not updated!", ex);
        }
    }

    public void updatePosition(Positions pos) throws Exception {
        try {
            String sql = "UPDATE Positions SET posName=?,posDescription=?,bpid=? WHERE posID=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);

            sqlStatement.setString(1, pos.getPosName());
            sqlStatement.setString(2, pos.getPosDescription());
            sqlStatement.setInt(3, pos.getBusinesspartner().getBpID());
            sqlStatement.setInt(4, pos.getPosID());

            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("ERROR! Position not updated!", ex);
        }
    }

    public void updateUserInfo(Users u) throws Exception {
        try {
            String sql = "UPDATE Users SET name=?,lastname=?,username=?,role_fk=?, positions_fk=?, busPartner_fk=?  WHERE userID=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);

            sqlStatement.setString(1, u.getName());
            sqlStatement.setString(2, u.getLastName());
            sqlStatement.setString(3, u.getUsername());
            sqlStatement.setInt(4, u.getRoleFk().getRoleID());
            sqlStatement.setInt(5, u.getPos().getPosID());
            sqlStatement.setInt(6, u.getBp().getBpID());
            sqlStatement.setInt(7, u.getUserID());

            sqlStatement.executeUpdate();
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("ERROR! User not updated!", ex);
        }
    }

    public void delPartner(int bpid) throws Exception {

        try {

            String sql = "DELETE FROM Businesspartner WHERE bpID=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setInt(1, bpid);

            // sqlStatement.setInt(1,bpID);
            sqlStatement.executeUpdate();
            sqlStatement.close();
        }catch (SQLException ex) {
            throw new Exception("ERROR! Partner is not deleted!", ex);
        }

    }

    public void delInvoice(int invoiceid) throws Exception {

        try {

            String sql = "DELETE FROM Invoice WHERE invoiceID=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setInt(1, invoiceid);

            sqlStatement.executeUpdate();
            sqlStatement.close();
        }catch (SQLException ex) {
            throw new Exception("ERROR! Invoice is not deleted!", ex);
        }

    }

    public void delPosition(int posID) throws Exception {

        try {

            String sql = "DELETE FROM Positions WHERE posID=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setInt(1, posID);

            sqlStatement.executeUpdate();
            sqlStatement.close();
        }catch (SQLException ex) {
            throw new Exception("ERROR! Position is not deleted!", ex);
        }

    }

    public void delUser(int userID) throws Exception {

        try {

            String sql = "DELETE FROM Users WHERE UserID=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setInt(1, userID);

            sqlStatement.executeUpdate();
            sqlStatement.close();
        }catch (SQLException ex) {
            throw new Exception("ERROR! User is not deleted!", ex);
        }

    }

    public void delCustomer(int customerID) throws Exception {

        try {

            String sql = "DELETE FROM Customer WHERE customerID=?";
            PreparedStatement sqlStatement = connection.prepareStatement(sql);
            sqlStatement.setInt(1, customerID);

            sqlStatement.executeUpdate();
            sqlStatement.close();
         }catch (SQLException ex) {
            throw new Exception("ERROR! Customr is not deleted!", ex);
        }

    }

    public List<Businesspartner> getPartners() throws Exception {
        try {
            List<Businesspartner> lp = new ArrayList();
            String sql = "SELECT p.*, c.cityName FROM Businesspartner p INNER JOIN City c ON (p.zip = c.zip)";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int bpID = rs.getInt("BpID");
                String name = rs.getString(2);

                String accountNumber = rs.getString("AccountNumber");
                String address = rs.getString("Address");
                int zip = rs.getInt("Zip");
                String cityName = rs.getString(5);
                City c = new City(zip, cityName);
                Businesspartner p = new Businesspartner(bpID, name, c, accountNumber, address,c);
                lp.add(p);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Loading Business Partners failed!", ex);
        }
    }
    //sa uslovom

    public List<Businesspartner> getPartnersConditional() throws Exception {
        try {
            List<Businesspartner> lp = new ArrayList();
            String sql = "SELECT  b.*, u.* FROM businesspartner b, users u WHERE b.bpid = u.buspartner_fk";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int bpID = rs.getInt("BpID");
                String name = rs.getString(2);

                Businesspartner p = new Businesspartner(bpID, name);
                lp.add(p);
            }
            return lp;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Loading Business Partners failed condition!", ex);

        }

    }

    public List<Positions> getPositionList() throws Exception {
        try {
            List<Positions> lp = new ArrayList();
//String sql = "SELECT * FROM Positions";     
            String sql = "SELECT p.*, c.BpID FROM Positions p INNER JOIN Businesspartner c ON (p.BpID = c.BpID)";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int posID = rs.getInt(1);
                String posName = rs.getString("PosName");
                String posDescription = rs.getString("PosDescription");
                int BpID = rs.getInt(4);
                Businesspartner bp = new Businesspartner(BpID);
                Positions p = new Positions(posID, posName, posDescription, bp);

                lp.add(p);
            }
            return lp;
            // rs.close();
            //sqlStatement.close();

        } catch (SQLException ex) {
            throw new Exception("Can not get position list!", ex);
        }
    }

    public List<Users> getUserList() throws Exception {
        try {
            List<Users> lp = new ArrayList();
            String sql = "Select userid,name,lastname,username,password,role_fk,positions_fk,buspartner_fk from Users";
//String sql = "SELECT p.*, FROM Users p INNER JOIN Role c ON (p.rolefk = c.roleID)";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int UserID = rs.getInt("UserID");
                String name = rs.getString(2);
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int role = rs.getInt(6);
                int pos = rs.getInt(7);
                int bp = rs.getInt(8);
                Role r = new Role(role);
                Positions p = new Positions(pos);
                Businesspartner bpp = new Businesspartner(bp);
                //String businesspartner = rs.getString("businesspartner");
                //Role c = new Role(roleID,roleName);

                Users u = new Users(UserID, name, lastname, username, password, r, p, bpp);
                lp.add(u);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Loading Users failed!", ex);
        }
    }

    public List<Customer> getCustomerList() throws Exception {
        try {
            List<Customer> lp = new ArrayList();
            String sql = "Select customerid,customername,customeraddress,createdby,businesspartnerid from Customer";

            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int customerID = rs.getInt(1);
                String name = rs.getString("customerName");
                String address = rs.getString("customerAddress");
                String user = rs.getString("createdBy");
                int bpp = rs.getInt("businessPartnerID");
                Businesspartner bp = new Businesspartner(bpp);
                Users u = new Users(user);

                Customer c = new Customer(customerID, name, address, u, bp);
                lp.add(c);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Loading Customers failed!", ex);
        }
    }
    
    
     public List<Customer> getCustomerListConditional(Businesspartner bpid) throws Exception {
        try {
             
            List<Customer> lp = new ArrayList();
            String sql = "Select customerid,customername,customeraddress,createdby,businesspartnerid from Customer WHERE businesspartnerid ="+bpid.getBpID();
            System.out.println(sql);

            Statement sqlStatement = connection.createStatement();
          
            ResultSet rs = sqlStatement.executeQuery(sql);
            System.out.println("radi");
            while (rs.next()) {
                int customerID = rs.getInt(1);
                System.out.println("id");
                System.out.println(customerID);
                String name = rs.getString("customerName");
                System.out.println("customername");
                System.out.println(name);
                String address = rs.getString("customerAddress");
                System.out.println(address);
                String users = rs.getString("createdBy");
                System.out.println("createdby");
                System.out.println(users);
                int bpp = rs.getInt("businessPartnerID");
                System.out.println("bus par ID int");
                System.out.println(bpp);
                Businesspartner bp = new Businesspartner(bpp);
                System.out.println("bus par id obj");
                System.out.println(bpp);
                Users u = new Users(users);

                Customer c = new Customer(customerID, name, address, u, bp);
                System.out.println("konstruktor");
                lp.add(c);
                System.out.println("add");
            }
            return lp;
            
        } catch (SQLException ex) {ex.printStackTrace();
            throw new Exception("Loading Customers failed!", ex);
        }
    }

    public List<Products> getProductList() throws Exception {
        try {
            List<Products> lp = new ArrayList<>();
            String sql = "SELECT productid,productname,productprice FROM Product";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                int productID = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                double price = rs.getDouble("ProductPrice");
                Products p = new Products(productID, name, price);
                lp.add(p);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Failed to load products list!", ex);
        }
    }

    public List<Invoice> getInvoiceList() throws Exception {
        try {
            List<Invoice> lp = new ArrayList<>();
            String sql = "SELECT invoiceid,customerid,invoicedate,totalcost, businesspartnerid FROM Invoice";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                
                int invoiceID = rs.getInt("InvoiceID");
                int customerID = rs.getInt("CustomerID");
                Date date = rs.getDate("invoiceDate");
                double totalCost = rs.getDouble("totalCost");
                int bpid = rs.getInt("businessPartnerID");
                Customer c = new Customer(customerID);
                Businesspartner bp = new Businesspartner(bpid);
                Invoice i = new Invoice(invoiceID, c, date, totalCost,bp);
                lp.add(i);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Failed to load products list!", ex);
        }
    }
    
     @Override
    public List<Invoice> getInvoiceListConditional(Businesspartner bp) throws Exception {
           try {
            List<Invoice> lp = new ArrayList<>();
            String sql = "SELECT invoiceid,customerid,invoicedate,totalcost, businesspartnerid FROM Invoice WHERE businesspartnerid=" +bp.getBpID();
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            while (rs.next()) {
                
                int invoiceID = rs.getInt("InvoiceID");
                int customerID = rs.getInt("CustomerID");
                Date date = rs.getDate("invoiceDate");
                double totalCost = rs.getDouble("totalCost");
                int bpid = rs.getInt("businessPartnerID");
                Customer c = new Customer(customerID);
                Businesspartner bpp = new Businesspartner(bpid);
                Invoice i = new Invoice(invoiceID, c, date, totalCost,bpp);
                lp.add(i);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Failed to load products list!", ex);
        }
    }

    public List<OrderItem> getOrderItemList(Invoice invoiceID) throws Exception {
        try {
            List<OrderItem> lp = new ArrayList<>();
           //String sql = "SELECT o.*, i.InvoiceID FROM OrderItem o INNER JOIN Invoice i WHERE (o.InvoiceID = i.InvoiceID)";
          String sql = "SELECT invoiceid,ordernumber,quantity,cost,productid FROM OrderItem WHERE invoiceID= " + invoiceID.getInvoiceID();
            //String sql = "SELECT ordernumber,quantity,cost,productid FROM OrderItem WHERE invoiceID=? ";
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);

            while (rs.next()) {
                int invoiceId = rs.getInt("invoiceID");
                int orderNumber = rs.getInt("OrderNumber");
                int quantity = rs.getInt("quantity");
                double cost = rs.getDouble("cost");
                int productID = rs.getInt("productID");
                Products c = new Products(productID);
                Invoice in = new Invoice(invoiceId);

                OrderItem i = new OrderItem(in, orderNumber, quantity, cost, c);
                lp.add(i);
            }
            return lp;
        } catch (SQLException ex) {
            throw new Exception("Failed to load order item list!", ex);
        }
    }

    public void saveInvoice(Invoice invoice) throws Exception {
        try {
            String sql = "INSERT INTO Invoice (customerID, invoicedate, totalCost,businesspartnerid) VALUES (?,?,?,?)";
            PreparedStatement psRac = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //psRac.setInt(1, invoice.getInvoiceID());
            psRac.setInt(1, invoice.getCustomer().getCustomerID());
            psRac.setDate(2, new java.sql.Date(invoice.getInvoiceDate().getTime()));
            psRac.setDouble(3, invoice.getTotalCost());
            psRac.setInt(4, invoice.getBp().getBpID());
            psRac.executeUpdate();

            ResultSet rs = psRac.getGeneratedKeys();
            if (rs.next()) {
                invoice.setInvoiceID(rs.getInt(1));
            }

            String sqlSt = "INSERT INTO orderitem (invoiceID, orderNumber,quantity, cost, productID) VALUES (?,?,?,?,?)";
            PreparedStatement psSt = connection.prepareStatement(sqlSt);
            for (OrderItem s : invoice.getOrderItemList()) {
                psSt.setInt(1, invoice.getInvoiceID());
                psSt.setInt(2, s.getOrderNumber());
                psSt.setInt(3, s.getQuantity());
                psSt.setDouble(4, s.getCost());
                psSt.setInt(5, s.getProduct().getProductID());
                psSt.executeUpdate();

            }
            psSt.close();
            psRac.close();
        } catch (SQLException ex) {
            throw new Exception("Failed to save invoices!", ex);
        }
    }

    public void updateInvoice(Invoice invoice) throws Exception {
        try {
            String sqlRac = "UPDATE Invoice SET customerID=?, invoiceDate=?, totalCost=? WHERE invoiceID=?";
            PreparedStatement psRac = connection.prepareStatement(sqlRac);

            psRac.setInt(1, invoice.getCustomer().getCustomerID());
            psRac.setDate(2, new java.sql.Date(invoice.getInvoiceDate().getTime()));
            psRac.setDouble(3, invoice.getTotalCost());
            psRac.setInt(4, invoice.getInvoiceID());

            psRac.executeUpdate();

            String sqlSt = "UPDATE orderitem SET  orderNumber=?, quantity = ?, cost=?, productID =? WHERE invoiceID=?";
            PreparedStatement psSt = connection.prepareStatement(sqlSt);
            for (OrderItem s : invoice.getOrderItemList()) {

                psSt.setInt(1, s.getOrderNumber());
                psSt.setInt(2, s.getQuantity());
                psSt.setDouble(3, s.getCost());
                psSt.setInt(4, s.getProduct().getProductID());
                psSt.setInt(5, invoice.getInvoiceID());
                psSt.executeUpdate();
            }
            psSt.close();
            psRac.close();
        } catch (SQLException ex) {
            throw new Exception("Failed to Update invoice!", ex);
        }
    }

    public void getOrderItemList(OrderItem o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveProduct(Products p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
