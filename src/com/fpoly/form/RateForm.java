/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpoly.form;

import com.fpoly.DAO.RateDAO;
import com.fpoly.models.Rate;
import com.fpoly.swing.RateLog;
import com.fpoly.swing.scrollbar.ScrollBarCustom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bimzc
 */
public class RateForm extends javax.swing.JPanel {

    /**
     * Creates new form RateForm
     */
    public RateForm() {
        initComponents();
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.setBorder(null);
        sp.getInsets().set(0, 0, 0, 0);
        sp.setViewportBorder(null);
        sp.getViewport().setBorder(null);
        sp.getViewport().getInsets().set(0, 0, 0, 0);
        Init();
    }

    public void Init() {
        RateDAO rtDAO = new RateDAO();
        List<Rate> list = rtDAO.selectAll();
        for (Rate rate : list) {
            RateLog rlog = new RateLog();
            CardContainer.add(rlog);
            rlog.setData(rate);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelOverall = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblOveralStar = new javax.swing.JLabel();
        lbl1StarOverall = new javax.swing.JLabel();
        lbl2StarOverall = new javax.swing.JLabel();
        lbl3StarOverall = new javax.swing.JLabel();
        lbl4StarOverall = new javax.swing.JLabel();
        lbl5StarOverall = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        prg5Star = new progressbar.ProgressBarCustom();
        prg4Star = new progressbar.ProgressBarCustom();
        prg3Star = new progressbar.ProgressBarCustom();
        prg2Star = new progressbar.ProgressBarCustom();
        prg1Star = new progressbar.ProgressBarCustom();
        panelRate = new javax.swing.JPanel();
        btn2Star = new javax.swing.JButton();
        btn1Star = new javax.swing.JButton();
        btn5Star = new javax.swing.JButton();
        btn3Star = new javax.swing.JButton();
        btn4Star = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtComment = new com.fpoly.swing.MyTextField();
        btnRate = new com.fpoly.swing.Button();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        CardContainer = new javax.swing.JPanel();

        jLabel1.setText("RATING OVẺVIEW");

        lblOveralStar.setFont(new java.awt.Font("Serif", 1, 99)); // NOI18N
        lblOveralStar.setForeground(new java.awt.Color(0, 255, 51));
        lblOveralStar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOveralStar.setText("4");

        lbl1StarOverall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png"))); // NOI18N

        lbl2StarOverall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png"))); // NOI18N

        lbl3StarOverall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png"))); // NOI18N

        lbl4StarOverall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png"))); // NOI18N

        lbl5StarOverall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png"))); // NOI18N

        jLabel7.setText("5");

        jLabel9.setText("4");

        jLabel10.setText("3");

        jLabel11.setText("2");

        jLabel12.setText("1");

        prg5Star.setForeground(new java.awt.Color(0, 204, 51));
        prg5Star.setValue(38);
        prg5Star.setString("25");

        prg4Star.setForeground(new java.awt.Color(0, 204, 51));
        prg4Star.setValue(38);
        prg4Star.setString("25");

        prg3Star.setForeground(new java.awt.Color(0, 204, 51));
        prg3Star.setValue(38);
        prg3Star.setString("25");

        prg2Star.setForeground(new java.awt.Color(0, 204, 51));
        prg2Star.setValue(38);
        prg2Star.setString("25");

        prg1Star.setForeground(new java.awt.Color(0, 204, 51));
        prg1Star.setValue(38);
        prg1Star.setString("25");

        btn2Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn2Star.setBorderPainted(false);
        btn2Star.setContentAreaFilled(false);

        btn1Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn1Star.setBorderPainted(false);
        btn1Star.setContentAreaFilled(false);

        btn5Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn5Star.setBorderPainted(false);
        btn5Star.setContentAreaFilled(false);

        btn3Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn3Star.setBorderPainted(false);
        btn3Star.setContentAreaFilled(false);

        btn4Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn4Star.setBorderPainted(false);
        btn4Star.setContentAreaFilled(false);

        jLabel13.setText("PLEASE RATE FOR US TO HAVE MORE MOTIVATION :");

        jLabel14.setText("LEAVE YOUR OPTIONS AND COMMENT HERE :");

        btnRate.setBackground(new java.awt.Color(204, 255, 204));
        btnRate.setForeground(new java.awt.Color(51, 153, 0));
        btnRate.setText("RATE");

        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Thanks for always using our app ! More help please contact :");

        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("HotLine : 0333333333");

        jLabel17.setForeground(new java.awt.Color(51, 51, 255));
        jLabel17.setText("Gmail : quanthpd05478@fpt.edu.vn");

        javax.swing.GroupLayout panelRateLayout = new javax.swing.GroupLayout(panelRate);
        panelRate.setLayout(panelRateLayout);
        panelRateLayout.setHorizontalGroup(
            panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRateLayout.createSequentialGroup()
                .addGroup(panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRateLayout.createSequentialGroup()
                        .addGroup(panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRateLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btn1Star, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn2Star, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn3Star, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn4Star, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn5Star, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13))
                            .addGroup(panelRateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14))
                            .addGroup(panelRateLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(btnRate, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRateLayout.createSequentialGroup()
                                .addGroup(panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelRateLayout.setVerticalGroup(
            panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRateLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn5Star, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2Star, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1Star, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3Star, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4Star, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(btnRate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelOverallLayout = new javax.swing.GroupLayout(panelOverall);
        panelOverall.setLayout(panelOverallLayout);
        panelOverallLayout.setHorizontalGroup(
            panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOverallLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOverallLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelOverallLayout.createSequentialGroup()
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelOverallLayout.createSequentialGroup()
                                .addComponent(lbl1StarOverall)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl2StarOverall)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl3StarOverall)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl4StarOverall)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl5StarOverall))
                            .addComponent(lblOveralStar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prg1Star, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(prg2Star, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                .addComponent(prg3Star, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prg4Star, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prg5Star, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(panelRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelOverallLayout.setVerticalGroup(
            panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOverallLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOveralStar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelOverallLayout.createSequentialGroup()
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(prg5Star, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(prg4Star, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(prg3Star, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(prg2Star, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1StarOverall)
                    .addComponent(lbl2StarOverall)
                    .addComponent(lbl3StarOverall)
                    .addComponent(lbl4StarOverall)
                    .addComponent(lbl5StarOverall)
                    .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(prg1Star, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelOverall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        CardContainer.setBackground(new java.awt.Color(255, 255, 255));
        CardContainer.setLayout(new java.awt.GridLayout(9999, 1, 5, 5));
        sp.setViewportView(CardContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, Short.MAX_VALUE)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardContainer;
    private javax.swing.JButton btn1Star;
    private javax.swing.JButton btn2Star;
    private javax.swing.JButton btn3Star;
    private javax.swing.JButton btn4Star;
    private javax.swing.JButton btn5Star;
    private com.fpoly.swing.Button btnRate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl1StarOverall;
    private javax.swing.JLabel lbl2StarOverall;
    private javax.swing.JLabel lbl3StarOverall;
    private javax.swing.JLabel lbl4StarOverall;
    private javax.swing.JLabel lbl5StarOverall;
    private javax.swing.JLabel lblOveralStar;
    private javax.swing.JPanel panelOverall;
    private javax.swing.JPanel panelRate;
    private progressbar.ProgressBarCustom prg1Star;
    private progressbar.ProgressBarCustom prg2Star;
    private progressbar.ProgressBarCustom prg3Star;
    private progressbar.ProgressBarCustom prg4Star;
    private progressbar.ProgressBarCustom prg5Star;
    private javax.swing.JScrollPane sp;
    private com.fpoly.swing.MyTextField txtComment;
    // End of variables declaration//GEN-END:variables
}
