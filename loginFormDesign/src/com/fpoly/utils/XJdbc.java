/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nxlin
 */
public class XJdbc {
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbUrl = "jdbc:sqlserver://LINHNGUYEN\\SQLEXPRESS:1433;databaseName=TheLEAEnglishCenter";
    public static String username = "sa";
    public static String password = "123456";
    
    
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(XJdbc.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public static PreparedStatement getStmt(String sql,Object...args) throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl,username,password);
        PreparedStatement pstm = null;
        if(sql.trim().startsWith("{")) {
            pstm = conn.prepareCall(sql);
        }else{
            pstm = conn.prepareStatement(sql);
        }
        
        for(int i = 0; i <args.length; i++) {
            pstm.setObject(i + 1, args[i]);
        }
        return pstm;
    }
    
    public static int update(String sql, Object...args) {
        try {
            PreparedStatement psmt = getStmt(sql, args);
            try {
                return psmt.executeUpdate();
            }finally{
                psmt.getConnection().close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static ResultSet executeQuery(String sql, Object...args) throws SQLException {
            PreparedStatement pstm = getStmt(sql, args);
            return pstm.executeQuery();
    }
    
    public static Object value(String sql, Object...args) {
        try {
            ResultSet rs = XJdbc.executeQuery(sql,args);
            if(rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
