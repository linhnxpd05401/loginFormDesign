
package com.fpoly.form;

import com.fpoly.DAO.StatisticalDAO;
import com.fpoly.DAO.TestDAO;
import com.fpoly.DAO.TestingProgressDAO;
import com.fpoly.chart.ModelChart;
import com.fpoly.models.Test;
import java.awt.Color;
import java.util.List;


public class StatiscalTestForm extends javax.swing.JPanel {
    
    private TestingProgressDAO tpDAO;
    private TestDAO testDAO;
    public StatiscalTestForm() {
        initComponents();
        initDataToChart();
        initDataToTable();
    }
    
    private void initDataToChart() {
        tpDAO = new TestingProgressDAO();
        testDAO = new TestDAO();
        chart.addLegend("Total", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Pass", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("NotPass", new Color(186, 37, 37), new Color(241, 100, 120));
        List<Test> listTest = testDAO.selectAll();
        for(int i = 0; i < listTest.size(); i++) {
            int total = tpDAO.selectNumberOfTrainessdoingTest(listTest.get(i).getTestID());
            int pass = tpDAO.selectNumberOfTrainessPassingTest(listTest.get(i).getTestID());
            int notPass = tpDAO.selectNumberOfTrainessNoPassingTest(listTest.get(i).getTestID());
            chart.addData(new ModelChart(listTest.get(i).getTestName(), new double[]{total, pass, notPass}));
        }
        chart.start();
    }
    
    private void initDataToTable() {
        
        StatisticalDAO stDAO = new StatisticalDAO();
        List<Object[]> list = stDAO.getStatisticalTest();
        for(Object[] row : list) {
            table1.addRow(row);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.fpoly.swing.RoundPanel();
        chart = new com.fpoly.chart.Chart();
        jLabel1 = new javax.swing.JLabel();
        roundPanel2 = new com.fpoly.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.fpoly.swing.table.Table();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(218, 215, 215));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setLayout(new java.awt.BorderLayout());
        roundPanel1.add(chart, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 92, 8));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Number of users doing the test");
        roundPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TEST NAME", "TEST ID", "TIMES", "HIGH MARK", "LOW MARK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(2).setResizable(false);
            table1.getColumnModel().getColumn(3).setResizable(false);
            table1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(9, 91, 9));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Statistics of test results of each test");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.chart.Chart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.fpoly.swing.RoundPanel roundPanel1;
    private com.fpoly.swing.RoundPanel roundPanel2;
    private com.fpoly.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
