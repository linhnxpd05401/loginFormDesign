/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.DAO;

import com.fpoly.models.Theory;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nxlin
 */
public class TheorryDAO extends TheLEAEnglishCenterDAO<Theory, String>{

    
    public List<Theory> selectByUnitID(int ID) {
        String sql = "SELECT * FROM Theory Where UnitID = ?";
        List<Theory> list = selectBySql(sql, ID);
        if(list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    @Override
    public void insert(Theory entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Theory entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Theory selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Theory> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Theory> selectBySql(String sql, Object... args) {
        List<Theory> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Theory entity = new Theory();
                entity.setTheoryID(rs.getInt("TheoryID"));
                entity.setUnitID(rs.getInt("UnitID"));
                entity.setTheoruContent(rs.getString("TheoryContent"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
