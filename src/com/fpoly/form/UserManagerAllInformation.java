/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpoly.form;

import com.fpoly.DAO.StatisticalDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;

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
      //  designTable();
    }
    
    private void tableHeadColor(JTable table_name) {
        DefaultTableCellRenderer head_render = new DefaultTableCellRenderer();

        head_render.setBackground(new Color(204, 153, 255));
        table_name.getTableHeader().setDefaultRenderer(head_render);

        //to call above method
        //table_head_color("write table name");
    }

    private void scrollBarColor(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GRAY;
            }
        });
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(Integer.MAX_VALUE, 2));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(WIDTH, Integer.MAX_VALUE));
    }
    
    void designTable() {
//        jTable2.getTableHeader().setOpaque(true);
//        jTable2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//        table_head_color(jTable2);
//        table_head_color(jTable3);
//        scroll_bar_color(jScrollPane1);
//        scroll_bar_color(jScrollPane3);
//        jTable2.getTableHeader().setForeground(new Color(255, 255, 255));
//        jTable2.setRowHeight(25);
          table1.getTableHeader().setOpaque(true);
          table1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
          tableHeadColor(table1);
          scrollBarColor(tblAll);
          table1.getTableHeader().setForeground(new Color(255,255,255));
          table1.setRowHeight(25);
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

        tblAll = new javax.swing.JScrollPane();
        table1 = new com.fpoly.swing.table.Table();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblAll.setBackground(new java.awt.Color(255, 255, 255));
        tblAll.setOpaque(false);

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
        tblAll.setViewportView(table1);

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("OVRALL STUDENT'S RESULT AND PROGRESS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblAll, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tblAll, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private com.fpoly.swing.table.Table table1;
    private javax.swing.JScrollPane tblAll;
    // End of variables declaration//GEN-END:variables
}
