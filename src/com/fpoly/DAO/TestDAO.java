/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.DAO;

import com.fpoly.models.Test;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bimzc
 */
public class TestDAO extends TheLEAEnglishCenterDAO<Test, String> {

    private String SELECT_ALL = "SELECT * FROM Test";
    
    private String SELECT_BY_ID = "SELECT * FROM Test WHERE TestID = ?";

    public List<Object[]> SELECT_MODEL() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Object[] model = {
                    rs.getInt("TestID"),
                    rs.getInt("Level"),
                    rs.getInt("NumberOfQuestions")
                };
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Test SELECT_BY_ID(int id){
        List<Test> list = new ArrayList<>();
        list = this.selectBySql(SELECT_BY_ID,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    

    @Override
    public void insert(Test entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Test entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Test selectById(String id) {
        List<Test> list = new ArrayList<>();
        list = this.selectBySql(SELECT_BY_ID,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Test> selectAll() {
        return this.selectBySql(SELECT_ALL);
    }

    @Override
    protected List<Test> selectBySql(String sql, Object... args) {
        List<Test> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Test ts = new Test();
                ts.setTestID(rs.getInt("TestID"));
                ts.setLevel(rs.getInt("Level"));
                ts.setNumberOfQues(rs.getInt("NumberOfQuestions"));
                ts.setTime(rs.getInt("Time"));
                ts.setTestName(rs.getString("TestName"));
                ts.setPassingPoint(rs.getInt("PassingPoint"));
                ts.setCoinToPass(rs.getInt("NumberOfCoinForUnlock"));
                list.add(ts);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
