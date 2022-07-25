
package com.fpoly.components;

import com.fpoly.utils.XImage;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author nxlin
 */
public class Congralulate extends javax.swing.JPanel {


    public Congralulate() {
        initComponents();
    }
    
    public void updateLabel(int point, int passingPoint) {
        lblPoint.setText(String.valueOf(point));
        if(point >= passingPoint) {
            lblStatus.setText("PASS");
        }else{
            lblStatus.setText("NOT PASS");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblPoint = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 91, 45));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOTAL:");

        lblPoint.setFont(new java.awt.Font("Dialog", 1, 72)); // NOI18N
        lblPoint.setForeground(new java.awt.Color(17, 105, 46));
        lblPoint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoint.setText("34");

        lblStatus.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(183, 48, 3));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("PASS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblPoint)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblPoint))
                .addGap(42, 42, 42)
                .addComponent(lblStatus)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPoint;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
