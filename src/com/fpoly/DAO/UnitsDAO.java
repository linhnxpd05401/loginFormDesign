/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.DAO;

import com.fpoly.models.Units;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nxlin
 */
public class UnitsDAO extends TheLEAEnglishCenterDAO<Units, String> {
    
     public List<Units> selectBySubjectId(int id) {
        String sql = "SELECT * FROM Units WHERE SubjectID = ?";
        List<Units> list = selectBySql(sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return  list;
    }

    @Override
    public void insert(Units entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Units entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Units selectById(String id) {
        String sql = "SELECT * FROM Units WHERE UnitID = ?";
        List<Units> list = selectBySql(sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return  list.get(0);
    }

    @Override
    public List<Units> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Units> selectBySql(String sql, Object... args) {
        List<Units> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Units entity = new Units();
                entity.setUnitID(rs.getInt("UnitID"));
                entity.setSubjectID(rs.getInt("SubjectID"));
                entity.setUnitName(rs.getString("UnitName"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
