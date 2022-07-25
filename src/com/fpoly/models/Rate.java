
package com.fpoly.models;

import java.util.Date;


public class Rate {
    int RateID,Star,Like,DisLike,UserID;
    Date Date;
    String UserDisLike,UserLike,Comment;

    public Rate() {
    }

    public Rate(int RateID, int Star, int Like, int DisLike, int UserID, Date Date, String UserDisLike, String UserLike,String Comment) {
        this.RateID = RateID;
        this.Star = Star;
        this.Like = Like;
        this.DisLike = DisLike;
        this.UserID = UserID;
        this.Date = Date;
        this.UserDisLike = UserDisLike;
        this.UserLike = UserLike;
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

    public int getLike() {
        return Like;
    }

    public void setLike(int Like) {
        this.Like = Like;
    }

    public int getDisLike() {
        return DisLike;
    }

    public void setDisLike(int DisLike) {
        this.DisLike = DisLike;
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

    public String getUserDisLike() {
        return UserDisLike;
    }

    public void setUserDisLike(String UserDisLike) {
        this.UserDisLike = UserDisLike;
    }

    public String getUserLike() {
        return UserLike;
    }

    public void setUserLike(String UserLike) {
        this.UserLike = UserLike;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }
    
    
    
}
