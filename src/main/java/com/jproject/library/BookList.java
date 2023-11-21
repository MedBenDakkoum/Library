/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jproject.library;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author yami
 */
public class BookList {

    public static ArrayList<Book> getBL(){
        ArrayList<Book> BL= new ArrayList<Book>();
        Book book= new Book();
        try{
            Connection conn = Conn.Conn();
            String QUERY = "SELECT * FROM Books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                if(rs.getInt("Available")==1){
                    book = new Book(rs.getString("BID"),rs.getString("BName"),true,rs.getInt("Quantity"));
                }
                else{
                    book = new Book(rs.getString("BID"),rs.getString("BName"),false,rs.getInt("Quantity"));
                }
                BL.add(book);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return BL;
        
    }
    public static ArrayList<Book> getBL(String sv){
        ArrayList<Book> BL= new ArrayList<Book>();
        Book book= new Book();
        try{
            Connection conn = Conn.Conn();
            String QUERY = "SELECT * FROM Books WHERE BName LIKE"+sv;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                if(rs.getInt("Available")==1){
                    book = new Book(rs.getString("BID"),rs.getString("BName"),true,rs.getInt("Quantity"));
                }
                else{
                    book = new Book(rs.getString("BID"),rs.getString("BName"),false,rs.getInt("Quantity"));
                }
                BL.add(book);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return BL;
        
    }
    public static void incrementQuantityOfBook(String BID,int Quan){
        try{
            Connection conn = Conn.Conn();
            String QUERY = "Select Quantity from Books WHERE BID="+BID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                String QUERY1 = "UPDATE Books SET Quantity=? WHERE BID=?";
                PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
                preparedStmt1.setInt(1, rs.getInt("Quantity")+Quan);
                preparedStmt1.setString(2,BID);
                preparedStmt1.execute();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void decrementQuantityOfBook(String BID,int Quan){
        try{
            Connection conn = Conn.Conn();
            String QUERY = "Select Quantity from Books WHERE BID="+BID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                String QUERY1 = "UPDATE Books SET Quantity=? WHERE BID=?";
                PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
                preparedStmt1.setInt(1, rs.getInt("Quantity")-Quan);
                preparedStmt1.setString(2,BID);
                preparedStmt1.execute();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
