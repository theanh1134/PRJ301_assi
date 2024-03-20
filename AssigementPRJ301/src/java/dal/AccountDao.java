/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Laptop K1
 */
public class AccountDao extends DBContext {

    public Account findUseNameAndPassword(String username, String password) {
        //- connect with DB
        connection = getConnection();
        //- chuẩn bị câu lệnh SQL
        String sql = "SELECT [username]\n"
                + "      ,[password]\n"           
                + "  FROM [dbo].[Account]\n"
                + "  where username=? and password=?";
        try {
            //- Tạo đối tượng PrepareStatement
            statement = connection.prepareStatement(sql);
            //- Set parameter ( optional )
            statement.setObject(1, username);
            statement.setObject(2, password);
            //- Thực thi câu lệnh
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String usename_Found = resultSet.getString("username").trim();
                String password_Found = resultSet.getString("password").trim();
                Account account = new Account(username, password, sql);
                return account;
            }

            //- trả về kết quả
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println(new AccountDao().findUseNameAndPassword("theanh", "123"));

    }
}
