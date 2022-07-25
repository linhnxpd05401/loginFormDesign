/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.DAO;


import com.fpoly.models.Accounts;
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
public class AccountsDAO extends TheLEAEnglishCenterDAO<Accounts, String> {

    private String INSERT_SQL = "INSERT INTO Accounts(Email, Password, Role, VerifyCode, Status) VALUES (?,?,?,?,?)";
    private String DELETE_SQL = "DELETE FROM Accounts WHERE AccountID = ?";
    private String SELECT_ALL_SQL = "SELECT * FROM Accounts";
    private String SELECT_BY_ID_SQL = "SELECT * FROM LoginAccount WHERE AccountID = ?";
    private String SELECT_BY_EMAIL_SQL = "SELECT * FROM Accounts WHERE Email = ?";
    private String SELECT_BY_VETIFYCODE_SQL = "SELECT * FROM Accounts WHERE VerifyCode = ?";

    public Accounts selectByTK(String email) {
        List<Accounts> list = selectBySql(SELECT_BY_EMAIL_SQL, email);
        if(list.isEmpty()) {
            return  null;
        }
        return list.get(0);
    }
    
    // update new pass
    public void updateNewPass(String pass, int ID) {
        String sql = "UPDATE Accounts SET Password = ? WHERE AccountID = ?";
        XJdbc.update(sql, pass, ID);
    }

    //checkcode
    private boolean checkVetifyCode(String vetifyCode) {
        boolean isDuplicate = false;
        List<Accounts> list = this.selectBySql(SELECT_BY_VETIFYCODE_SQL, vetifyCode);
        if (list.isEmpty()) {
            isDuplicate = false;
        }else{
            isDuplicate = true;
        }
            return isDuplicate;
    }

    //create codde
    private String createVetifyCode() {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));
        while (checkVetifyCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    //check email
    public boolean checkEmail(String email) {
        boolean isExit = true;
        List<Accounts> list = selectBySql(SELECT_BY_EMAIL_SQL, email);
        if (list.isEmpty() == false) {
            isExit = false;
        }
        return isExit;
    }

    //update trạng thái
    public void updateVerifyCode(int ID) {
        String sql = "UPDATE Accounts SET VerifyCode = '', Status = '1' WHERE AccountID = ?";
        XJdbc.update(sql, ID);
    }
    
    //update code
    public void updateCodeWhenChangePass(int ID) {
        String verifyCode = createVetifyCode();
        String sql = "UPDATE Accounts SET VerifyCode = '"+verifyCode+"', Status = '1' WHERE AccountID = ?";
        XJdbc.update(sql, ID);
    }

//    //select id from 
    public boolean verufyCodeWithUser(int ID, String code) {
        boolean isVerify = false;
        String sql = "SELECT * FROM Accounts WHERE AccountID = ? AND VerifyCode = ?";
        List<Accounts> list = this.selectBySql(sql, ID, code);
        if(list.isEmpty()) {
            isVerify = false;
        }else{
            isVerify = true;
        }
        return isVerify;
    }
    //Lưu tt TK vào csdl
    @Override
    public void insert(Accounts entity){
        String verifyCode = createVetifyCode();
        XJdbc.update(INSERT_SQL, entity.getEmail(), entity.getPassword(), 0, verifyCode, 0);
    }

    @Override
    public void update(Accounts entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Accounts selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Accounts> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<Accounts> selectBySql(String sql, Object... args) {
        List<Accounts> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                Accounts entity = new Accounts();
                entity.setID(rs.getInt("AccountID"));
                entity.setEmail(rs.getString("Email"));
                entity.setPassword(rs.getString("Password"));
                entity.setRole(rs.getBoolean("Role"));
                entity.setVetifyCode(rs.getString("VerifyCode"));
                entity.setStatus(rs.getBoolean("Status"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
