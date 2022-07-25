package com.fpoly.form;

import com.fpoly.DAO.AccountsDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.components.Message;
import com.fpoly.components.PanelLoading;
import com.fpoly.dialog.MessageDialog;
import com.fpoly.main.Main;
import com.fpoly.models.Accounts;
import com.fpoly.models.ModelMessage;
import com.fpoly.utils.Auth;
import com.fpoly.utils.XEmail;
import com.sun.corba.se.pept.protocol.MessageMediator;
import javax.swing.JOptionPane;

public class changePass extends javax.swing.JPanel {

    PanelLoading loading;

    UserDAO udao;

    public changePass() {
        initComponents();
        txtEmail.setText(Auth.acc.getEmail());
        btnAccept.setEnabled(false);
    }

//    private boolean checkOldPass() {
//        boolean Ok = false;
//        String PassType = txtOldPass.getText();
//
//        if (txtOldPass.equals("")) {
//            txtOldPass.setHelperText("Nhập mật khẩu cũ!");
//        } else if (txtNewPass.equals("")) {
//            txtNewPass.setHelperText("Nhập mật khẩu mới !");
//        } else if (txtRePass.equals("")) {
//            txtRePass.setHelperText("Nhập lại mật khẩu mới !");
//        } else {
//            System.out.println("Ok");
//            if (!PassType.equals(Auth.acc.getPassword())) {
//                txtOldPass.setHelperText("Current password incorrect");
//            }
//            if (!txtNewPass.getText().equals(txtRePass.getText())) {
//                txtRePass.setHelperText("Repass Incorrect");
//            }
//            if (PassType.equals(Auth.acc.getPassword()) && txtNewPass.getText().equals(txtRePass.getText())) {
//                if (PassType.equals(txtNewPass.getText())) {
//                    Ok = true;
//                }
//            }
//        }
//         return Ok;
//    }
    private void sendEmail(Accounts acc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ModelMessage ms = new XEmail().sendMain(acc.getEmail(), acc.getVetifyCode());
                if (ms.isSuccess()) {
                    MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
                    mess.showMessage(MessageDialog.MessageType.INFORMATION, "Check your email to get verifi code.");
                    btnGetCode.setEnabled(false);
                    btnAccept.setEnabled(true);
                } else {
                    MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
                    mess.showMessage(MessageDialog.MessageType.ERROR, "Error");
                }
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        txtNewPass = new com.fpoly.swing.TextField3();
        txtOldPass = new com.fpoly.swing.TextField3();
        txtReCode = new com.fpoly.swing.TextField3();
        txtVerifyCode = new com.fpoly.swing.MyTextField();
        btnGetCode = new com.fpoly.swing.button2();
        btnAccept = new com.fpoly.swing.ButtonOutLine();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 118, 43));
        jLabel1.setText("LEA / MY PROFILE / CHANGE PASSWORD");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Email: ");

        txtEmail.setText("txtEmail");

        txtNewPass.setLabelText("New Password");
        txtNewPass.setLineColor(new java.awt.Color(6, 147, 77));

        txtOldPass.setLabelText("Old Password");
        txtOldPass.setLineColor(new java.awt.Color(6, 147, 77));

        txtReCode.setLabelText("Retype Password");
        txtReCode.setLineColor(new java.awt.Color(6, 147, 77));

        btnGetCode.setText("Get Code");
        btnGetCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetCodeActionPerformed(evt);
            }
        });

        btnAccept.setBackground(new java.awt.Color(8, 127, 67));
        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtVerifyCode, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btnGetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtNewPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOldPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtReCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail))
                .addGap(18, 18, 18)
                .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtReCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVerifyCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(80, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetCodeActionPerformed
        AccountsDAO accDao = new AccountsDAO();
        Accounts acc = accDao.selectByTK(Auth.acc.getEmail());
        accDao.updateCodeWhenChangePass(acc.getID());
        Accounts newAcc = accDao.selectByTK(Auth.acc.getEmail());
        sendEmail(newAcc);
    }//GEN-LAST:event_btnGetCodeActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        AccountsDAO accDao = new AccountsDAO();
        Accounts acc = accDao.selectByTK(Auth.acc.getEmail());
        if (txtVerifyCode.getText().equals(acc.getVetifyCode())) {
            accDao.updateVerifyCode(acc.getID());
            if (txtOldPass.equals("")) {
                txtOldPass.setHelperText("Enter your current password please!");
            } else if (txtNewPass.equals("")) {
                txtNewPass.setHelperText("Enter new password please!");
            } else if (txtReCode.equals("")) {
                txtReCode.setHelperText("Enter new password again please!");
            } else {
                if (txtOldPass.getText().equals(acc.getPassword()) == false) {
                    txtOldPass.setHelperText("Old password incorrect!");
                } else if (txtOldPass.getText().equals(txtNewPass.getText())) {
                    txtNewPass.setHelperText("Old password and new password are same!");
                } else if (txtNewPass.getText().equals(txtReCode.getText()) == false) {
                    txtReCode.setHelperText("Retype is incorrect!");
                } else {
                    accDao.updateNewPass(txtNewPass.getText(), acc.getID());
                    MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
                    mess.showMessage(MessageDialog.MessageType.INFORMATION, "Update new password success");
                    return;
                }

            }
        }
    }//GEN-LAST:event_btnAcceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.ButtonOutLine btnAccept;
    private com.fpoly.swing.button2 btnGetCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtEmail;
    private com.fpoly.swing.TextField3 txtNewPass;
    private com.fpoly.swing.TextField3 txtOldPass;
    private com.fpoly.swing.TextField3 txtReCode;
    private com.fpoly.swing.MyTextField txtVerifyCode;
    // End of variables declaration//GEN-END:variables

}
