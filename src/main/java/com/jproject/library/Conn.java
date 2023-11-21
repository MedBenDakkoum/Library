/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jproject.library;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author yami
 */
public class Conn {
        public static Connection Conn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/Bibl";
            
        try {
            Connection conn = DriverManager.getConnection(URL,"biblio","bib123");
            return conn;
        } catch (Exception e) {
            throw e;
        }
    }
}
