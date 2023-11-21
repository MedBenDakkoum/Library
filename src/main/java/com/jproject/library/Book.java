/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jproject.library;

/**
 *
 * @author yami
 */
public class Book {
    private String BID;
    private String BName;
    private boolean Available;
    private int Quantity;
    public Book(){}
    public Book(String BID,String bname, boolean avail,int quantity){
        this.BID=BID;
        this.BName =bname;
        this.Available=avail;
        this.Quantity=quantity;
    }
    public String getBID() {
        return this.BID;
    }
    public void setBID(String bID) {
        this.BID = bID;
    }
    public String getBName() {
        return this.BName;
    }
    public void setBName(String bName) {
        this.BName = bName;
    }
    public boolean isAvailable() {
        return this.Available;
    }
    public void setAvailable(boolean available) {
        this.Available = available;
    }
    public int getQuantity() {
        return this.Quantity;
    }
    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
}
