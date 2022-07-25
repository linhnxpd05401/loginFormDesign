package com.fpoly.DAO;

import com.fpoly.models.Rate;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.rsa.RSACore;

public class RateDAO extends TheLEAEnglishCenterDAO<Rate, String> {

    String SELECT_ALL_RATE = "SELECT * FROM Rate ORDER BY DATE DESC";
    String SELECT_CHECK_LIKE = "SELECT * FROM Rate WHERE UserLike LIKE ? AND RateID = ?";
    String SELECT_CHECK_DISLIKE = "SELECT * FROM Rate WHERE UserDisLike LIKE ? AND RateID = ?";
    String LIKED_ACTION = "UPDATE Rate SET Like = ? , UserLike = ? WHERE RateID = ?";
    String SELECT_ALL_ID = "SELECT * FROM Rate WHERE RateID = ?";
    String COUNT_STAR_RATE = "SELECT COUNT(Star) As count FROM Rate WHERE Star = ? GROUP BY Star";

    public List<Rate> checkLike(String KeyString, int Id) {
        return selectBySql(SELECT_CHECK_LIKE, KeyString, Id);
    }
    
    public int countStar(int Star){
        int Times = 0;
        try {
            ResultSet rs = XJdbc.executeQuery(COUNT_STAR_RATE, Star);
            while (rs.next()) {                
                  Times = rs.getInt("count");
            }
        } catch (SQLException ex) {
        }
        return Times;
    }
    
    public List<Rate> checkDisLike(String KeyString, int Id) {
        return selectBySql(SELECT_CHECK_DISLIKE, KeyString, Id);
    }

    public void Like(int like, String UserLike, int ID) {
        XJdbc.update(LIKED_ACTION, like, UserLike, ID);
    }
//   public Rate checkDisLike(String KeyString,int Id) {
//        List<Rate> rt = this.selectBySql(SELECT_CHECK_LIKE, KeyString,Id);
//        if (rt.isEmpty()) {
//            return null;
//        }
//        return rt.get(0);
//    }

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

    public Rate selectById(int id) {
        List<Rate> list = this.selectBySql(SELECT_ALL_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
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
    


    @Override
    public Rate selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
