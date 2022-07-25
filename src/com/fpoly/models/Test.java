/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.models;

/**
 *
 * @author bimzc
 */
public class Test {
    private int testID;
    private int level;
    private int numberOfQues;
    private int time;
    private String testName;
    private int passingPoint;
    private int coinToPass;

    public Test() {
    }

    public Test(int testID, int level, int numberOfQues, int time, String testName, int passingPoint, int coinToPass) {
        this.testID = testID;
        this.level = level;
        this.numberOfQues = numberOfQues;
        this.time = time;
        this.testName = testName;
        this.passingPoint = passingPoint;
        this.coinToPass = coinToPass;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumberOfQues() {
        return numberOfQues;
    }

    public void setNumberOfQues(int numberOfQues) {
        this.numberOfQues = numberOfQues;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getPassingPoint() {
        return passingPoint;
    }

    public void setPassingPoint(int passingPoint) {
        this.passingPoint = passingPoint;
    }

    public int getCoinToPass() {
        return coinToPass;
    }

    public void setCoinToPass(int coinToPass) {
        this.coinToPass = coinToPass;
    }

   
    
    
}
