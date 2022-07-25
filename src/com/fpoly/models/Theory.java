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
public class Theory {
    private int theoryID;
    private int unitID;
    private String TheoruContent;

    public Theory() {
    }

    public Theory(int theoryID, int unitID, String TheoruContent) {
        this.theoryID = theoryID;
        this.unitID = unitID;
        this.TheoruContent = TheoruContent;
    }

    public int getTheoryID() {
        return theoryID;
    }

    public void setTheoryID(int theoryID) {
        this.theoryID = theoryID;
    }

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public String getTheoruContent() {
        return TheoruContent;
    }

    public void setTheoruContent(String TheoruContent) {
        this.TheoruContent = TheoruContent;
    }
    
    
}
