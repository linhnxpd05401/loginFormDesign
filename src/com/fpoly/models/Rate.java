
package com.fpoly.models;

import java.util.Date;


public class Rate {
    int RateID,Star,UserID;
    Date Date;
    String Comment;

    public Rate() {
    }

    public Rate(int RateID, int Star, int UserID, Date Date, String Comment) {
        this.RateID = RateID;
        this.Star = Star;
        this.UserID = UserID;
        this.Date = Date;
        this.Comment = Comment;
    }

    public int getRateID() {
        return RateID;
    }

    public void setRateID(int RateID) {
        this.RateID = RateID;
    }

    public int getStar() {
        return Star;
    }

    public void setStar(int Star) {
        this.Star = Star;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }
    
    
    
    
}
