/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.DAO;

import com.fpoly.models.QuestionExercise;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nxlin
 */
public class QuestionExerciseDAO extends TheLEAEnglishCenterDAO<QuestionExercise, String>{
    
    public List<QuestionExercise> selectBySubjectID(int ID) {
        String sql = "SELECT * FROM AnswersAndQuestionsForExercise WHERE SubjectID = ? ";
        List<QuestionExercise> list = selectBySql(sql, ID);
        if(list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public void insert(QuestionExercise entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(QuestionExercise entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuestionExercise selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuestionExercise> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<QuestionExercise> selectBySql(String sql, Object... args) {
        List<QuestionExercise> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                QuestionExercise entity = new QuestionExercise();
                entity.setQuestionID(rs.getInt("QuestionID"));
                entity.setSubjectID(rs.getInt("SubjectID"));
                entity.setRequest(rs.getString("Request"));
                entity.setContent(rs.getString("QuestionContent"));
                entity.setAsw1(rs.getString("Answer1"));
                entity.setAsw2(rs.getString("Answer2"));
                entity.setAsw3(rs.getString("Answer3"));
                entity.setAsw4(rs.getString("Answer4"));
                entity.setAswR(rs.getString("RightAnswer"));
                entity.setPoint(rs.getInt("Point"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    
    
}
