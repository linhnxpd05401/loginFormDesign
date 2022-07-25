package com.fpoly.components;

import com.fpoly.DAO.TestingProgressDAO;
import com.fpoly.models.TestProcessing;
import com.fpoly.swing.button2;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;

public class TestInfo extends javax.swing.JPanel {

    /**
     * Creates new form TestInfo
     */
    public TestInfo() {
        initComponents();
    }

    public void checkLock(int coin, int coinPass, int userID, int TestID) {
        TestingProgressDAO tpDAO = new TestingProgressDAO();
        List<TestProcessing> list = tpDAO.checkUnlock(userID, TestID);
        if (coin < coinPass) {
            btnNext.setEnabled(false);
            btnNext.setText("LOCK");
            btnNext.setStyle(button2.ButtonStyle.ENABLE);
        } else {
            btnNext.setText("UNLOCK");
            btnNext.setEnabled(true);
        }
        for (TestProcessing tp : list) {

            btnNext.setText("START AGAIN");
            btnNext.setEnabled(true);

        }
    }

    public void addEvent(ActionListener event) {
        btnNext.addActionListener(event);
    }

    public void addData(String name, int time) {
        txtTestName.setText(name);
        txtTime.setText("Time: " + time);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTime = new javax.swing.JLabel();
        txtTestName = new javax.swing.JLabel();
        btnNext = new com.fpoly.swing.button2();

        setBackground(new java.awt.Color(255, 255, 255));

        txtTime.setFont(new java.awt.Font("Dialog", 1, 64)); // NOI18N
        txtTime.setForeground(new java.awt.Color(168, 42, 0));
        txtTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTime.setText("Time");

        txtTestName.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        txtTestName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTestName.setText("TestName");

        btnNext.setText("START");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTestName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(txtTestName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(txtTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.button2 btnNext;
    private javax.swing.JLabel txtTestName;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables

}
