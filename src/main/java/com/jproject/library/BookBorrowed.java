/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jproject.library;

/**
 *
 * @author yami
 */
public class BookBorrowed {
    private String BID;
    private String dateEmprunt;
    private String dateExpiration;
    public BookBorrowed(){

    }
    public BookBorrowed(String bID, String dateEmprunt, String dateExpiration) {
        this.BID = bID;
        this.dateEmprunt = dateEmprunt;
        this.dateExpiration = dateExpiration;
    }
    public String getBID() {
        return this.BID;
    }
    public void setBID(String bID) {
        this.BID = bID;
    }
    public String getDateEmprunt() {
        return this.dateEmprunt;
    }
    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }
    public String getDateExpiration() {
        return this.dateExpiration;
    }
    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
