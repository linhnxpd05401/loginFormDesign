package com.fpoly.swing;

import com.fpoly.models.Rate;
import java.awt.event.ActionListener;
import com.fpoly.DAO.UserDAO;
import com.fpoly.models.User;
import com.fpoly.utils.XDate;
import com.fpoly.utils.XJdbc;
import javax.swing.ImageIcon;

public class RateLog extends javax.swing.JPanel {

    UserDAO usDAO;
    User user;

    public RateLog() {
        initComponents();
    }

    public void addLikeEvent(ActionListener event) {
        btnLike.addActionListener(event);
    }

    public void addDisLikeEvent(ActionListener event) {
        btnDisLike.addActionListener(event);
    }

    public void setData(Rate rate) {
        usDAO = new UserDAO();
        user = usDAO.selectByUserID(rate.getUserID());
        if (user.getImage() != null) {
             ImageIcon imgIcon = new ImageIcon(getClass().getResource("/com/fpoly/icons/" + user.getImage().trim()));
            Avatar.setIcon(imgIcon);
        }else{
            Avatar.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/male_user_120px.png")));
        }
        
        lblDate.setText(XDate.toString(rate.getDate(), "dd/MM/yyyy"));
        btnLike.setBadges(rate.getLike());
        btnDisLike.setBadges(rate.getDisLike());
        txtComment.setText(rate.getComment());
        lblName.setText(user.getUserName());
        int Star = rate.getStar();
        if (Star == 1) {
            lblStar1.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
        } else if (Star == 2) {
            lblStar1.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar2.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
        } else if (Star == 3) {
            lblStar1.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar2.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar3.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
        } else if (Star == 4) {
            lblStar1.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar2.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar3.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar4.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
        } else if (Star == 5) {
            lblStar1.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar2.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar3.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar4.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lblStar5.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new com.fpoly.swing.PanelRound();
        Avatar = new com.fpoly.swing.ImageAvatar();
        lblStar1 = new javax.swing.JLabel();
        lblStar2 = new javax.swing.JLabel();
        lblStar3 = new javax.swing.JLabel();
        lblStar4 = new javax.swing.JLabel();
        lblStar5 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtComment = new javax.swing.JTextField();
        btnLike = new com.fpoly.swing.ButtonBadges();
        jLabel7 = new javax.swing.JLabel();
        btnDisLike = new com.fpoly.swing.ButtonBadges();
        lblName = new javax.swing.JLabel();

        panelRound1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 51)));

        Avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/male_user_120px.png"))); // NOI18N

        lblStar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png"))); // NOI18N

        lblStar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png"))); // NOI18N

        lblStar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png"))); // NOI18N

        lblStar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png"))); // NOI18N

        lblStar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png"))); // NOI18N

        lblDate.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(0, 255, 0));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("15/07/2022");

        txtComment.setEditable(false);
        txtComment.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        txtComment.setForeground(new java.awt.Color(102, 102, 102));
        txtComment.setText("This App Is Good !!");
        txtComment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(51, 153, 255)));
        txtComment.setFocusable(false);
        txtComment.setOpaque(false);
        txtComment.setRequestFocusEnabled(false);

        btnLike.setForeground(new java.awt.Color(204, 204, 0));
        btnLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_facebook_like_20px.png"))); // NOI18N
        btnLike.setText("Like");
        btnLike.setBadges(99);
        btnLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLikeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Did you see this helpful ?");

        btnDisLike.setForeground(new java.awt.Color(255, 153, 153));
        btnDisLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_thumbs_down_20px.png"))); // NOI18N
        btnDisLike.setText("Dislike");
        btnDisLike.setBadges(1);
        btnDisLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisLikeActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 0, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Trần Hữu Quân");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(txtComment))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Avatar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblStar1)
                        .addGap(18, 18, 18)
                        .addComponent(lblStar2)
                        .addGap(18, 18, 18)
                        .addComponent(lblStar3)
                        .addGap(18, 18, 18)
                        .addComponent(lblStar4)
                        .addGap(18, 18, 18)
                        .addComponent(lblStar5)
                        .addGap(18, 18, 18)
                        .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLike, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDisLike, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStar5)
                            .addComponent(lblStar4)
                            .addComponent(lblStar3)
                            .addComponent(lblStar2)
                            .addComponent(lblStar1)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Avatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDisLike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLikeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLikeActionPerformed

    private void btnDisLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisLikeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDisLikeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.ImageAvatar Avatar;
    private com.fpoly.swing.ButtonBadges btnDisLike;
    private com.fpoly.swing.ButtonBadges btnLike;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStar1;
    private javax.swing.JLabel lblStar2;
    private javax.swing.JLabel lblStar3;
    private javax.swing.JLabel lblStar4;
    private javax.swing.JLabel lblStar5;
    private com.fpoly.swing.PanelRound panelRound1;
    private javax.swing.JTextField txtComment;
    // End of variables declaration//GEN-END:variables
}
