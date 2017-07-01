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
import java.util.List;

/**
 *
 * @author Asus
 */
public interface DbComumunicationInterface {

    public void loadDriver() throws Exception;

    public void openConnection() throws Exception;

    public void commitTransaction() throws Exception;

    public void rollbackTransaction() throws Exception;

    public void closeConnection() throws Exception;

    public List<Role> getRoleList() throws Exception;

    public List<City> getCityList() throws Exception;

    public Users loginUser(Users u) throws Exception;

    public void savePosition(Positions pos) throws Exception;

    public void saveUser(Users u) throws Exception;

    public void savePartner(Businesspartner bp) throws Exception;

    public void saveCustomer(Customer c) throws Exception;

    public void saveProduct(Products p) throws Exception;

    public void updatePartnerInfo(Businesspartner bp) throws Exception;

    public void updateCustomerInfo(Customer c) throws Exception;

    public void updatePosition(Positions pos) throws Exception;

    public void updateUserInfo(Users u) throws Exception;

    public void delPartner(int bpid) throws Exception;

    public void delInvoice(int invoiceid) throws Exception;

    public void delPosition(int posID) throws Exception;

    public void delUser(int userID) throws Exception;

    public void delCustomer(int customerID) throws Exception;

    public List<Businesspartner> getPartners() throws Exception;

    public List<Businesspartner> getPartnersConditional() throws Exception;

    public List<Positions> getPositionList() throws Exception;

    public List<Users> getUserList() throws Exception;

    public List<Customer> getCustomerList() throws Exception;

    public List<Customer> getCustomerListConditional(Businesspartner bpid) throws Exception;

    public List<Products> getProductList() throws Exception;

    public List<Invoice> getInvoiceList() throws Exception;

    public List<Invoice> getInvoiceListConditional(Businesspartner bp) throws Exception;

    public List<OrderItem> getOrderItemList(Invoice invoiceID) throws Exception;

    public void saveInvoice(Invoice invoice) throws Exception;

    public void updateInvoice(Invoice invoice) throws Exception;

    public void getOrderItemList(OrderItem o);

}
