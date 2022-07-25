/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.DAO;

import com.fpoly.models.LoginAccounts;
import com.fpoly.models.User;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nxlin
 */
public class UserDAO extends TheLEAEnglishCenterDAO<User, String>{

    private String INSERT_SQL = "INSERT INTO NguoiDung(MaTK, TenND, Email, SDT, DiaChi, GioiTinh, NgaySinh, Hinh, Rank, Coin) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE NguoiDung SET MaTK=?, TenND=?, Email = ?, SDT = ?, DiaChi = ?, GioiTinh = ?, NgaySinh = ?, Hinh = ?, Rank = ?, Coin = ? WHERE MaND = ?";
    private String DELETE_SQL = "DELETE FROM NguoiDung WHERE MaND = ?";
    private String SELECT_ALL_SQL = "SELECT * FROM NguoiDung";
    private String SELECT_BY_ID_SQL = "SELECT * FROM NguoiDung WHERE MaND = ?";
    private String SELECT_BY_AccountID_SQL = "SELECT * FROM NguoiDung WHERE MaTK";
    
    @Override
    public void insert(User entity) {
        XJdbc.update(INSERT_SQL, entity.getAccountID(), entity.getUserName(), entity.getEmail(), entity.getPhone(), entity.getAddres(), entity.isGender(), entity.getBirthday(), entity.getImage(), entity.getRank(), entity.getCoin());
    }

    @Override
    public void update(User entity) {
        XJdbc.update(UPDATE_SQL, entity.getAccountID(), entity.getUserName(), entity.getEmail(), entity.getPhone(), entity.getAddres(), entity.isGender(), entity.getBirthday(), entity.getImage(), entity.getRank(), entity.getCoin());
    }

    @Override
    public void delete(String id) {
       XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public User selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<User> selectBySql(String sql, Object... args) {
         List<User> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                User entity = new User();
                entity.setUserID(rs.getInt("MaND"));
                entity.setAccountID(rs.getInt("MaTK"));
                entity.setUserName(rs.getString("TenND"));
                entity.setEmail(rs.getString("Email"));
                entity.setPhone(rs.getString("SDT"));
                entity.setAddres(rs.getString("DiaChi"));
                entity.setGender(rs.getBoolean("GioiTinh"));
                entity.setBirthday(rs.getDate("NgaySinh"));
                entity.setImage(rs.getString("Hinh"));
                entity.setRank(rs.getInt("Rank"));
                entity.setCoin(rs.getInt("Coin"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
