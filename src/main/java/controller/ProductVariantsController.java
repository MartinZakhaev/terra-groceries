package controller;

import com.terra.testcrud.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.ProductVariants;

public class ProductVariantsController {
    
    private DefaultTableModel pvModel;
    
    public ResultSet pvPrice(ProductVariants productVariants) {
        ConnectionManager conman = new ConnectionManager();
        ResultSet rs = null;
        Connection con = conman.getConnection();
        try {            
            String query = "SELECT price FROM product_variants "
                    + "WHERE sku='"+productVariants.getSku()+"'";
            Statement stm = con.createStatement();
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductVariantsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet pvCustomer() {
        ConnectionManager conman = new ConnectionManager();
        ResultSet rs = null;
        Connection con = conman.getConnection();
        try {            
            String query = "SELECT pv.sku, pv.name, pv.size\n" +
                            "FROM product_variants pv\n" +
                            "JOIN product_category pc\n" +
                            "ON pc.id = pv.category\n" +
                            "ORDER BY pv.category";
            Statement stm = con.createStatement();
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductVariantsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public DefaultTableModel tableProductVariants() {
        pvModel = new DefaultTableModel();
        pvModel.addColumn("SKU");        
        pvModel.addColumn("Product Category");
        pvModel.addColumn("Product Name");
        pvModel.addColumn("Product Size");
        pvModel.addColumn("Product Price");
        pvModel.addColumn("Stock");
        return pvModel;
    }       
    
    public ResultSet readProductVariants() {
        ConnectionManager conman = new ConnectionManager();
        ResultSet rs = null;
        Connection con = conman.getConnection();
        try {            
            String query = "SELECT * FROM product_variants";
            Statement stm = con.createStatement();                             
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public int saveProductVariants(ProductVariants productVariants) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {            
            String query = "INSERT INTO product_variants(sku, category, name, size, price, stock) VALUES("
                    + "'"+productVariants.getSku()+"',"
                    + "'"+productVariants.getCategory()+"',"
                    + "'"+productVariants.getName()+"',"
                    + "'"+productVariants.getSize()+"',"
                    + "'"+productVariants.getPrice()+"',"
                    + " '"+productVariants.getStock()+"')";
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductVariantsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
    
    public int editProductVariants(ProductVariants productVariants) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {   
            String query = "UPDATE product_variants "
//                    + "SET category='"+productVariants.getCategory()+"'"
//                    + "SET name='"+productVariants.getName()+"'"
//                    + "SET size='"+productVariants.getSize()+"'"
                    + "SET price='"+productVariants.getPrice()+"',"
                    + "stock='"+productVariants.getStock()+"'"
                    + " WHERE sku='"+productVariants.getSku()+"'";            
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductVariantsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
    
    public int deleteProductVariants(ProductVariants productVariants) {
        ConnectionManager conman = new ConnectionManager();
        int hasil = 0;
        Connection con = conman.getConnection();
        try {   
            String query = "DELETE FROM product WHERE sku='"+productVariants.getSku()+"'";                        
            Statement stm = con.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProductVariantsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        conman.closeConnection();
        return hasil;
    }
}
