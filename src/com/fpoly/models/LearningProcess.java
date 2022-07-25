
package com.fpoly.models;

import java.util.Date;

public class LearningProcess {
    private int processID;
    private int userID;
    private int subjectID;
    private int mark;
    private Date learningDate;
    private boolean status;

    public LearningProcess() {
    }

    public LearningProcess(int processID, int userID, int subjectID, int mark, Date learningDate, boolean status) {
        this.processID = processID;
        this.userID = userID;
        this.subjectID = subjectID;
        this.mark = mark;
        this.learningDate = learningDate;
        this.status = status;
    }

    public LearningProcess(int userID, int subjectID, int mark, Date learningDate, boolean status) {
        this.userID = userID;
        this.subjectID = subjectID;
        this.mark = mark;
        this.learningDate = learningDate;
        this.status = status;
    }
    
    

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getLearningDate() {
        return learningDate;
    }

    public void setLearningDate(Date learningDate) {
        this.learningDate = learningDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
