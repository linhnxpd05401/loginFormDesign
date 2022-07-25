/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.models;

import java.util.Date;

/**
 *
 * @author bimzc
 */
public class Announce {
        private String Tag,Content;
        Date DateCreate;
        int UserID;
    public Announce() {
    }

    public Announce(String Tag, String Content, Date DateCreate,int UserID) {
        this.Tag = Tag;
        this.Content = Content;
        this.DateCreate = DateCreate;
        this.UserID = UserID;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
        
     
}
