/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpoly.form;

import com.fpoly.DAO.AnnouceDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.models.Announce;
import com.fpoly.utils.Auth;
import com.fpoly.utils.XValidate;
import java.util.Date;

/**
 *
 * @author bimzc
 */
public class AddNewAnnounce extends javax.swing.JPanel {

    /**
     * Creates new form AddNewAnnounce
     */
    public AddNewAnnounce() {
        initComponents();
    }
    
     boolean checkNull(){
         XValidate.checkNullText(txtAnnounceTitle);
         XValidate.checkNullText(txtcontent);
         return true;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtAnnounceTitle = new com.fpoly.swing.TextField2();
        txtcontent = new com.fpoly.swing.TextField2();
        button21 = new com.fpoly.swing.button2();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);

        txtAnnounceTitle.setLabelText("Announce Title");

        txtcontent.setLabelText("Announce Title");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcontent, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnnounceTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(txtAnnounceTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(txtcontent, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        button21.setText("Upload");
        button21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(button21, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button21ActionPerformed
       AnnouceDAO dao = new AnnouceDAO();
        UserDAO userDAO = new UserDAO();
       Date date = new Date();
        Announce ann = new Announce();
        ann.setTag(txtAnnounceTitle.getText());
        ann.setContent(txtcontent.getText());
        ann.setDateCreate(date);
        ann.setUserID(userDAO.selectByAccountID(Auth.acc.getID()).getUserID());
        if (checkNull()) {
            dao.insert(ann);
        }
    }//GEN-LAST:event_button21ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.button2 button21;
    private javax.swing.JPanel jPanel1;
    private com.fpoly.swing.TextField2 txtAnnounceTitle;
    private com.fpoly.swing.TextField2 txtcontent;
    // End of variables declaration//GEN-END:variables
}
