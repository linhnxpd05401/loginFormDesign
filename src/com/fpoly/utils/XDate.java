/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author nxlin
 */
public class XDate {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat();
    
    public static Date toDate(String date, String pattent) {
        try {
            DATE_FORMAT.applyPattern(pattent);
            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String toString(Date date, String pattern) {
        DATE_FORMAT.applyPattern(pattern);
        return DATE_FORMAT.format(date);
    }
    
    public static Date addDays(Date date, long days) {
       date.setTime(date.getTime() + days*24*60*60*1000);
       return date;
    }

}
