/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vku.common;

/**
 *
 * @author admin!
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
  private Connection cn;
//    private static final String URL = "jdbc:mysql://localhost:3306/dacs", "root", "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dacs", "root", "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    
}
