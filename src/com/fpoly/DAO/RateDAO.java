package com.fpoly.DAO;

import com.fpoly.models.Rate;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sun.security.rsa.RSACore;

public class RateDAO extends TheLEAEnglishCenterDAO<Rate, String> {
    
    String SELECT_ALL_RATE = "SELECT * FROM Rate";

    @Override
    public void insert(Rate entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Rate entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rate selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rate> selectAll() {
        return this.selectBySql(SELECT_ALL_RATE);
    }

    @Override
    protected List<Rate> selectBySql(String sql, Object... args) {
        List<Rate> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Rate rt = new Rate();
                rt.setRateID(rs.getInt("RateID"));
                rt.setLike(rs.getInt("Like"));
                rt.setDisLike(rs.getInt("DisLike"));
                rt.setUserLike(rs.getString("UserLike"));
                rt.setUserDisLike(rs.getString("UserDisLike"));
                rt.setStar(rs.getInt("Star"));
                rt.setUserID(rs.getInt("UserID"));
                rt.setComment(rs.getString("Comment"));
                rt.setDate(rs.getDate("Date"));
                list.add(rt);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
        }
        return list;
    }

}
