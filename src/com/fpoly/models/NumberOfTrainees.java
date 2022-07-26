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
public class NumberOfTrainees {
    private int Month;
    private int numberOfTrainees;

    public NumberOfTrainees() {
    }

    public NumberOfTrainees(int Month, int numberOfTrainees) {
        this.Month = Month;
        this.numberOfTrainees = numberOfTrainees;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int Month) {
        this.Month = Month;
    }

    public int getNumberOfTrainees() {
        return numberOfTrainees;
    }

    public void setNumberOfTrainees(int numberOfTrainees) {
        this.numberOfTrainees = numberOfTrainees;
    }
    
    
}
