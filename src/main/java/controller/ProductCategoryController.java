package controller;

import com.terra.testcrud.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ProductCategory;

public class ProductCategoryController {
    
    private DefaultTableModel catModel;
    
    public DefaultTableModel tableProductCategory() {
        catModel = new DefaultTableModel();
        catModel.addColumn("Category ID");        
        catModel.addColumn("Category Name");
        return catModel;
    }       
    
    public ResultSet readProductCategory() {
        ConnectionManager conman = new ConnectionManager();
        ResultSet rs = null;
        Connection con = conman.getConnection();
        try {            
            String query = "SELECT * FROM product_category";
            Statement stm = con.createStatement();                             
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }    
    
    public int saveProductCategory(ProductCategory productCategory) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {            
            String query = "INSERT INTO product_category(id, name) values('"+productCategory.getId()+"', '"+productCategory.getName()+"')";
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
    
    public int editProductCategory(ProductCategory productCategory) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {            
            String query = "UPDATE product_category "
                    + "SET name='"+productCategory.getName()+"'"
                    + " WHERE id='"+productCategory.getId()+"'";
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
    
    public int deleteProductCategory(ProductCategory productCategory) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {            
            String query = "DELETE FROM product_category WHERE id='"+productCategory.getId()+"'";
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
}
