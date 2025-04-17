/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.regester.database;

/**
 *
 * @author yasmeen
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDriver;


public class DAO 
{
    public static int register(UserDTO user) throws SQLException
    {
        int result =-1;
        DriverManager.registerDriver(new ClientDriver());
        
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "root", "root");
        PreparedStatement statment = connection.prepareStatement("Insert into USERTABLE values (? ,?)");
        statment.setString(1, user.getUserName());
        statment.setString(2, user.getPassword());
        
        result=statment.executeUpdate();
        
        return result ;
              
    }
    

    public static boolean login(UserDTO user) throws SQLException 
    {
    boolean result = false;
    DriverManager.registerDriver(new ClientDriver());
    Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "root", "root");
    PreparedStatement statement = connection.prepareStatement("SELECT password FROM USERTABLE WHERE EMAIL = ?");
    statement.setString(1, user.getUserName());
    ResultSet rs = statement.executeQuery();
    if (rs.next()) 
    {
        String storedPassword = rs.getString("password");
        if (storedPassword.equals(user.getPassword())) 
        {
            result = true;
        }
    }


    return result;
}

}
