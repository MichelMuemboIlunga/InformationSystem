/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.informationmanagementsystem.login.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MICHEL MUEMBO ILUNGA
 */
public class DbConnection {
    public static Connection DerbyConnection() throws SQLException{
        
        String url = "jdbc:derby://localhost:1527/InfoSystem";
        String user = "root";
        String password = "InfoSystem";
        
        return DriverManager.getConnection(url, user, password);
    }
}
