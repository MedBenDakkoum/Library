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
public class Admin extends User{
    public Admin(int UID, String nom, String user, String pass, boolean isAdmin){
        super(UID,nom,user,pass,true);
    }
    public static ArrayList<Student> getStudentList(){
        ArrayList<Student> SL= new ArrayList<Student>();
        Student student= new Student();
        ArrayList<BookBorrowed> BB = new ArrayList<BookBorrowed>();
        BookBorrowed bb;
        try{
            Connection conn = Conn.Conn();
            String QUERY = "Select * from Students,Users WHERE Users.UID=Students.UID";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {

                QUERY = "Select * from BorrowedBooks WHERE UID="+rs.getInt("UID");
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(QUERY);
                while (rs2.next()) {
                    bb = new BookBorrowed(rs2.getString("BID"),rs2.getString("dateEmprunt"),rs2.getString("dateExpiration"));
                    BB.add(bb);
                }
                student = new Student(
                                        rs.getInt("UID"),
                                        rs.getString("Nom"),
                                        rs.getString("User"),
                                        rs.getString("Pass"),
                                        false,
                                        rs.getString("cin"),
                                        true,
                                        BB
                                    );
                SL.add(student);
             }

        }catch(Exception e){
            e.printStackTrace();
        }
        return SL;
        
    }
    public static void addStudent(Student student){
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "INSERT INTO Users(Nom,User,Pass,isAdmin) VALUES(?,?,?,?)";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
            preparedStmt1.setString(1, student.getNom());
            preparedStmt1.setString(2, student.getUser());
            preparedStmt1.setString(3, student.getPass());
            if(student.isAdmin()){
                preparedStmt1.setInt(4, 1);
            }else{
                preparedStmt1.setInt(4, 0);
            }
            preparedStmt1.execute();
            String QUERY2 = "INSERT INTO Students(cin,Subscribed) VALUES(?,?)";
            PreparedStatement preparedStmt2 = conn.prepareStatement(QUERY2);
            preparedStmt2.setString(1, student.getCin());
            if(student.isSubscribed()){
                preparedStmt2.setInt(2, 1);
            }else{
                preparedStmt2.setInt(2, 0);
            }
            preparedStmt2.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void removeStudent(int UID){
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "DELETE FROM Users WHERE UID=?";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
            preparedStmt1.setInt(1, UID);
            preparedStmt1.execute();
            String QUERY2 = "DELETE FROM Students WHERE UID=?";
            PreparedStatement preparedStmt2 = conn.prepareStatement(QUERY2);
            preparedStmt2.setInt(1, UID);
            preparedStmt2.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdateStudent(Student student){
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "UPDATE Users SET Nom=?,User=?,isAdmin=? WHERE UID=?";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
            preparedStmt1.setString(1, student.getNom());
            preparedStmt1.setString(2, student.getUser());
            if(student.isAdmin()){
                preparedStmt1.setInt(3, 1);
            }else{
                preparedStmt1.setInt(3, 0);
            }
            preparedStmt1.setInt(4, student.getUID());
            preparedStmt1.execute();
            String QUERY2 = "UPDATE Students SET cin=?,Subscribed=? WHERE UID=?";
            PreparedStatement preparedStmt2 = conn.prepareStatement(QUERY2);
            preparedStmt2.setString(1, student.getCin());
            if(student.isSubscribed()){
                preparedStmt2.setInt(2, 1);
            }else{
                preparedStmt2.setInt(2, 0);
            }
            preparedStmt2.setInt(3, student.getUID());
            preparedStmt2.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void UpdateBook(Book book){
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "UPDATE Books SET BName=?,Available=?,Quantity=? WHERE BID=?";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
            preparedStmt1.setString(1, book.getBName());
            if(book.isAvailable()){
                preparedStmt1.setInt(2, 1);
            }else{
                preparedStmt1.setInt(2, 0);
            }
            preparedStmt1.setInt(3, book.getQuantity());
            preparedStmt1.setString(4, book.getBID());
            preparedStmt1.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void addBook(Book book){
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "INSERT INTO Books VALUES(?,?,?,?)";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
            preparedStmt1.setString(1, book.getBID());
            preparedStmt1.setString(2, book.getBName());
            if(book.isAvailable()){
                preparedStmt1.setInt(3, 1);
            }else{
                preparedStmt1.setInt(3, 0);
            }
            preparedStmt1.setInt(4, book.getQuantity());
            preparedStmt1.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void removeBook(String BID){
        try{
            Connection conn = Conn.Conn();
            String QUERY1 = "DELETE FROM Books WHERE BID=?";
            PreparedStatement preparedStmt1 = conn.prepareStatement(QUERY1);
            preparedStmt1.setString(1, BID);
            preparedStmt1.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
