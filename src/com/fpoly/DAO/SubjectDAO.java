/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.DAO;

import com.fpoly.models.Subject;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nxlin
 */
public class SubjectDAO extends TheLEAEnglishCenterDAO<Subject, String>{
    
    String INSERT_SUB="INSERT INTO Subject(SubjectName,Note,SubjectImage,PassingPoint) VALUES(?,?,?,?)";
    
    String SELECT_ALL = "SELECT * FROM Subject";
    
    String UPDATE_SUBJECT = "UPDATE Subject SET SubjectName = ?,Note = ?, SubjectImage = ?,PassingPoint = ? WHERE SubjectID=?";
    
    
     public List<Object[]> SELECT_MODEL() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Object[] model = {
                    rs.getInt("SubjectID"),
                    rs.getString("SubjectName"),
                    rs.getString("Note"),
                    rs.getInt("PassingPoint")
                };
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
     
    
    public Subject selectByIDInt(int ID) {
        String sql = "SELECT * FROM Subject WHERE SubjectID = ?";
        List<Subject> list = selectBySql(sql, ID);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    @Override
    public void insert(Subject entity) {
        XJdbc.update(INSERT_SUB,entity.getSubjectName(),entity.getNote(),entity.getSubjectImage(),entity.getPassingPint());
    }

    @Override
    public void update(Subject entity) {
        XJdbc.update(UPDATE_SUBJECT, entity.getSubjectName(),entity.getNote(),entity.getSubjectImage(),entity.getPassingPint(),entity.getSubjectID());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subject selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Subject> selectAll() {
        String sql = "SELECT * FROM Subject";
        return selectBySql(sql);
    }

    @Override
    protected List<Subject> selectBySql(String sql, Object... args) {
        List<Subject> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Subject entity = new Subject();
                entity.setSubjectID(rs.getInt("SubjectID"));
                entity.setSubjectName(rs.getString("SubjectName"));
                entity.setNote("Note");
                entity.setSubjectImage(rs.getString("SubjectImage"));
                entity.setPassingPint(rs.getInt("PassingPoint"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
