/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.DAO;

import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bimzc
 */
public class StatisticalDAO {

    String Call_Proc_Statistical_Mark_Coin = "{call SP_OVERALL_COIN_AND_MARK}";
    
    String Call_Proc_User_Number_By_Month = "{call sp_ThongKeNguoiHoc}";
    

    public List<Object[]> getStatisticalMarkAndCoin() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(Call_Proc_Statistical_Mark_Coin);
            while (rs.next()) {
                Object[] model = {
                    rs.getString("Name"),
                    rs.getInt("Coin"),
                    rs.getInt("UserID"),
                    rs.getInt("Sum_Mark")
                };
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Object[]> getStatisticalUserNumberByMonth() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(Call_Proc_User_Number_By_Month);
            while (rs.next()) {
                Object[] model = {
                    rs.getString("Month"),
                    rs.getInt("User_Number")
                };
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
