/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sp.bw.utils.DBUtils;

/**
 *
 * @author T14
 */
public class ProductDAO {
    private static final String SEARCH = "SELECT productID, name, price, quantity FROM tblProducts";
    
    public List<Product> getListProduct() throws SQLException {
        List listProduct = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(SEARCH);
                rs = ptm.executeQuery();
                while (rs.next()){
                    String productID = rs.getString("productID");
                    String name = rs.getString("name");
                    double price = Double.parseDouble(rs.getString("price"));
                    int quantity = Integer.parseInt(rs.getString("quantity"));
                    listProduct.add(new Product(productID, name, price, quantity));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null)
                rs.close();
            if(ptm!=null)
                ptm.close();
            if(conn!=null)
                conn.close();
        }
        return listProduct;
    }
    
    private static final String GET_PRODUCT = "SELECT productID, name, price FROM tblProducts WHERE productID=?";
    public Product getProduct(String productID, int quantity) throws SQLException {
        Product p = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(GET_PRODUCT);
                ptm.setString(1, productID);
                rs = ptm.executeQuery();
                if (rs.next()){
                    String name = rs.getString("name");
                    double price = Double.parseDouble(rs.getString("price"));
                    p = new Product(productID, name, price, quantity);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null)
                rs.close();
            if(ptm!=null)
                ptm.close();
            if(conn!=null)
                conn.close();
        }
        return p;
    }
    
}
