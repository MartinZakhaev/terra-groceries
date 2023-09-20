package controller;

import com.terra.testcrud.ConnectionManager;
import model.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class CustomerController {
    private DefaultTableModel cstModel;
    
    public int thCustomer(Customer customer, String sku, int total_item) {
        int hasil = 0;
        ConnectionManager conman = new ConnectionManager();       
        Connection con = conman.getConnection();
        try {            
            String query = "INSERT INTO "
                    + "transaction_history(customer_id, sku, total_item) "
                    + "VALUES("
                    + "'"+customer.getId()+"', "
                    + "'"+sku+"', "
                    + "'"+total_item+"'"
                    + ")";
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
    public ResultSet ohCustomer(Customer customer) {
        ConnectionManager conman = new ConnectionManager();
        ResultSet rs = null;
        Connection con = conman.getConnection();
        try {            
            String query = "SELECT th.id AS t_id, c.id AS c_id, p.sku, pv.price,\n" +
                            "th.total_item, SUM(th.total_item*pv.price) AS total_price,\n" +
                            "transaction_time\n" +
                            "FROM transaction_history th\n" +
                            "JOIN customer c\n" +
                            "ON c.id = th.customer_id\n" +
                            "JOIN product p\n" +
                            "ON th.sku = p.sku\n" +
                            "JOIN product_variants pv\n" +
                            "ON p.sku = pv.sku\n" +
                            "WHERE c.id = '"+customer.getId()+"'\n" +
                            "GROUP BY th.id";
            Statement stm = con.createStatement();
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet loginCustomer(Customer customer) {
        ConnectionManager conman = new ConnectionManager();
        ResultSet rs = null;
        Connection con = conman.getConnection();
        try {            
            String query = "SELECT * FROM customer"
                    + " WHERE username='"+customer.getUsername()+"'"
                    + " AND password='"+customer.getPassword()+"'";
            Statement stm = con.createStatement();                             
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet checkUsernameCustomer(Customer customer) {
        ConnectionManager conman = new ConnectionManager();
        ResultSet rs = null;
        Connection con = conman.getConnection();
        try {            
            String query = "SELECT * FROM customer"
                    + " WHERE username='"+customer.getUsername()+"'";
            Statement stm = con.createStatement();                             
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public DefaultTableModel tableCustomer() {
        cstModel = new DefaultTableModel();
        cstModel.addColumn("Customer ID");        
        cstModel.addColumn("Username");        
        cstModel.addColumn("Password");        
        cstModel.addColumn("First Name");
        cstModel.addColumn("Last Name");
        cstModel.addColumn("Phone");
        cstModel.addColumn("Address");
        cstModel.addColumn("Email");
        cstModel.addColumn("Created At");
        return cstModel;
    }
    
    public ResultSet readCustomer() {
        ConnectionManager conman = new ConnectionManager();
        ResultSet rs = null;
        Connection con = conman.getConnection();
        try {            
            String query = "SELECT * FROM customer";
            Statement stm = con.createStatement();                             
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }        
    
    public int saveCustomer(Customer customer) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {            
            String query = "INSERT INTO customer(username, password, f_name, l_name, phone, address, email) VALUES("
                    + "'"+customer.getUsername()+"', "
                    + "'"+customer.getPassword()+"', "
                    + "'"+customer.getfName()+"', "
                    + "'"+customer.getlName()+"', "
                    + "'"+customer.getPhone()+"', "
                    + "'"+customer.getAddress()+"', "
                    + "'"+customer.getEmail()+"')";
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }     
    
    public int editCustomer(Customer customer) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {            
            String query = "UPDATE customer SET username='"+customer.getUsername()+"',"
                    + " f_name='"+customer.getfName()+"',"
                    + " l_name='"+customer.getlName()+"',"
                    + " phone='"+customer.getPhone()+"',"
                    + " address='"+customer.getAddress()+"',"
                    + " email='"+customer.getEmail()+"' WHERE id='"+customer.getId()+"'";            
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    } 
    
    public int deleteCustomer(Customer customer) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {            
            String query = "DELETE FROM customer WHERE id='"+customer.getId()+"'";                        
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }     
}
