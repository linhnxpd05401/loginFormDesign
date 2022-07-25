/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.DAO;

import java.util.List;
import com.fpoly.models.TestProcessing;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bimzc
 */
public class TestingProgressDAO extends TheLEAEnglishCenterDAO<TestProcessing, String> {

    String SELECT_TOP_10 = "SELECT TOP 10 * FROM [dbo].[TestingProcess] "
            + "WHERE Mark > 10 "
            + "ORDER BY Mark desc";
    String SELECT_ALL = "SELECT * FROM TestingProcess";
    private String SELECT_BY_USER_ID = "SELECT * FROM TestingProcess WHERE UserID = ?";

    public List<TestProcessing> selectTop10() {
        return this.selectBySql(SELECT_TOP_10);
    }
    
    public List<TestProcessing> SelectByUserID(int ID){
        List<TestProcessing> list = this.selectBySql(SELECT_BY_USER_ID, ID);
        return list;
    }
    
     public List<TestProcessing> checkUnlock(int userID, int testID) {
        String sql = "SELECT * FROM TestingProcess WHERE UserID = ? AND TestID = ?";
        return  selectBySql(sql, userID, testID);
    }
    
    public List<TestProcessing> checkPass(int userID, int testID) {
        String sql = "SELECT * FROM TestingProcess WHERE UserID = ? AND TestID = ? AND Status = 1";
        return  selectBySql(sql, userID, testID);
    }
    
    public void updateMark(TestProcessing entity) {
        String sql = "UPDATE TestingProcess SET Mark = ?, TestingDate = ? WHERE UserID = ?";
        XJdbc.update(sql, entity.getMark(), entity.getTestingDay(),entity.getUserID());
    }
    
     public void updateTestPass(TestProcessing entity) {
        String sql = "UPDATE TestingProcess SET Mark = ?,TestingDate = ?, Status = 1 WHERE UserID = ?";
        XJdbc.update(sql, entity.getMark(), entity.getTestingDay(),entity.getUserID());
    }

    @Override
    public void insert(TestProcessing entity) {
        String sql = "INSERT INTO TestingProcess(UserID, TestID, Mark, TestingDate, Status) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, entity.getUserID(), entity.getTestID(), entity.getMark(), entity.getTestingDay(), entity.isStatus());
    }

    @Override
    public void update(TestProcessing entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TestProcessing selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TestProcessing> selectAll() {
        return this.selectBySql(SELECT_ALL);
    }

    @Override
    protected List<TestProcessing> selectBySql(String sql, Object... args) {
        List<TestProcessing> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                TestProcessing ts = new TestProcessing();
                ts.setUserID(rs.getInt("UserID"));
                ts.setTestID(rs.getInt("TestID"));
                ts.setMark(rs.getInt("Mark"));
                ts.setTestingDay(rs.getDate("TestingDate"));
                ts.setStatus(rs.getBoolean("Status"));
                list.add(ts);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
