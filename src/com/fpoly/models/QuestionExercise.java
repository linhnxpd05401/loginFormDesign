/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.models;

/**
 *
 * @author nxlin
 */
public class QuestionExercise {
    private int questionID;
    private int subjectID;
    private String request;
    private String content;
    private String asw1;
    private String asw2;
    private String asw3;
    private String asw4;
    private String aswR;
    private int point;

    public QuestionExercise() {
    }

    public QuestionExercise(int questionID, int subjectID, String request, String content, String asw1, String asw2, String asw3, String asw4, String aswR, int point) {
        this.questionID = questionID;
        this.subjectID = subjectID;
        this.request = request;
        this.content = content;
        this.asw1 = asw1;
        this.asw2 = asw2;
        this.asw3 = asw3;
        this.asw4 = asw4;
        this.aswR = aswR;
        this.point = point;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAsw1() {
        return asw1;
    }

    public void setAsw1(String asw1) {
        this.asw1 = asw1;
    }

    public String getAsw2() {
        return asw2;
    }

    public void setAsw2(String asw2) {
        this.asw2 = asw2;
    }

    public String getAsw3() {
        return asw3;
    }

    public void setAsw3(String asw3) {
        this.asw3 = asw3;
    }

    public String getAsw4() {
        return asw4;
    }

    public void setAsw4(String asw4) {
        this.asw4 = asw4;
    }

    public String getAswR() {
        return aswR;
    }

    public void setAswR(String aswR) {
        this.aswR = aswR;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    
}
