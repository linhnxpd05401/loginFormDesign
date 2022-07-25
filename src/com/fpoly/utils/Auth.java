/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.utils;

import com.fpoly.models.Accounts;


/**
 *
 * @author nxlin
 */
public class Auth {
    public static Accounts acc = null;
    
    public static void clear() {
        Auth.acc = null;
    }
    
    public static boolean isLogin() {
        return Auth.acc != null;
    }
    
    public static boolean isAdmin() {
        return  Auth.isLogin() && acc.isRole();
    }
}
