package com.fpoly.DAO;

import com.fpoly.dialog.MessageDialog;
import com.fpoly.main.Main;
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
    String SELECT_ALL_ID = "SELECT * FROM Rate WHERE RateID = ?";
    String COUNT_STAR_RATE = "SELECT COUNT(Star) As count FROM Rate WHERE Star = ? GROUP BY Star";

    String INSERT_RATE = "INSERT INTO Rate(Star,Comment,UserID,Date) VALUES (?,?,?,?)";

    public int countStar(int Star) {
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

    @Override
    public void insert(Rate entity) {
        XJdbc.update(INSERT_RATE, entity.getStar(), entity.getComment(), entity.getUserID(), entity.getDate());
        MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
        mess.showMessage(MessageDialog.MessageType.INFORMATION, "THANKS FOR YOUR RATE !");

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
