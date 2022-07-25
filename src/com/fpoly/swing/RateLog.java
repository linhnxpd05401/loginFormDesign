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

//    public void addLikeEvent(ActionListener event) {
//        btnLike.addActionListener(event);
//    }
//
//    public void addDisLikeEvent(ActionListener event) {
//        btnDisLike.addActionListener(event);
//    }

    public void setData(Rate rate) {
        usDAO = new UserDAO();
        user = usDAO.selectByUserID(rate.getUserID());
        if (user.getImage() != null) {
             ImageIcon imgIcon = new ImageIcon(getClass().getResource("/com/fpoly/image/userImage/" + user.getImage().trim()));
            Avatar.setIcon(imgIcon);
        }else{
            Avatar.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/male_user_120px.png")));
        }
        
        lblDate.setText(XDate.toString(rate.getDate(), "dd/MM/yyyy"));
//        btnLike.setBadges(rate.getLike());
//        btnDisLike.setBadges(rate.getDisLike());
        lblComment.setText(rate.getComment());
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
        lblComment = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelRound1.setBackground(new java.awt.Color(218, 252, 218));
        panelRound1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

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
        lblDate.setForeground(new java.awt.Color(0, 102, 51));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("15/07/2022");

        lblComment.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        lblComment.setForeground(new java.awt.Color(204, 51, 0));
        lblComment.setText("Good app!");

        lblName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 153, 51));
        lblName.setText("Trần Hữu Quân");

        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Name: ");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lblStar1)
                        .addGap(10, 10, 10)
                        .addComponent(lblStar2)
                        .addGap(10, 10, 10)
                        .addComponent(lblStar3)
                        .addGap(10, 10, 10)
                        .addComponent(lblStar4)
                        .addGap(10, 10, 10)
                        .addComponent(lblStar5)
                        .addGap(21, 21, 21)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStar5)
                    .addComponent(lblStar4)
                    .addComponent(lblStar3)
                    .addComponent(lblStar2)
                    .addComponent(lblStar1)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblComment, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.ImageAvatar Avatar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblComment;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStar1;
    private javax.swing.JLabel lblStar2;
    private javax.swing.JLabel lblStar3;
    private javax.swing.JLabel lblStar4;
    private javax.swing.JLabel lblStar5;
    private com.fpoly.swing.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
