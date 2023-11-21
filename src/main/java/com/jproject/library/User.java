/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jproject.library;

/**
 *
 * @author yami
 */
public class User {
        private int UID;
    private String Nom;
    private String User;
    private String Pass;
    private boolean isAdmin;
    public User() {}
    public User(int UID, String nom, String user, String pass, boolean isAdmin) {
        this.UID=UID;
        this.Nom = nom;
        this.User = user;
        this.Pass = pass;
        this.isAdmin = isAdmin;
    }
    public int getUID(){
        return this.UID;
    }
    public void setUID(int uid){
        this.UID=uid;
    }

    public String getNom() {
        return this.Nom;
    }
    public void setNom(String nom) {
        this.Nom = nom;
    }
    public String getUser() {
        return this.User;
    }
    public void setUser(String user) {
        this.User = user;
    }
    public String getPass() {
        return this.Pass;
    }
    public void setPass(String pass) {
        this.Pass = pass;
    }
    public boolean isAdmin() {
        return this.isAdmin;
    }
    public void setIsAdmin(boolean isadmin) {
        this.isAdmin = isadmin;
    }
}
