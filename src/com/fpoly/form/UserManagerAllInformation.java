/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpoly.form;

import com.fpoly.DAO.StatisticalDAO;
import com.fpoly.swing.scrollbar.ScrollBarCustom;
import java.util.List;

/**
 *
 * @author bimzc
 */
public class UserManagerAllInformation extends javax.swing.JPanel {

    /**
     * Creates new form UserManagerAllInformation
     */
    public UserManagerAllInformation() {
        initComponents();
        initDataToTable();
            sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.setBorder(null);
        sp.getInsets().set(0, 0, 0, 0);
        sp.setViewportBorder(null);
        sp.getViewport().setBorder(null);
        sp.getViewport().getInsets().set(0, 0, 0, 0);
    }

     private void initDataToTable() {
        
        StatisticalDAO stDAO = new StatisticalDAO();
        List<Object[]> list = stDAO.getStatisticalManagrUsrOvrall();
        for(Object[] row : list) {
            table1.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        table1 = new com.fpoly.swing.table.Table();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setOpaque(false);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USER NAME", "USER ID", "COIN", "TEST DONE", "SUM TEST'S MARK", "SUBJECT LEARNED", "SUBJECT'S MARK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sp.setViewportView(table1);

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("OVRALL STUDENT'S RESULT AND PROGRESS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane sp;
    private com.fpoly.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
