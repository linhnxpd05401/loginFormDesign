package com.fpoly.form;

import com.fpoly.DAO.AccountsDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.dialog.MessageDialog;
import com.fpoly.main.Main;
import com.fpoly.models.User;
import com.fpoly.utils.Auth;
import com.fpoly.utils.XDate;
import com.fpoly.utils.XImage;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class UserUpdateFrom extends javax.swing.JPanel {

    private User user;
    private JFileChooser fileChooser;
    private UserDAO userDao;
    private AccountsDAO accDao;

    public UserUpdateFrom() {
        initComponents();
        init();
    }

    private void init() {
        setOpaque(false);
        setFrom();
    }

    public User getForm() {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String phone = txtPhoneNumber.getText();
        Date date = XDate.toDate(txtBirthday.getText(), "dd-MM-yyyy");
        String addr = txtAddress.getText();
        String imageUrl = image.getToolTipText();
        boolean gender = false;
        if (rdoMale.isSelected()) {
            gender = true;
        } else if (rdoFemale.isSelected()) {
            gender = false;
        }
        return new User(Auth.acc.getID(), name, email, phone, addr, gender, date, imageUrl);
    }

    public void setFrom() {

        if (Auth.acc != null) {
            userDao = new UserDAO();
            User us = userDao.selectByAccountID(Auth.acc.getID());
            txtName.setText(us.getUserName());
            txtEmail.setText(us.getEmail());
            if (us.getPhone() != null) {
                txtPhoneNumber.setText(us.getPhone());
            }
            if (us.getBirthday() != null) {
                txtBirthday.setText(XDate.toString(us.getBirthday(), "dd-MM-yyyy"));
            }
            if (us.getAddres() != null) {
                txtAddress.setText(us.getAddres());
            }
            if (us.isGender() == true) {
                rdoMale.setSelected(true);
            } else if (us.isGender() == false) {
                rdoFemale.setSelected(true);
            }
            if (us.getImage() != null) {
                ImageIcon imgIcon = new ImageIcon(getClass().getResource("/com/fpoly/icons/" + us.getImage().trim()));
                image.setToolTipText(us.getImage());
                image.setIcon(imgIcon);

            } else {
                image.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/male_user_120px.png")));
            }
        } else {
            System.out.println("false");
        }
    }

    private void update() {
        userDao = new UserDAO();
        User us = this.getForm();

        MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
        mess.showMessage(MessageDialog.MessageType.INFORMATION, "Do you want update?");
        if (mess.isOk()) {
            userDao.update(us);
            this.repaint();
        }
    }

    private void ChooseImage() {
        fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(Main.getFrames()[0]) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            image.setToolTipText(file.getName());
            image.setIcon(icon);
            this.repaint();
        }
    }
    
    public void addCancelEvent(ActionListener event) {
        btnCancel.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        rdoMale = new com.fpoly.swing.RadioButtonCustom();
        rdoFemale = new com.fpoly.swing.RadioButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        image = new com.fpoly.swing.ImageAvatar();
        btnChooseImage = new com.fpoly.swing.ButtonBadges();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new com.fpoly.swing.ButtonOutLine();
        btnCancel = new com.fpoly.swing.ButtonOutLine();
        txtBirthday = new com.fpoly.swing.TextField2();
        txtName = new com.fpoly.swing.TextField2();
        txtAddress = new com.fpoly.swing.TextField2();
        txtPhoneNumber = new com.fpoly.swing.TextField2();
        txtEmail = new com.fpoly.swing.TextField2();

        setPreferredSize(new java.awt.Dimension(941, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(167, 165, 165));
        jLabel5.setText("Gender");

        buttonGroup1.add(rdoMale);
        rdoMale.setForeground(new java.awt.Color(140, 140, 140));
        rdoMale.setText("Male");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setForeground(new java.awt.Color(140, 140, 140));
        rdoFemale.setText("Female");

        jPanel2.setBackground(new java.awt.Color(240, 253, 240));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/male_user_120px.png"))); // NOI18N

        btnChooseImage.setBackground(new java.awt.Color(9, 145, 99));
        btnChooseImage.setForeground(new java.awt.Color(213, 238, 114));
        btnChooseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/camera_20px.png"))); // NOI18N
        btnChooseImage.setText("Update");
        btnChooseImage.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChooseImage, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(8, 123, 66));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(8, 123, 66));
        jLabel2.setText("LEA / UPDATE INFO");

        jPanel3.setBackground(new java.awt.Color(234, 251, 239));

        btnSave.setBackground(new java.awt.Color(10, 121, 84));
        btnSave.setForeground(new java.awt.Color(10, 121, 84));
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(29, 40));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(205, 41, 0));
        btnCancel.setForeground(new java.awt.Color(205, 41, 0));
        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(39, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtBirthday.setLabelText("Birthday");
        txtBirthday.setLineColor(new java.awt.Color(12, 157, 109));

        txtName.setLabelText("Name");
        txtName.setLineColor(new java.awt.Color(12, 157, 109));

        txtAddress.setLabelText("Address");
        txtAddress.setLineColor(new java.awt.Color(12, 157, 109));

        txtPhoneNumber.setLabelText("Phone");
        txtPhoneNumber.setLineColor(new java.awt.Color(12, 157, 109));

        txtEmail.setLabelText("Email");
        txtEmail.setLineColor(new java.awt.Color(12, 157, 109));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rdoMale, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                .addGap(57, 57, 57)
                                .addComponent(rdoFemale, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                .addGap(349, 349, 349))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(93, 93, 93)
                                        .addComponent(txtBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(20, 20, 20))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        this.update();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        this.ChooseImage();
    }//GEN-LAST:event_btnChooseImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.ButtonOutLine btnCancel;
    private com.fpoly.swing.ButtonBadges btnChooseImage;
    private com.fpoly.swing.ButtonOutLine btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.fpoly.swing.ImageAvatar image;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.fpoly.swing.RadioButtonCustom rdoFemale;
    private com.fpoly.swing.RadioButtonCustom rdoMale;
    private com.fpoly.swing.TextField2 txtAddress;
    private com.fpoly.swing.TextField2 txtBirthday;
    private com.fpoly.swing.TextField2 txtEmail;
    private com.fpoly.swing.TextField2 txtName;
    private com.fpoly.swing.TextField2 txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
