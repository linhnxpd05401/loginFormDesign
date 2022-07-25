package com.fpoly.DAO;

import com.fpoly.models.LearningProcess;
import com.fpoly.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LearningProcessDAO extends TheLEAEnglishCenterDAO<LearningProcess, String> {


    String SELECT_ALL = "SELECT * FROM LearningProcess";
    String SELECT_BY_ID = "SELECT * FROM LearningProcess WHERE UserID = ?";
    
    
    public List<LearningProcess> selectByUserID(int id) {
        List<LearningProcess> list = selectBySql(SELECT_BY_ID, id);
        return list;
    }
    
    public List<LearningProcess> checkPass(int subjectID, int UserID) {
        String sql = "SELECT * FROM LearningProcess WHERE SubjectID = ? AND UserID = ? AND Status = 1";
        List<LearningProcess> list = selectBySql(sql, subjectID, UserID);
        return list;
    }

    @Override
    public void insert(LearningProcess entity) {
        String sql = "INSERT INTO LearningProcess (UserID, SubjectID, Mark, LearningDay, Status) VALUES (?,?,?,?,?)";
        XJdbc.update(sql, entity.getUserID(), entity.getSubjectID(), entity.getMark(), entity.getLearningDate(), entity.isStatus());
    }

    @Override
    public void update(LearningProcess entity) {
       
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LearningProcess selectById(String id) {
        List<LearningProcess> list = selectBySql(SELECT_BY_ID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LearningProcess> selectAll() {
         return this.selectBySql(SELECT_ALL);
    }

    @Override
    protected List<LearningProcess> selectBySql(String sql, Object... args) {
        List<LearningProcess> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                LearningProcess entity = new LearningProcess();
                entity.setProcessID(rs.getInt("ProcessID"));
                entity.setUserID(rs.getInt("UserID"));
                entity.setSubjectID(rs.getInt("SubjectID"));
                entity.setMark(rs.getInt("Mark"));
                entity.setLearningDate(rs.getDate("LearningDay"));
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
