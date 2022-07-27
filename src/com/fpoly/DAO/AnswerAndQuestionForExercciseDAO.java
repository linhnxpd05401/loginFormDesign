/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.DAO;

import com.fpoly.models.AnswerAndQuestionForExerccise;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bimzc
 */
public class AnswerAndQuestionForExercciseDAO extends TheLEAEnglishCenterDAO<AnswerAndQuestionForExerccise, String> {

    String one = "QuestionID";
    String two = "SubjectID";
    String three = "Request";
    String four = "QuestionContent";
    String five = "Answer1";
    String six = "Answer2";
    String seven = "Answer3";
    String eight = "Answer4";
    String nine = "RightAnswer";
    String ten = "Point";

    String INSERT_INTO = "INSERT INTO AnswersAndQuestionsForExercise(" + two + "," + three + "," + four + "," + five + "," + six + "," + seven + "," + eight + "," + nine + "," + ten + ") "
            + "VALUES(?,?,?,?,?,?,?,?,?)";

    String SELECT_ALL = "SELECT * FROM AnswersAndQuestionsForExercise";

    String SELECT_SUBJECT_ID = "SELECT * FROM AnswersAndQuestionsForExercise WHERE " + one + " = ?";

    String UPDATE = "ALTER TABLE AnswersAndQuestionsForExercise SET " + two + " = ? " + three + " = ? " + four + " = ? " + five + " = ? " + six + " = ? " + seven + " = ? " + eight + " = ? " + nine + " = ? " + ten + " WHERE " + one + " = ?";

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
            ResultSet rs = XJdbc.executeQuery(SELECT_SUBJECT_ID,id);
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
    
    public AnswerAndQuestionForExerccise SELECT_BY_ID(int id){
        List<AnswerAndQuestionForExerccise> list = new ArrayList<>();
        list = this.selectBySql(SELECT_SUBJECT_ID,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
     
     public List<AnswerAndQuestionForExerccise> selectByTestID(int id) {
         String sql = "SELECT * FROM AnswersAndQuestionsForTest WHERE SubjectID = ?";
         List<AnswerAndQuestionForExerccise> list = selectBySql(sql, id);
        return list;
     }

    @Override
    public void insert(AnswerAndQuestionForExerccise entity) {
        try {
            XJdbc.update(INSERT_INTO, entity.getSubjectID(), entity.getRequest(), entity.getQuestionContent(), entity.getAnswer1(), entity.getAnswer2(), entity.getAnswer3(), entity.getAnswer4(), entity.getRightAnswer(), entity.getPoint());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(AnswerAndQuestionForExerccise entity) {
        try {
            XJdbc.update(UPDATE, entity.getSubjectID(), entity.getRequest(), entity.getQuestionContent(), entity.getAnswer1(), entity.getAnswer2(), entity.getAnswer3(), entity.getAnswer4(), entity.getRightAnswer(), entity.getPoint(), entity.getQuestionID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnswerAndQuestionForExerccise selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AnswerAndQuestionForExerccise> selectAll() {
        String sql ="SELECT ** FROM AnswersAndQuestionsForTest";
        List<AnswerAndQuestionForExerccise> list = selectBySql(sql);
        if(list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    protected List<AnswerAndQuestionForExerccise> selectBySql(String sql, Object... args) {
        List<AnswerAndQuestionForExerccise> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                AnswerAndQuestionForExerccise aaq = new AnswerAndQuestionForExerccise();
                aaq.setQuestionID(rs.getInt(one));
                aaq.setSubjectID(rs.getInt(two));
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
