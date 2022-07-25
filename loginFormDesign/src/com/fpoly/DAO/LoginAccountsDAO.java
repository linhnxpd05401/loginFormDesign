/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.DAO;

import com.fpoly.models.LoginAccounts;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nxlin
 */
public class LoginAccountsDAO extends TheLEAEnglishCenterDAO<LoginAccounts, String> {

    private String INSERT_SQL = "INSERT INTO LoginAccounts(HoTen, Email, MatKhau, VaiTro, VetifyCode, TrangThai) VALUES (?,?,?,?,?,?)";
    private String UPDATE_SQL = "UPDATE LoginAccounts SET HoTen=?, TaiKhoan=?, MatKhau = ? WHERE MaTK = ?";
    private String DELETE_SQL = "DELETE FROM LoginAccounts WHERE MaTK = ?";
    private String SELECT_ALL_SQL = "SELECT * FROM LoginAccounts";
    private String SELECT_BY_ID_SQL = "SELECT * FROM LoginAccount WHERE MaTK = ?";
    private String SELECT_BY_EMAIL_SQL = "SELECT * FROM LoginAccounts WHERE Email = ?";
    private String SELECT_BY_VETIFYCODE_SQL = "SELECT * FROM LoginAccounts WHERE VetifyCode = ?";

    public LoginAccounts selectByTK(String email) {
        List<LoginAccounts> list = selectBySql(SELECT_BY_EMAIL_SQL, email);
        if(list.isEmpty()) {
            return  null;
        }
        return list.get(0);
    }

    //checkcode
    private boolean checkVetifyCode(int vetifyCode) {
        boolean isDuplicate = false;
        List<LoginAccounts> list = this.selectBySql(SELECT_BY_VETIFYCODE_SQL, vetifyCode);
        if (list.isEmpty()) {
            isDuplicate = false;
        }else{
            isDuplicate = true;
        }
            return isDuplicate;
    }

    //create codde
    private int createVetifyCode() {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        int code = Integer.parseInt(df.format(ran.nextInt(1000000)));
        while (checkVetifyCode(code)) {
            code = Integer.parseInt(df.format(ran.nextInt(1000000)));
        }
        return code;
    }

    //check email
    public boolean checkEmail(String email) {
        boolean isExit = true;
        List<LoginAccounts> list = selectBySql(SELECT_BY_EMAIL_SQL, email);
        if (list.isEmpty() == false) {
            isExit = false;
        }
        return isExit;
    }

    //update trạng thái
    public void updateVerifyCode(int ID) {
        String sql = "UPDATE LoginAccounts SET VetifyCode = '', TrangThai = '1' WHERE MaTK = ?";
        XJdbc.update(sql, ID);
    }

//    //select id from 
    public boolean verufyCodeWithUser(int ID, int code) {
        boolean isVerify = false;
        String sql = "SELECT * FROM LoginAccounts WHERE MaTK = ? AND VetifyCode = ?";
        List<LoginAccounts> list = this.selectBySql(sql, ID, code);
        if(list.isEmpty()) {
            isVerify = false;
        }else{
            isVerify = true;
        }
        return isVerify;
    }
    //Lưu tt TK vào csdl
    @Override
    public void insert(LoginAccounts entity){
        int verifyCode = createVetifyCode();
        XJdbc.update(INSERT_SQL, entity.getUsername(), entity.getEmail(), entity.getPassword(), 0, verifyCode, 0);
    }

    @Override
    public void update(LoginAccounts entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginAccounts selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LoginAccounts> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<LoginAccounts> selectBySql(String sql, Object... args) {
        List<LoginAccounts> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                LoginAccounts entity = new LoginAccounts();
                entity.setID(rs.getInt("MaTK"));
                entity.setUsername(rs.getString("HoTen"));
                entity.setEmail(rs.getString("Email"));
                entity.setPassword(rs.getString("MatKhau"));
                entity.setRole(rs.getBoolean("VaiTro"));
                entity.setVetifyCode(rs.getInt("VetifyCode"));
                entity.setStatus(rs.getBoolean("TrangThai"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
