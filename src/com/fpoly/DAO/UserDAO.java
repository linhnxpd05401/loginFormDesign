/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.DAO;

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

    private String INSERT_SQL = "INSERT INTO UserProfile(AccountID, Name, Birthday, Gender, Email, PhoneNumber,Address, Image, Coin) VALUES (?,?,?,?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE UserProfile SET Name=?, Birthday=?, Gender = ?, Email = ?, PhoneNumber = ?, Address = ?, Image = ?, Coin = 0 WHERE AccountID = ?";
    private String DELETE_SQL = "DELETE FROM UserProfile WHERE AccountID = ?";
    private String SELECT_ALL_SQL = "SELECT * FROM UserProfile";
    private String SELECT_BY_ID_SQL = "SELECT * FROM UserProfile WHERE AccountID = ?";
    private String SELECT_BY_AccountID_SQL = "SELECT * FROM UserProfile WHERE AccountID = ?";
    private String SELECT_BY_USER_ID = "SELECT * FROM UserProfile WHERE UserID = ?";
    
    
    public User selectByAccountID(int id) {
        List<User> list = selectBySql(SELECT_BY_AccountID_SQL, id);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
     public User selectByUserID(int id){
        List<User> list = selectBySql(SELECT_BY_USER_ID, id);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
     
     public void updateCoin(User entity) {
         String sql = "UPDATE UserProfile SET Coin = ? WHERE UserID = ?";
         XJdbc.update(sql, entity.getCoin(), entity.getUserID());
     }
    
    
    @Override
    public void insert(User entity) {
        XJdbc.update(INSERT_SQL, entity.getAccountID(), entity.getUserName(), entity.getBirthday(), entity.isGender(), entity.getEmail(), entity.getPhone(), entity.getAddres(), entity.getImage(), 0);
    }

    @Override
    public void update(User entity) {
        XJdbc.update(UPDATE_SQL, entity.getUserName(), entity.getBirthday(), entity.isGender(), entity.getEmail(), entity.getPhone(), entity.getAddres(), entity.getImage(), entity.getAccountID());
    }

    @Override
    public void delete(String id) {
       XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public User selectById(String id) {
        List<User> list = selectBySql(SELECT_BY_AccountID_SQL, id);
        if(list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<User> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<User> selectBySql(String sql, Object... args) {
         List<User> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                User entity = new User();
                entity.setUserID(rs.getInt("UserID"));
                entity.setAccountID(rs.getInt("AccountID"));
                entity.setUserName(rs.getString("Name"));
                entity.setEmail(rs.getString("Email"));
                entity.setBirthday(rs.getDate("Birthday"));
                entity.setGender(rs.getBoolean("Gender"));
                entity.setEmail(rs.getString("Email"));
                entity.setPhone(rs.getString("PhoneNumber"));
                entity.setAddres(rs.getString("Address"));
                entity.setImage(rs.getString("Image"));
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
