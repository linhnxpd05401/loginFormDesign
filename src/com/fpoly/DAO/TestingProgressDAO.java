
package com.fpoly.DAO;

import com.fpoly.models.Top10;
import java.util.List;
import com.fpoly.models.TestProcessing;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TestingProgressDAO extends TheLEAEnglishCenterDAO<TestProcessing, String> {

    String SELECT_TOP_10 = "SELECT TOP 10 A.UserID, B.Name, B.Image, SUM(A.Mark) AS 'TotalMark', B.Coin FROM TestingProcess A\n"
            + "INNER JOIN UserProfile B ON A.UserID = B.UserID\n"
            + "GROUP BY A.UserID, B.Name, B.Image, B.Coin\n"
            + "ORDER BY SUM(Mark) desc, B.Coin desc";
    String SELECT_ALL = "SELECT * FROM TestingProcess";

    String SELECT_BY_USER_ID = "SELECT * FROM TestingProcess WHERE UserID = ?";

    public List<Top10> selectTop10() {
        List<Top10> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(SELECT_TOP_10);
            while (rs.next()) {
                Top10 t10 = new Top10();
                t10.setUserID(rs.getInt("UserID"));
                t10.setUserName(rs.getString("Name"));
                t10.setImage(rs.getString("Image"));
                t10.setTotalMark(rs.getInt("TotalMark"));
                t10.setCoin(rs.getInt("Coin"));
                list.add(t10);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int selectNumberOfTrainessdoingTest(Object... args) {
        String sql = "SELECT COUNT(UserID) AS 'User' FROM TestingProcess WHERE TestID = ?";
        int user = 0;
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {

                user = rs.getInt("User");

            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }

    public int selectNumberOfTrainessPassingTest(Object... args) {
        String sql = "SELECT COUNT(UserID) AS 'User' FROM TestingProcess WHERE TestID = ? AND Status = 1";
        int user = 0;
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {

                user = rs.getInt("User");

            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }

    public int selectNumberOfTrainessNoPassingTest(Object... args) {
        String sql = "SELECT COUNT(UserID) AS 'User' FROM TestingProcess WHERE TestID = ? AND Status = 0";
        int user = 0;
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {

                user = rs.getInt("User");

            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }

    public List<TestProcessing> SelectByUserID(int ID) {
        List<TestProcessing> list = this.selectBySql(SELECT_BY_USER_ID, ID);
        return list;
    }

    public List<TestProcessing> checkUnlock(int userID, int testID) {
        String sql = "SELECT * FROM TestingProcess WHERE UserID = ? AND TestID = ?";
        return selectBySql(sql, userID, testID);
    }

    public List<TestProcessing> checkPass(int userID, int testID) {
        String sql = "SELECT * FROM TestingProcess WHERE UserID = ? AND TestID = ? AND Status = 1";
        return selectBySql(sql, userID, testID);
    }

    public void updateMark(TestProcessing entity) {
        String sql = "UPDATE TestingProcess SET Mark = ?, TestingDate = ? WHERE UserID = ?";
        XJdbc.update(sql, entity.getMark(), entity.getTestingDay(), entity.getUserID());
    }

    public void updateTestPass(TestProcessing entity) {
        String sql = "UPDATE TestingProcess SET Mark = ?,TestingDate = ?, Status = 1 WHERE UserID = ?";
        XJdbc.update(sql, entity.getMark(), entity.getTestingDay(), entity.getUserID());
    }

    @Override
    public void insert(TestProcessing entity) {
        String sql = "INSERT INTO TestingProcess(UserID, TestID, Mark, TestingDate, Status) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, entity.getUserID(), entity.getTestID(), entity.getMark(), entity.getTestingDay(), entity.isStatus());
    }

    @Override
    public void update(TestProcessing entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TestProcessing selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TestProcessing> selectAll() {
        return this.selectBySql(SELECT_ALL);
    }

    @Override
    protected List<TestProcessing> selectBySql(String sql, Object... args) {
        List<TestProcessing> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                TestProcessing ts = new TestProcessing();
                ts.setUserID(rs.getInt("UserID"));
                ts.setTestID(rs.getInt("TestID"));
                ts.setMark(rs.getInt("Mark"));
                ts.setTestingDay(rs.getDate("TestingDate"));
                ts.setStatus(rs.getBoolean("Status"));
                list.add(ts);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
