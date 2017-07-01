package logic;

import com.documentsystem.model.Businesspartner;
import com.documentsystem.model.City;
import com.documentsystem.model.Customer;
import com.documentsystem.model.Invoice;
import com.documentsystem.model.OrderItem;
import com.documentsystem.model.Positions;
import com.documentsystem.model.Products;
import com.documentsystem.model.Role;
import com.documentsystem.model.Users;
import db.DbCommunication;
import db.DbCommunicationHibernateImpl;
import java.util.List;
import logic.so.SOGetCityList;
import logic.so.SOGetPositionList;
import logic.so.SOGetProductList;
import logic.so.SOGetRoleList;
import logic.so.SOSavePartnerList;
import logic.so.SOSavePositionList;
import logic.so.SOAddCustomer;
import logic.so.SOAddPartner;
import logic.so.SOAddPosition;
import logic.so.SOAddUser;
import logic.so.SODeleteCustomer;
import logic.so.SODeleteInvoice;
import logic.so.SODeletePartner;
import logic.so.SODeletePosition;


import logic.so.SOGetPartnerList;
import logic.so.SOLogIn;
import logic.so.SOSaveInvoice;
import logic.so.SOUpdateCustomer;
import logic.so.SOUpdatePartner;
import logic.so.SOUpdatePosition;
import logic.so.SOUpdateUser;
import logic.so.SODeleteUser;
import logic.so.SOGetCustomerList;
import logic.so.SOGetCustomerListConditional;
import logic.so.SOGetInvoiceList;
import logic.so.SOGetOrderItemList;
import logic.so.SOGetPartnerListConditional;
import logic.so.SOGetUserList;
import logic.so.SOUpdateInvoice;
import db.DbCommunicationHibernateImpl;
import logic.so.SOGetInvoiceListConditional;
public class Controller {

    public Users logged;
  private DbCommunication db;
    private static Controller instance;
    //private DbCommunicationHibernateImpl db;
    
    
    private Controller() {

     db = new DbCommunication();
        //db = new DbCommunicationHibernateImpl();
        

    }

    public Users getLogged() {
        return logged;
    }
    
    

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void addPartner(Businesspartner bp) throws Exception {
        SOAddPartner so = new SOAddPartner(bp);
        so.opsteIzvrsenje();
        
    }

    public void updatePartner(Businesspartner bp) throws Exception {
       SOUpdatePartner so = new SOUpdatePartner(bp);
       so.opsteIzvrsenje();
    }

    public void updateCustomer(Customer c) throws Exception {
        SOUpdateCustomer so = new SOUpdateCustomer(c);
        so.opsteIzvrsenje();
    }

    public void updatePosition(Positions pos) throws Exception {
       SOUpdatePosition so = new SOUpdatePosition(pos);
       so.opsteIzvrsenje();
    }

    public void updateUser(Users u) throws Exception {
       SOUpdateUser so = new SOUpdateUser(u);
       so.opsteIzvrsenje();
    }

    public void deletePartner(int bpid) throws Exception {
        SODeletePartner so = new SODeletePartner(bpid);
        so.opsteIzvrsenje();
    }

    public void deleteUser(int userID) throws Exception {
       SODeleteUser so = new SODeleteUser(userID);
       so.opsteIzvrsenje();
    }

    public void deletePos(int posID) throws Exception {
       SODeletePosition so = new SODeletePosition(posID);
       so.opsteIzvrsenje();
    }

    public void deleteCustomer(int customerID) throws Exception {
       SODeleteCustomer so = new SODeleteCustomer(customerID);
       so.opsteIzvrsenje();
    }

    public void deleteInvoice(int invoiceid) throws Exception {
       
        SODeleteInvoice so = new SODeleteInvoice(invoiceid);
        so.opsteIzvrsenje();
    }

    public void addPosition(Positions p) throws Exception {
        SOAddPosition so  = new SOAddPosition(p);
        so.opsteIzvrsenje();
    }

    public void addUser(Users u) throws Exception {
       SOAddUser so = new SOAddUser(u);
       so.opsteIzvrsenje();
    }

    public void addCustomer(Customer c) throws Exception {
         SOAddCustomer so = new SOAddCustomer(c);
       so.opsteIzvrsenje();
    }

    public Users login(Users u) throws Exception {
       /* Users user = null;
        try {
            db.loadDriver();
            db.openConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        try {
            user = db.loginUser(u);

            db.commitTransaction();
        } catch (Exception e) {
            db.rollbackTransaction();
            throw e;
        } finally {
            db.closeConnection();
        }
*/
        SOLogIn so=new SOLogIn(u);
        so.opsteIzvrsenje();
        logged=so.getUser();
        return so.getUser();
    }

    public List<Businesspartner> getPartnerList() throws Exception {
        SOGetPartnerList so=new SOGetPartnerList();
        so.opsteIzvrsenje();
        return so.getPartnerList();
    }

    public List<Businesspartner> getPartnerListConditional() throws Exception {
        SOGetPartnerListConditional so=new SOGetPartnerListConditional();
        so.opsteIzvrsenje();
        return so.getPartnersConditional();
    }

    public List<Customer> getCustomerList() throws Exception {
        SOGetCustomerList so=new SOGetCustomerList();
        so.opsteIzvrsenje();
        return so.getCustomerList();
    }
    
    public List<Customer> getCustomerListConditional(Businesspartner bpid) throws Exception {
        SOGetCustomerListConditional so=new SOGetCustomerListConditional(bpid);
        so.opsteIzvrsenje();
        return so.getCustomerListConditional(bpid);
    }

    public List<Users> getUserList() throws Exception {
      SOGetUserList so = new SOGetUserList();
      so.opsteIzvrsenje();
     return so.getUserList();
    }

    public void savePartnerList(List<Businesspartner> pl) throws Exception {
        SOSavePartnerList os = new SOSavePartnerList(pl);
        os.opsteIzvrsenje();
    }

    public void savePositionList(List<Positions> pl) throws Exception {
        SOSavePositionList os = new SOSavePositionList(pl);
        os.opsteIzvrsenje();
    }

    public List<City> getCityList() throws Exception{
          SOGetCityList so = new SOGetCityList();
    so.opsteIzvrsenje();
    return so.getCityList();
    }

    public List<Role> getRoleList() throws Exception {

       SOGetRoleList os = new SOGetRoleList();
       os.opsteIzvrsenje();
      return os.getRoleList();

    }

    public List<Positions> getPositionList()
            throws Exception {
       SOGetPositionList os = new SOGetPositionList();
       os.opsteIzvrsenje();
      return os.getPositionList();
    }

    public List<Products> getProductList()
            throws Exception {
        SOGetProductList os = new SOGetProductList();
        os.opsteIzvrsenje();
        return os.getProductList();
    }

    public List<Invoice> getInvoiceList()
            throws Exception {
       SOGetInvoiceList so = new  SOGetInvoiceList();
       so.opsteIzvrsenje();
       return so.getInvoiceList();
    }
    
    public List<Invoice> getInvoiceListConditional(Businesspartner bp)throws Exception{
    SOGetInvoiceListConditional so=new SOGetInvoiceListConditional(bp);
        so.opsteIzvrsenje();
        return so.getInvoiceListConditional(bp);
    }

    public List<OrderItem> getOrderItemList(Invoice invoiceID)
            throws Exception {
       SOGetOrderItemList so = new SOGetOrderItemList(invoiceID);
       so.opsteIzvrsenje();
       return so.getOrderItemList();
    }

    public void saveInvoice(Invoice invoice) throws Exception {

        //double totalCost = 0;
      //  int orderNumber = 0;
      //  for (OrderItem s : invoice.getOrderItemList()) {
      //      orderNumber++;
     //       s.setOrderNumber(orderNumber);
     //       totalCost = totalCost + s.getCost();
      //  }
      //  invoice.setTotalCost(totalCost);
      //  db.loadDriver();
      //  db.openConnection();
     //   db.saveInvoice(invoice);
     //   db.commitTransaction();
      //  db.closeConnection();
 SOSaveInvoice so= new SOSaveInvoice(invoice);
        so.opsteIzvrsenje();

    }

    public void updateInvoice(Invoice invoice) throws Exception {

       SOUpdateInvoice so = new SOUpdateInvoice(invoice);
       so.opsteIzvrsenje();

    }

}
