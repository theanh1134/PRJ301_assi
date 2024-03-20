/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;

/**
 *
 * @author Laptop K1
 */
public class RoleDao extends DBContext {
 public String getRoleName(String username) {
    String roleName = null;
    try {
        connection = getConnection();
        String sql = "SELECT r.role_name FROM Account a " +
                     "INNER JOIN Role_Account ra ON a.id = ra.account_id " +
                     "INNER JOIN Role r ON r.role_id = ra.role_id " +
                     "WHERE a.username = ?";
        statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            roleName = resultSet.getString("role_name");
        }
    } catch (SQLException ex) {
        Logger.getLogger(RoleDao.class.getName()).log(Level.SEVERE, null, ex);  
    }
    return roleName;
}

    public ArrayList<Role> getByUsernanmeAndUrl(String username, String url) {
        ArrayList<Role> roles = new ArrayList<>();
        connection = getConnection();
        String sql = "SELECT r.role_id, r.role_name \n" +
"FROM Account a \n" +
"INNER JOIN Role_Account ra ON a.id = ra.account_id\n" +
"INNER JOIN Role r ON r.role_id = ra.role_id\n" +
"INNER JOIN Role_Feature rf ON rf.role_id = r.role_id\n" +
"INNER JOIN Feature f ON f.feature_id = rf.feature_id\n" +
"WHERE\n" +
"a.username = ? AND f.feature_name = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, username);
             statement.setObject(2, url);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Role role=new Role();
                role.setId(resultSet.getInt("role_id"));
                role.setName(resultSet.getString("role_name"));
                roles.add(role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return roles;

    }
     public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();

        // Thay thế username và url bằng giá trị cụ thể bạn muốn kiểm tra
        String username = "sonnt";
        String url = "att";

        ArrayList<Role> roles = roleDao.getByUsernanmeAndUrl(username, url);

        if (!roles.isEmpty()) {
            System.out.println("User " + username + " has access to the URL " + url + ".");
            System.out.println("Roles:");
            for (Role role : roles) {
                System.out.println("Role ID: " + role.getId() + ", Role Name: " + role.getName());
            }
        } else {
            System.out.println("User " + username + " does not have access to the URL " + url + ".");
        }
       
      

      
    }
}
