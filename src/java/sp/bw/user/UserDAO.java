/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.bw.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sp.bw.utils.DBUtils;

/**
 *
 * @author T14
 */
public class UserDAO {
    private static final String LOGIN = "SELECT fullName, roleID from tblUsers WHERE userID=? AND password=?";
    
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO loginUser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if (conn != null){
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if(rs.next()){
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    loginUser = new UserDTO(userID, fullName, roleID, "***");
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
        return loginUser;
    }
    
    private static final String SEARCH = "SELECT userID, fullName, roleID FROM tblUsers WHERE fullName like ? ";

    public List getListUser(String search) throws SQLException {
        List listUser = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%"+search+"%");
                rs = ptm.executeQuery();
                while (rs.next()){
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    listUser.add(new UserDTO(userID, fullName, roleID, password));
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
        return listUser;
    }
    
    private static final String DELETE = "DELETE tblUsers WHERE userID=?";

    public boolean delete(String userID) throws SQLException {
        boolean checkDelete = false; 
        Connection conn = null;
        PreparedStatement ptm = null;
        try{
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
                checkDelete = ptm.executeUpdate()>0?true:false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(ptm!=null)
                ptm.close();
            if(conn!=null)
                conn.close();
        }
        return checkDelete;
    }
    
    private static final String UPDATE = "UPDATE tblUsers SET fullName=?, roleID=? WHERE userID=?";

    public boolean update(UserDTO user) throws SQLException {
        boolean checkUpdate = false; 
        Connection conn = null;
        PreparedStatement ptm = null;
        try{
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getRoleID());
                ptm.setString(3, user.getUserID());
                checkUpdate = ptm.executeUpdate()>0?true:false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(ptm!=null)
                ptm.close();
            if(conn!=null)
                conn.close();
        }
        return checkUpdate;
    }
    
    private static final String CHECK_DUPLICATE = "SELECT fullName from tblUsers WHERE userID=?";

    public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if (conn != null){
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if(rs.next()){
                    check=true;
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
        return check;
    }
    
    private static final String INSERT = "INSERT INTO tblUsers(userID, fullName, roleID, password) VALUES(?,?,?,?)";

    public boolean insert(UserDTO newUser) throws SQLException {
        boolean check = false; 
        Connection conn = null;
        PreparedStatement ptm = null;
        try{
            conn = DBUtils.getConnection1();
            if (conn!=null){
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, newUser.getUserID());
                ptm.setString(2, newUser.getFullName());
                ptm.setString(3, newUser.getRoleID());
                ptm.setString(4, newUser.getPassword());
                check = ptm.executeUpdate()>0?true:false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(ptm!=null)
                ptm.close();
            if(conn!=null)
                conn.close();
        }
        return check;
    }

    public boolean insertV2(UserDTO newUser) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false; 
        Connection conn = null;
        PreparedStatement ptm = null;
        try{
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, newUser.getUserID());
                ptm.setString(2, newUser.getFullName());
                ptm.setString(3, newUser.getRoleID());
                ptm.setString(4, newUser.getPassword());
                check = ptm.executeUpdate()>0?true:false;
            }
        }finally{
            if(ptm!=null)
                ptm.close();
            if(conn!=null)
                conn.close();
        }
        return check;
    }
    private static final String SHOWTOP = "SELECT TOP (2) userID, fullName, roleID FROM tblUsers";

    public List<UserDTO> getTopUser() throws SQLException {
        List listUser = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if (conn!=null){
                ptm = conn.prepareStatement(SHOWTOP);
                rs = ptm.executeQuery();
                while (rs.next()){
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    listUser.add(new UserDTO(userID, fullName, roleID, password));
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
        return listUser;
    }
    
}
