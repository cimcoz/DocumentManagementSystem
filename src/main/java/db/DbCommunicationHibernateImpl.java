/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;

import java.util.ArrayList;
import java.util.Date;

import java.util.Iterator;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.Hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.type.LongType;

/**
 *
 * @author Asus
 */
//@Transactional
public class DbCommunicationHibernateImpl implements DbComumunicationInterface {

    private HibernateUtil helper;
    //Transaction tx = getSessionFactory().openSession().getTransaction();
    Session session = helper.getSessionFactory().openSession();
    Transaction tx = session.getTransaction();

    public DbCommunicationHibernateImpl() {

    }

    @Override
    public void loadDriver() throws Exception {

    }

    @Override
    public void openConnection() throws Exception {
        try {
            //session = helper.getSessionFactory().openSession();
            session.beginTransaction();

            System.out.println("pocela transakcija");
        } catch (HibernateException ex) {
            throw new Exception("Neuspesno otvaranje konekcije!", ex);
        }

    }

    @Override
    public void commitTransaction() throws Exception {

        //Transaction tx = getSessionFactory().openSession().getTransaction();
        // Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();  
        tx.commit();
        System.out.println("commit");

    }

    @Override
    public void rollbackTransaction() throws Exception {
        //Transaction tx = getSessionFactory().getCurrentSession().getTransaction();
        tx.rollback();
        System.out.println("rollback!!!");
    }

    @Override
    public void closeConnection() throws Exception {

        session.close();

        System.out.println("zatvorena sesija!!!!!!");

    }

    @Override
    public Users loginUser(Users u) throws Exception {

        String q = "Select userid,name,lastname,username,password,role_fk,positions_fk,busPartner_fk from users where username=? and password=?";
        SQLQuery query = session.createSQLQuery(q);
        query.setParameter(0, u.getUsername());
        query.setParameter(1, u.getPassword());
        List result = query.list();

        System.out.println("resultset:" + result);

        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            Object[] obj = (Object[]) iterator.next();

            int userID = Integer.parseInt(String.valueOf(obj[0]));
            String name = String.valueOf(obj[1]);
            String lastName = String.valueOf(obj[2]);
            String username = String.valueOf(obj[3]);
            String pass = String.valueOf(obj[4]);

            int roleID = Integer.parseInt(String.valueOf(obj[5]));
            int pos = Integer.parseInt(String.valueOf(obj[6]));
            int bpfk = Integer.parseInt(String.valueOf(obj[7]));

            Role r = new Role(roleID);
            Positions p = new Positions(pos);
            Businesspartner bp = new Businesspartner(bpfk);

            u = new Users(userID, name, lastName, username, pass, r, p, bp);

            return u;
        }
        return null;

    }

    @Override
    public void savePosition(Positions pos) throws Exception {
        System.out.println("Usao u save pos");

        try {

            session.saveOrUpdate(pos);

        } catch (HibernateException e) {
        }

    }

    @Override
    public void saveUser(Users u) throws Exception {
        System.out.println("Usao u save user");
        session.saveOrUpdate(u);
    }

    @Override
    public void savePartner(Businesspartner bp) throws Exception {
        try {
            System.out.println("Usao u save partner");
            session.saveOrUpdate(bp);
            int id = bp.getBpID();
            System.out.println("BPID je " + id);

//            String q = "INSERT INTO Businesspartner (name, city, accountNumber, address, zip) VALUES (?,?,?,?,?)";
//            SQLQuery query = session.createSQLQuery(q);
//            query.setParameter(0, bp.getName());
//            query.setParameter(1, bp.getCity().getCityName());
//            query.setParameter(2, bp.getAccountNumber());
//            query.setParameter(3, bp.getAddress());
//            query.setParameter(4, bp.getCity().getZip());
//
//         query.executeUpdate();
//          
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveCustomer(Customer c) throws Exception {
        System.out.println("Usao u save customer");
        session.saveOrUpdate(c);
        int id = c.getCustomerID();
        int idBP = c.getBp().getBpID();
        System.out.println("Customer je " + id);
        System.out.println("BPID je " + idBP);
    }

    @Override
    public void saveInvoice(Invoice invoice) throws Exception {
        session.saveOrUpdate(invoice);
        int id = invoice.getInvoiceID();
        Businesspartner bpid = invoice.getBp();
            System.out.println("invoice je " + id);
            System.out.println("bpid je " + bpid);
            String q = "INSERT INTO orderitem (invoiceID, orderNumber,quantity, cost, productID) VALUES (?,?,?,?,?)";
        SQLQuery query = session.createSQLQuery(q);
        System.out.println("usao u query za insert orderitem " );
        for (OrderItem s : invoice.getOrderItemList()) {
                query.setInteger(0, invoice.getInvoiceID());
                query.setInteger(1, s.getOrderNumber());
                query.setInteger(2, s.getQuantity());
                query.setDouble(3, s.getCost());
                query.setInteger(4, s.getProduct().getProductID());
                
                query.executeUpdate();

            }
       

    }

    @Override
    public void saveProduct(Products p) throws Exception {
        session.saveOrUpdate(p);
        
       
    }

    @Override
    public void updatePartnerInfo(Businesspartner bp) throws Exception {
        //session.update(bp);
        String q = "UPDATE Businesspartner SET name=?,city=?,accountNumber=?,address=?,zip=? WHERE bpid=?";
        SQLQuery query = session.createSQLQuery(q);
        query.setString(0, bp.getName());
        query.setString(1, bp.getCity().getCityName());
        query.setString(2, bp.getAccountNumber());
        query.setString(3, bp.getAddress());
        query.setInteger(4, bp.getCity().getZip());
        query.setInteger(5, bp.getBpID());
        query.executeUpdate();

    }

    @Override
    public void updateCustomerInfo(Customer c) throws Exception {
        session.update(c);

    }

    @Override
    public void updatePosition(Positions pos) throws Exception {
        session.update(pos);
    }

    @Override
    public void updateUserInfo(Users u) throws Exception {
        //session.update(u);
        String q = "UPDATE Users SET name=?,lastname=?,username=?,role_fk=?, positions_fk=?, busPartner_fk=?  WHERE userID=?";
        SQLQuery query = session.createSQLQuery(q);
        query.setString(0, u.getName());
        query.setString(1, u.getLastName());
        query.setString(2, u.getUsername());
        query.setString(3, u.getRoleFk().getRoleName());
        query.setString(4, u.getPos().getPosName());
        query.setString(5, u.getBp().getName());
        query.setInteger(6, u.getUserID());
        query.executeUpdate();
    }

    @Override
    public void updateInvoice(Invoice invoice) throws Exception {
        session.update(invoice);
         String q = "UPDATE orderitem SET  orderNumber=?, quantity = ?, cost=?, productID =? WHERE invoiceID=?";
        SQLQuery query = session.createSQLQuery(q);
        System.out.println("usao u query za update orderitem " );
        for (OrderItem s : invoice.getOrderItemList()) {
                
                query.setInteger(0, s.getOrderNumber());
                query.setInteger(1, s.getQuantity());
                query.setDouble(2, s.getCost());
                query.setInteger(3, s.getProduct().getProductID());
                query.setInteger(4, invoice.getInvoiceID());
                query.executeUpdate();

            }
    }

    @Override
    public void delPartner(int bpid) throws Exception {

        Businesspartner bp = new Businesspartner(bpid);
        session.delete(bp);

    }

    @Override
    public void delInvoice(int invoiceid) throws Exception {
        Invoice i = new Invoice(invoiceid);
        session.delete(i);
    }

    @Override
    public void delPosition(int posID) throws Exception {
        Positions p = new Positions(posID);
        session.delete(p);
    }

    @Override
    public void delUser(int userID) throws Exception {
        Users u = new Users(userID);
        session.delete(u);
    }

    @Override
    public void delCustomer(int customerID) throws Exception {
        Customer c = new Customer(customerID);
        session.delete(c);
    }

    @Override
    public List<Businesspartner> getPartners() throws Exception {

        System.out.println("Query getPartners");
        String q = "SELECT p.bpid,p.name,c.cityName, p.accountnumber,p.address,c.zip FROM Businesspartner p INNER JOIN City c ON (p.zip = c.zip)";

        SQLQuery query = session.createSQLQuery(q);

        List<Businesspartner> result = new ArrayList();
        //result = query.list();
        List rs = query.list();
        System.out.println("resultset:" + result);

        Iterator iterator = rs.iterator();
        while (iterator.hasNext()) {
            Object[] obj = (Object[]) iterator.next();

            int bpID = Integer.parseInt(String.valueOf(obj[0]));
            String name = String.valueOf(obj[1]);
            String cityName = String.valueOf(obj[2]);
            String accountNumber = String.valueOf(obj[3]);
            String address = String.valueOf(obj[4]);
            int zip = Integer.parseInt(String.valueOf(obj[5]));

            //String cityName = String.valueOf(obj[5]);
            City c = new City(zip, cityName);
            Businesspartner p = new Businesspartner(bpID, name, c, accountNumber, address, c);

            result.add(p);

        }
        return result;
    }

    @Override
    public List<Businesspartner> getPartnersConditional() throws Exception {
        System.out.println("Query getPartners Conditional");
        List<Businesspartner> list = (List<Businesspartner>) session.createSQLQuery("SELECT  b.*, u.* FROM businesspartner b, users u WHERE b.bpid = u.buspartner_fk").addEntity(Businesspartner.class).list();
        return list;
    }

    @Override
    public List<Positions> getPositionList() throws Exception {
        System.out.println("Query getPositionList");
//        List<Positions> list = (List<Positions>) session.createSQLQuery("SELECT p.posid,p.posname,p.posdescription,p.bpid, c.BpID FROM Positions p INNER JOIN Businesspartner c ON (p.BpID = c.BpID)").addEntity(Positions.class).list();
//        return list;

        String q = "SELECT p.posid,p.posname,p.posdescription,p.bpid, c.BpID FROM Positions p INNER JOIN Businesspartner c ON (p.BpID = c.BpID)";
        SQLQuery s = session.createSQLQuery(q);

        List<Positions> result = new ArrayList();

        List rs = s.list();
        System.out.println("resultset:" + result);
//        Query s = (Query) getSessionFactory().openSession().createSQLQuery("SELECT p.*, c.BpID FROM Positions p INNER JOIN Businesspartner c ON (p.BpID = c.BpID)").list();
//
//        List<Positions> lc = (List<Positions>) s.getResultList();
//        List<Positions> lcc = new ArrayList<>();
        Iterator itr = rs.iterator();

        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int posID = Integer.parseInt(String.valueOf(obj[0]));
            String posName = String.valueOf(obj[1]);
            String posDescription = String.valueOf(obj[2]);
            int BpID = Integer.parseInt(String.valueOf(obj[3]));
            Businesspartner bp = new Businesspartner(BpID);
            Positions p = new Positions(posID, posName, posDescription, bp);

            result.add(p);

        }
        return result;

    }

    @Override
    public List<Users> getUserList() throws Exception {
        System.out.println("Query getUserList");
//        List<Users> list = (List<Users>) session.createSQLQuery("Select userid,name,lastname,username,password,role_fk,positions_fk,buspartner_fk from Users").addEntity(Users.class).list();
//        return list;
        String q = "Select userid,name,lastname,username,password,role_fk,positions_fk,buspartner_fk from Users";
        SQLQuery s = session.createSQLQuery(q);

        List<Users> result = new ArrayList();

        List rs = s.list();
        System.out.println("resultset:" + result);
        Iterator itr = rs.iterator();

        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int UserID = Integer.parseInt(String.valueOf(obj[0]));
            String name = String.valueOf(obj[1]);
            String lastname = String.valueOf(obj[2]);
            String username = String.valueOf(obj[3]);
            String password = String.valueOf(obj[4]);
//            String role = String.valueOf(obj[5]);
//            String pos = String.valueOf(obj[6]);
//            String bp = String.valueOf(obj[7]);
            int role = Integer.parseInt(String.valueOf(obj[5]));
            int pos = Integer.parseInt(String.valueOf(obj[6]));
            int bp = Integer.parseInt(String.valueOf(obj[7]));
            Role r = new Role(role);
            Positions p = new Positions(pos);
            Businesspartner bpp = new Businesspartner(bp);
            Users u = new Users(UserID, name, lastname, username, password, r, p, bpp);

            result.add(u);

        }
        return result;

    }

    @Override
    public List<Customer> getCustomerList() throws Exception {
//        System.out.println("Query getCustomerList");
//        List<Customer> list = (List<Customer>) session.createSQLQuery("SELECT productid,productname,productprice FROM Product").addEntity(Customer.class).list();
//        return list;
        String q = "Select customerid,customername,customeraddress,createdby,businesspartnerid from Customer";
        SQLQuery s = session.createSQLQuery(q);

        List<Customer> result = new ArrayList();

        List rs = s.list();
        System.out.println("resultset:" + result);

        Iterator itr = rs.iterator();

        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int customerID = Integer.parseInt(String.valueOf(obj[0]));
            String name = String.valueOf(obj[1]);
            String address = String.valueOf(obj[2]);
            String user = String.valueOf(obj[3]);
            int bpp = Integer.parseInt(String.valueOf(obj[4]));
            Businesspartner bp = new Businesspartner(bpp);
            Users u = new Users(user);
            Customer c = new Customer(customerID, name, address, u, bp);
            rs.add(c);

        }
        return rs;

    }

    @Override
    public List<Customer> getCustomerListConditional(Businesspartner bpid) throws Exception {
//        System.out.println("Query getCustomerListConditional");
//        List<Customer> list = (List<Customer>) session.createSQLQuery("Select customerid,customername,customeraddress,createdby,businesspartnerid from Customer WHERE businesspartnerid =" + bpid.getBpID()).addEntity(Customer.class).list();
//        return list;


        String q = "Select customerID,customername,customeraddress,createdby,businesspartnerid from Customer WHERE businesspartnerid =" + bpid.getBpID();
        SQLQuery s = session.createSQLQuery(q);

        List<Customer> result = new ArrayList();

        List rs = s.list();
       
        Iterator itr = rs.iterator();

        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int customerID = Integer.parseInt(String.valueOf(obj[0]));
            String name = String.valueOf(obj[1]);
            String address = String.valueOf(obj[2]);
            String user = String.valueOf(obj[3]);
            int bpp = Integer.parseInt(String.valueOf(obj[4]));
            Businesspartner bp = new Businesspartner(bpp);
            Users u = new Users(user);
            Customer c = new Customer(customerID, name, address, u, bp);
            result.add(c);

        }
        return result;
    }

    @Override
    public List<Products> getProductList() throws Exception {
        System.out.println("Query getProductList");
        List<Products> list = (List<Products>) session.createSQLQuery("SELECT productid,productname,productprice FROM Product").addEntity(Products.class).list();
        return list;
    }

    @Override
    public List<Invoice> getInvoiceList() throws Exception {
        System.out.println("Query getInvoiceList");
//        List<Invoice> list = (List<Invoice>) session.createSQLQuery("SELECT invoiceid,customerid,invoicedate,totalcost FROM Invoice").addEntity(Invoice.class).list();
//        return list;
//       
 String q = "SELECT invoiceid,customerid,invoicedate,totalcost,businesspartnerid FROM Invoice ";
        SQLQuery s = session.createSQLQuery(q);

        List<Invoice> result = new ArrayList();

        List rs = s.list();
        System.out.println("resultset:" + result);

        Iterator itr = rs.iterator();
        while (itr.hasNext()) {
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM"); 
            Object[] obj = (Object[]) itr.next();
            int invoiceID = Integer.parseInt(String.valueOf(obj[0]));
            int customerID = Integer.parseInt(String.valueOf(obj[1]));
            Date date = df.parse(String.valueOf(obj[2]));
            double totalCost = Double.parseDouble(String.valueOf(obj[3]));
            int bpid= Integer.parseInt(String.valueOf(obj[4]));
            Customer c = new Customer(customerID);
            Businesspartner bp = new Businesspartner(bpid);

                Invoice i = new Invoice(invoiceID, c, date, totalCost,bp);
               
            result.add(i);

        }
        return result;


    }
    public List<Invoice> getInvoiceListConditional(Businesspartner bp) throws Exception {
        System.out.println("db.DbCommunicationHibernateImpl.getInvoiceListConditional()");
       String q = "SELECT invoiceid,customerid,invoicedate,totalcost, businesspartnerid FROM Invoice WHERE businesspartnerid =" + bp.getBpID();
        //String q = "SELECT o.*, i.businesspartnerID as invid FROM Invoice o INNER JOIN Customer i WHERE (o.businesspartnerID = i.businesspartnerID)";
        SQLQuery s = session.createSQLQuery(q);

        List<Invoice> result = new ArrayList();

        List rs = s.list();
        System.out.println("resultset:" + result);

        Iterator itr = rs.iterator();
        while (itr.hasNext()) {
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM"); 
            Object[] obj = (Object[]) itr.next();
            int invoiceID = Integer.parseInt(String.valueOf(obj[0]));
            int custID = Integer.parseInt(String.valueOf(obj[1]));
            Date date = df.parse(String.valueOf(obj[2]));
            double totalCost = Double.parseDouble(String.valueOf(obj[3]));
          int bpid= Integer.parseInt(String.valueOf(obj[4]));
            Customer c = new Customer(custID);
            Businesspartner bpp = new Businesspartner(bpid);

                Invoice i = new Invoice(invoiceID, c, date, totalCost,bpp);
               
            result.add(i);

        }
        return result;
    }

    @Override
    public List<OrderItem> getOrderItemList(Invoice invoiceID) throws Exception {
        List<OrderItem> list = (List<OrderItem>) session.createSQLQuery("SELECT invoiceid,ordernumber,quantity,cost,productid FROM OrderItem WHERE invoiceID= " + invoiceID.getInvoiceID()).addEntity(OrderItem.class).list();
        return list;
//        System.out.println("db.DbCommunicationHibernateImpl.getOrderItemList()");
//        String q = "SELECT o.InvoiceID, o.orderNumber,o.quantity,o.cost,o.productID, i.invoiceID FROM OrderItem o INNER JOIN Invoice i WHERE o.invoiceID =" +invoiceID.getInvoiceID();
//        SQLQuery s = session.createSQLQuery(q);
//        System.out.println("invoice id" + invoiceID);
//        List<OrderItem> result = new ArrayList();
//
//        List rs = s.list();
//        System.out.println("resultset:" + result);
//
//        Iterator itr = rs.iterator();
//        while (itr.hasNext()) {
//           
//            Object[] obj = (Object[]) itr.next();
//            int invoiceId = Integer.parseInt(String.valueOf(obj[0]));
//            int orderNumber = Integer.parseInt(String.valueOf(obj[1]));
//           int quantity = Integer.parseInt(String.valueOf(obj[2]));
//           double cost = Double.parseDouble(String.valueOf(obj[3]));
//           int productID = Integer.parseInt(String.valueOf(obj[4]));
//           Products c = new Products(productID);
//                Invoice in = new Invoice(invoiceId);
//
//                OrderItem i = new OrderItem(in, orderNumber, quantity, cost, c);
//                
//            result.add(i);
//
//        }
//        return result;
//
//        
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        System.out.println("Query getRoleList");
//        List<Role> list = (List<Role>) session.createSQLQuery("SELECT roleid,rolename,roledescription FROM Role").addEntity(Role.class).list();
//        return list;
        String q = "SELECT roleid,rolename,roledescription FROM Role";
        SQLQuery s = session.createSQLQuery(q);

        List<Role> result = new ArrayList();

        List rs = s.list();
        System.out.println("resultset:" + result);

        Iterator itr = rs.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            int roleID = Integer.parseInt(String.valueOf(obj[0]));
            String roleName = String.valueOf(obj[1]);
            String roleDesc = String.valueOf(obj[2]);
            Role r = new Role(roleID, roleName, roleDesc);

            result.add(r);

        }
        return result;

    }

    @Override
    public List<City> getCityList() throws Exception {

        System.out.println("Usao u Query za City listu");

        List<City> list = (List<City>) session.createSQLQuery("SELECT zip,cityName FROM City").addEntity(City.class).list();
        return list;

    }

    @Override
    public void getOrderItemList(OrderItem o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
