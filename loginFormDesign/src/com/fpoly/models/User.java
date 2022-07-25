/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.models;

import java.util.Date;

/**
 *
 * @author nxlin
 */
public class User {
    int userID;
    int accountID;
    String userName;
    String email;
    String phone;
    String addres;
    boolean gender;
    Date birthday;
    String image;
    int rank;
    int coin;

    public User() {
    }

    public User(int userID, int accountID, String userName, String email, String phone, String addres, boolean gender, Date birthday, String image, int rank, int coin) {
        this.userID = userID;
        this.accountID = accountID;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.addres = addres;
        this.gender = gender;
        this.birthday = birthday;
        this.image = image;
        this.rank = rank;
        this.coin = coin;
    }

    public User(int accountID, String userName, String email) {
        this.accountID = accountID;
        this.userName = userName;
        this.email = email;
    }
    
    

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
    
    
}
