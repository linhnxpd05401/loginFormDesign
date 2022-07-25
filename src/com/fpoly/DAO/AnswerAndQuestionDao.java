/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.DAO;

import com.fpoly.models.AnswerAndQuestion;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bimzc
 */
public class AnswerAndQuestionDao extends TheLEAEnglishCenterDAO<AnswerAndQuestion, String> {

    String one = "QuestionID";
    String two = "TestID";
    String three = "Request";
    String four = "QuestionContent";
    String five = "Answer1";
    String six = "Answer2";
    String seven = "Answer3";
    String eight = "Answer4";
    String nine = "RightAnswer";
    String ten = "Point";

    String INSERT_INTO = "INSERT INTO AnswersAndQuestionsForTest(" + two + "," + three + "," + four + "," + five + "," + six + "," + seven + "," + eight + "," + nine + "," + ten + ") "
            + "VALUES(?,?,?,?,?,?,?,?,?)";

    String SELECT_ALL = "SELECT * FROM AnswersAndQuestionsForTest";
    
    String SELECT_TEST_ID= "SELECT * FROM AnswersAndQuestionsForTest WHERE "+one+" = ?";

    String UPDATE = "ALTER TABLE AnswersAndQuestionsForTest SET " + two + " = ? " + three + " = ? " + four + " = ? " + five + " = ? " + six + " = ? " + seven + " = ? " + eight + " = ? " + nine + " = ? " + ten + " WHERE " + one + " = ?";

    public List<Object[]> SELECT_MODEL() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Object[] model = {
                    rs.getInt(one),
                    rs.getInt(two),
                    rs.getString(three),
                    rs.getString(four),
                    rs.getString(five),
                    rs.getString(six),
                    rs.getString(seven),
                    rs.getString(eight),
                    rs.getString(nine),
                    rs.getString(ten)
                };
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Object[]> SELECT_MODEL(String id) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(SELECT_TEST_ID,id);
            while (rs.next()) {
                Object[] model = {
                    rs.getInt(one),
                    rs.getInt(two),
                    rs.getString(three),
                    rs.getString(four),
                    rs.getString(five),
                    rs.getString(six),
                    rs.getString(seven),
                    rs.getString(eight),
                    rs.getString(nine),
                    rs.getString(ten)
                };
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
     public AnswerAndQuestion SELECT_BY_ID(int id){
        List<AnswerAndQuestion> list = new ArrayList<>();
        list = this.selectBySql(SELECT_TEST_ID,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
     
     public List<AnswerAndQuestion> selectByTestID(int id) {
         String sql = "SELECT * FROM AnswersAndQuestionsForTest WHERE TestID = ?";
         List<AnswerAndQuestion> list = selectBySql(sql, id);
        return list;
     }

    @Override
    public void insert(AnswerAndQuestion entity) {
        try {
            XJdbc.executeQuery(INSERT_INTO, entity.getTestID(), entity.getRequest(), entity.getQuestionContent(), entity.getAnswer1(), entity.getAnswer2(), entity.getAnswer3(), entity.getAnswer4(), entity.getRightAnswer(), entity.getPoint());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(AnswerAndQuestion entity) {
        try {
            XJdbc.executeQuery(UPDATE, entity.getTestID(), entity.getRequest(), entity.getQuestionContent(), entity.getAnswer1(), entity.getAnswer2(), entity.getAnswer3(), entity.getAnswer4(), entity.getRightAnswer(), entity.getPoint(), entity.getQuestionID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnswerAndQuestion selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AnswerAndQuestion> selectAll() {
        String sql ="SELECT ** FROM AnswersAndQuestionsForTest";
        List<AnswerAndQuestion> list = selectBySql(sql);
        if(list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    protected List<AnswerAndQuestion> selectBySql(String sql, Object... args) {
        List<AnswerAndQuestion> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                AnswerAndQuestion aaq = new AnswerAndQuestion();
                aaq.setQuestionID(rs.getInt(one));
                aaq.setTestID(rs.getInt(two));
                aaq.setRequest(rs.getString(three));
                aaq.setQuestionContent(rs.getString(four));
                aaq.setAnswer1(rs.getString(five));
                aaq.setAnswer2(rs.getString(six));
                aaq.setAnswer3(rs.getString(seven));
                aaq.setAnswer4(rs.getString(eight));
                aaq.setRightAnswer(rs.getString(nine));
                aaq.setPoint(rs.getInt(ten));
                list.add(aaq);
            }
        } catch (Exception e) {
        }
        return list;
    }

}
