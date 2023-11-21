/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jproject.library;
import java.util.ArrayList;
import java.util.*;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;
/**
 *
 * @author yami
 */
public class Student extends User{
    
    String cin;
    boolean Subscribed;
    ArrayList<BookBorrowed> BorrowedBooks;

    public Student() {
    }

    public Student(int UID,String nom, String user, String pass, boolean isAdmin, String cin, boolean subscribed,ArrayList<BookBorrowed> borrowedBooks) {
        super(UID, nom, user, pass, false);
        this.cin = cin;
        this.Subscribed = subscribed;
        this.BorrowedBooks = borrowedBooks;
    }
    public int getUID(){
        return super.getUID();
    }

    public void setUID(int no){
        super.setUID(no);
    }
    public String getNom(){
        return super.getNom();
    }
    public void setNom(String n){
        super.setNom(n);
    }
    public boolean isAdmin(){
        return super.isAdmin();
    }


    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public boolean isSubscribed() {
        return this.Subscribed;
    }

    public void setSubscription(boolean subscribed) {
        this.Subscribed = subscribed;
    }

    public static ArrayList<BookBorrowed> getBorrowedBooks(int UID) {
        BookBorrowed bb1;
        ArrayList<BookBorrowed> bb= new ArrayList<BookBorrowed>();
        try{            
            Connection conn = Conn.Conn();
            String QUERY = "Select * from BorrowedBooks WHERE (UID=?)";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY);
            preparedStmt1.setInt(1, UID);
            Statement stmt = conn.createStatement();
            ResultSet rs = preparedStmt1.executeQuery();

            while (rs.next()) {
                bb1 = new BookBorrowed(
                    rs.getString("BID"),
                    rs.getString("dateEmprunt"),
                    rs.getString("dateExpiration")
                );
                bb.add(bb1);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return bb;
    }

    public void setBorrowedBooks(ArrayList<BookBorrowed> borrowedBooks) {
        this.BorrowedBooks = borrowedBooks;
    }
    public BookBorrowed SearchBorrowedBook(String BID){
        BookBorrowed bb= new BookBorrowed();
        try{            
            Connection conn = Conn.Conn();
            String QUERY = "Select * from BorrowedBooks WHERE (UID=?) AND (BID=?)";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY);
            preparedStmt1.setInt(1, this.getUID());
            preparedStmt1.setString(2, BID);
            Statement stmt = conn.createStatement();
            ResultSet rs = preparedStmt1.executeQuery(QUERY);

            while (rs.next()) {
                bb = new BookBorrowed(
                    rs.getString("BID"),
                    rs.getString("dateEmprunt"),
                    rs.getString("dateExpiration")
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return bb;
    }
    public static void BorrowBook(int UID,String BID){
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "INSERT INTO BorrowedBooks VALUES(?,?,?,?)";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
            preparedStmt1.setInt(1, UID);
            preparedStmt1.setString(2, BID);
            preparedStmt1.setString(3, java.time.LocalDate.now().toString());
            preparedStmt1.setString(4, java.time.LocalDate.now().plusDays(10).toString());
            preparedStmt1.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        BookList.decrementQuantityOfBook(BID, 1);
    }
    public static void ReturnBook(int UID,String BID){
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "DELETE FROM BorrowedBooks WHERE (UID=?) AND (BID=?) ";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
            preparedStmt1.setInt(1, UID);
            preparedStmt1.setString(2, BID);
            preparedStmt1.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
        BookList.incrementQuantityOfBook(BID, 1);
    }
    public static String getNameByUID(int UID){
        String s = "";
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "Select Nom from Users WHERE UID="+UID;
            Statement stmt2 = conn.createStatement();
            ResultSet rs = stmt2.executeQuery(QUERY1);
            while(rs.next()){
                s=rs.getString("Nom");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }
}
