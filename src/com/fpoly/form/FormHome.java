
package com.fpoly.form;

import com.fpoly.DAO.AnnouceDAO;
import com.fpoly.DAO.LearningProcessDAO;
import com.fpoly.DAO.SubjectDAO;
import com.fpoly.DAO.TestDAO;
import com.fpoly.DAO.TestingProgressDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.components.Header;
import com.fpoly.dialog.MessageDialog;
import com.fpoly.main.Main;
import com.fpoly.models.Announce;
import com.fpoly.models.LearningProcess;
import com.fpoly.models.ModelCard;
import com.fpoly.models.ModelStudent;
import com.fpoly.models.Subject;
import com.fpoly.models.Test;
import com.fpoly.models.TestProcessing;
import com.fpoly.models.User;
import com.fpoly.swing.icon.GoogleMaterialDesignIcons;
import com.fpoly.swing.icon.IconFontSwing;
import com.fpoly.swing.noticeboard.ModelNoticeBoard;
import com.fpoly.swing.table.EventAction;
import com.fpoly.utils.Auth;
import com.fpoly.utils.XDate;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FormHome extends javax.swing.JPanel {
    
    private LearningProcess LearningProcess;

    public FormHome() throws ParseException {
        initComponents();
        table.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
        Date date = new Date();
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
        String now = sp.format(date);
        jLabel3.setText("Today : " + now + " - HAVE A GOOD DAY!!!");
        jLabel3.setForeground(new Color(32, 171, 43));
    }
    private void initData() throws ParseException {
        initCardData();
        initNoticeBoard();
        initTableData();
    }
    
    private void initTableData() {
        EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                showMessage(MessageDialog.MessageType.INFORMATION, "Delete: " + student.getName());
            }

            @Override
            public void update(ModelStudent student) {
                showMessage(MessageDialog.MessageType.ERROR, "Update: " + student.getName());
            }
        };
        TestingProgressDAO tsDAO = new TestingProgressDAO();
        UserDAO usDao = new UserDAO();
        List<TestProcessing> list = tsDAO.selectTop10();
        int i = 1;
        for (TestProcessing ts : list) {
            User us = usDao.selectByUserID(ts.getUserID());
            int m = i++;
            if (us.getImage() != null) {
                table.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/fpoly/icons/" + us.getImage())), us.getUserName(), String.valueOf(ts.getMark()), String.valueOf(ts.getMark()), m).toRowTable(eventAction));
            } else {
                table.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/fpoly/icons/male_user_40px.png")), us.getUserName(), String.valueOf(ts.getMark()), String.valueOf(ts.getMark()), m).toRowTable(eventAction));
            }
        }
        

    }

    private void initCardData() {
        LearningProcessDAO lrDAO = new LearningProcessDAO();
        SubjectDAO sbjDAo = new SubjectDAO();
        UserDAO usdDAO = new UserDAO();
        User us = usdDAO.selectByAccountID(Auth.acc.getID());
        List<Subject> listSbj = sbjDAo.selectAll();
        int PassingSubject = 0;
        for(Subject sbj : listSbj) {
            List<LearningProcess> listLP = lrDAO.checkPass(sbj.getSubjectID(), us.getUserID());
            if(listLP.size() > 0) {
                PassingSubject++;
            } 

        }

        double percentPassingSubject = 0;
        if(PassingSubject > 0) {
            percentPassingSubject = (1.0*PassingSubject/listSbj.size())*100;
        }
        
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BORDER_COLOR, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card1.setData(new ModelCard("Learning Process", listSbj.size(), (int)percentPassingSubject, icon));
        
        TestDAO testDAO = new TestDAO();
        List<Test> listTest = testDAO.selectAll();
        TestingProgressDAO tpDao = new TestingProgressDAO();
        int PassingTest = 0;
        for(Test test : listTest) {
            List<TestProcessing> listTP = tpDao.checkPass(us.getUserID(), test.getTestID());
            if(listTP.size() > 0) {
                PassingTest++;
            }
        }
        
        double percentPassingTest = 0;
        if(PassingSubject > 0) {
            percentPassingTest = (1.0*PassingTest/listTest.size())*100;
        }
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EQUALIZER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card3.setData(new ModelCard("Testing Process", listTest.size(), (int)percentPassingTest, icon1));
        
    }

    private void initNoticeBoard() throws ParseException {
        Date date = new Date();
        String timeUpload;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        AnnouceDAO acdDAO = new AnnouceDAO();
        List<Announce> list = acdDAO.selectAll();
        int i =0;
        for (Announce ac : list) {
            i++;
            Date str = formatter.parse(XDate.toString(ac.getDateCreate(), "dd/MM/yyyy"));

            if (TimeUnit.MILLISECONDS.toDays(date.getTime() - str.getTime()) > 0) {
                timeUpload = String.valueOf(TimeUnit.MILLISECONDS.toDays(date.getTime() - str.getTime())) + "days ago";
            } else {
                timeUpload = "Today";
            }
            //noticeBoard.addDate("Uploaded by LEA Academy");
            UserDAO udao = new UserDAO();
            AnnouceDAO adao = new AnnouceDAO();
            if (i==0) {
                 noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), ac.getTag()+" (Author : "+udao.selectByUserID(ac.getUserID()).getUserName()+")", timeUpload, ac.getContent()));
            }
            if (i==1) {
                 noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), ac.getTag()+" (Author : "+udao.selectByUserID(ac.getUserID()).getUserName()+")", timeUpload, ac.getContent()));
            }
            if (i==2) {
                 noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), ac.getTag()+" (Author : "+udao.selectByUserID(ac.getUserID()).getUserName()+")", timeUpload, ac.getContent()));
            }
            if (i==3) {
                 noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), ac.getTag()+" (Author : "+udao.selectByUserID(ac.getUserID()).getUserName()+")", timeUpload, ac.getContent()));
            }
            if (i==4) {
                 noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(27, 188, 204), ac.getTag()+" (Author : "+udao.selectByUserID(ac.getUserID()).getUserName()+")", timeUpload, ac.getContent()));
            }
            if (i==5) {
                 noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(238, 46, 57), ac.getTag()+" (Author : "+udao.selectByUserID(ac.getUserID()).getUserName()+")", timeUpload, ac.getContent()));
            }
            if (i==6) {
                  i = 0;
            }
        }
           noticeBoard.scrollToTop();
    }

    private void showMessage(MessageDialog.MessageType messageType, String message) {
        MessageDialog obj = new MessageDialog(Main.getFrames()[0], true);
        obj.showMessage(messageType, message);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        card1 = new com.fpoly.components.Card();
        card3 = new com.fpoly.components.Card();
        jPanel2 = new javax.swing.JPanel();
        noticeBoard = new com.fpoly.swing.noticeboard.NoticeBoard();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.fpoly.swing.table.Table();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("LEA / HOME");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        card1.setBackground(new java.awt.Color(252, 92, 125));
        card1.setColorGradient(new java.awt.Color(106, 130, 251));
        jPanel1.add(card1);

        card3.setBackground(new java.awt.Color(252, 74, 26));
        card3.setColorGradient(new java.awt.Color(247, 183, 51));
        jPanel1.add(card3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Notice Board");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Simple Miglayout API Doc");

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(1, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(noticeBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 405, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 257, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticeBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Ranking");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Mark", "Coin", "Raking"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(200);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1289, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.components.Card card1;
    private com.fpoly.components.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.fpoly.swing.noticeboard.NoticeBoard noticeBoard;
    private com.fpoly.swing.table.Table table;
    // End of variables declaration//GEN-END:variables
}
