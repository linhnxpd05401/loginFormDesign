/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.models;

import java.util.logging.Logger;

/**
 *
 * @author nxlin
 */
public class LoginAccounts {
    int ID;
    String username;
    String Email;
    String password;
    boolean role;
    int vetifyCode;
    boolean status;

    public LoginAccounts() {
    }

    public LoginAccounts(int iD, String username, String Email, String password, boolean role, int vetifyCode, boolean status) {
        this.ID = ID;
        this.username = username;
        this.Email = Email;
        this.password = password;
        this.role = role;
        this.vetifyCode = vetifyCode;
        this.status = status;
    }

    public LoginAccounts(String Email, String password, boolean role) {
        this.Email = Email;
        this.password = password;
        this.role = role;
    }

    public LoginAccounts(String Email, String password) {
        this.Email = Email;
        this.password = password;
    }

    public LoginAccounts(String username, String Email, String password) {
        this.username = username;
        this.Email = Email;
        this.password = password;
    }

    public LoginAccounts(String username, String Email, String password, int vetifyCode) {
        this.username = username;
        this.Email = Email;
        this.password = password;
        this.vetifyCode = vetifyCode;
    }
    
    



    
    
    
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public int getVetifyCode() {
        return vetifyCode;
    }

    public void setVetifyCode(int vetifyCode) {
        this.vetifyCode = vetifyCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

    
    
}
