/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.DAO;

import com.fpoly.models.Announce;
import com.fpoly.utils.XDate;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author bimzc
 */
public class AnnouceDAO extends TheLEAEnglishCenterDAO<Announce, String> {

    private String SELECT_ALL_ORDER = "Select * from Announce order by DateCreate desc";
    private String SELECT_BY_TAG = "Select * from Announce where Tag = ?";
    private String SELECT_BY_ID = "Select * from Announce where UserID = ?";

    public Announce selectByTag(String Tag) {
        List<Announce> ac = this.selectBySql(SELECT_BY_TAG, Tag);
        if (ac.isEmpty()) {
            return null;
        }
        return ac.get(0);
    }
    public Announce selectByID(int ID) {
        List<Announce> ac = this.selectBySql(SELECT_BY_ID, ID);
        if (ac.isEmpty()) {
            return null;
        }
        return ac.get(0);
    }

    @Override
    public void insert(Announce entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Announce entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Announce selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Announce> selectAll() {
        return this.selectBySql(SELECT_ALL_ORDER);
    }

    @Override
    protected List<Announce> selectBySql(String sql, Object... args) {
        List<Announce> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Announce ac = new Announce();
                ac.setTag(rs.getString("Tag"));
                ac.setContent(rs.getString("Content"));
                ac.setDateCreate(rs.getDate("DateCreate"));
                ac.setUserID(rs.getInt("UserID"));
                list.add(ac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
