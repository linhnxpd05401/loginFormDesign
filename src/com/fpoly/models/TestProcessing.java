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
public class TestProcessing {

    private int ProcessID, UserID, TestID, Mark;
    private Date TestingDay;
    private boolean status;

    public TestProcessing() {
    }

    public TestProcessing(int ProcessID, int UserID, int TestID, int Mark, Date TestingDay, boolean status) {
        this.ProcessID = ProcessID;
        this.UserID = UserID;
        this.TestID = TestID;
        this.Mark = Mark;
        this.TestingDay = TestingDay;
        this.status = status;
    }

    public TestProcessing(int UserID, int TestID, int Mark, Date TestingDay, boolean status) {
        this.UserID = UserID;
        this.TestID = TestID;
        this.Mark = Mark;
        this.TestingDay = TestingDay;
        this.status = status;
    }

    public TestProcessing(int UserID, int Mark, Date TestingDay) {
        this.UserID = UserID;
        this.Mark = Mark;
        this.TestingDay = TestingDay;
    }
    
    
    
    

    public int getProcessID() {
        return ProcessID;
    }

    public void setProcessID(int ProcessID) {
        this.ProcessID = ProcessID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getTestID() {
        return TestID;
    }

    public void setTestID(int TestID) {
        this.TestID = TestID;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int Mark) {
        this.Mark = Mark;
    }

    public Date getTestingDay() {
        return TestingDay;
    }

    public void setTestingDay(Date TestingDay) {
        this.TestingDay = TestingDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

}
