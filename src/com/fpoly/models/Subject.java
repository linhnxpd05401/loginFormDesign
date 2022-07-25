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
public class Subject {

    private int subjectID;
    private String subjectName;
    private String note;
    private String subjectImage;
    private int passingPint;

    public Subject() {
    }

    public Subject(int subjectID, String subjectName, String note, String subjectImage, int passingPint) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.note = note;
        this.subjectImage = subjectImage;
        this.passingPint = passingPint;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSubjectImage() {
        return subjectImage;
    }

    public void setSubjectImage(String subjectImage) {
        this.subjectImage = subjectImage;
    }

    public int getPassingPint() {
        return passingPint;
    }

    public void setPassingPint(int passingPint) {
        this.passingPint = passingPint;
    }

    

}
