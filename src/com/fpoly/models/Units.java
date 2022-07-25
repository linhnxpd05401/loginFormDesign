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
public class Units {
    private int unitID;
    private int subjectID;
    private String unitName;

    public Units() {
    }

    public Units(int unitID, int subjectID, String unitName) {
        this.unitID = unitID;
        this.subjectID = subjectID;
        this.unitName = unitName;
    }

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    } 
}
