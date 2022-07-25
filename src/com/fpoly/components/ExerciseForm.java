package com.fpoly.components;

import com.fpoly.DAO.QuestionExerciseDAO;
import com.fpoly.models.QuestionExercise;
import com.fpoly.models.Subject;
import com.fpoly.swing.button2;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

public class ExerciseForm extends javax.swing.JPanel {

    private QuestionExerciseDAO qeDAO;
    private QuestionExercise qe;

    public ExerciseForm() {
        initComponents();
    }

    public void initQuestionData(int sbjID, int i) {
        qeDAO = new QuestionExerciseDAO();
        List<QuestionExercise> ques = qeDAO.selectBySubjectID(sbjID);
        txtContent.setText(ques.get(0).getContent());

        if (i < ques.size()) {
            lblSequence.setText((i + 1) + "/" + ques.size());
            txtContent.setText((i + 1) + ". " + ques.get(i).getContent());
            txtRequest.setText(ques.get(i).getRequest());
            btn1.setText(ques.get(i).getAsw1());
            btn2.setText(ques.get(i).getAsw2());
            btn3.setText(ques.get(i).getAsw3());
            btn4.setText(ques.get(i).getAsw4());
        }
        repaint();
        revalidate();
    }

    public void addEvent1(ActionListener event) {
        btn1.addActionListener(event);
        
    }

    public void addEvent2(ActionListener event) {
        btn2.addActionListener(event);
    }

    public void addEvent3(ActionListener event) {
        btn3.addActionListener(event);
    }

    public void addEvent4(ActionListener event) {
        btn4.addActionListener(event);
    }    

    public void setEnableAll(boolean enable) {
        btn1.setEnabled(enable);
        btn2.setEnabled(enable);
        btn3.setEnabled(enable);
        btn4.setEnabled(enable);
    }
    
    public void colorChange(String actionCommand) {
        if(actionCommand.equals(btn1.getText())) {
            btn1.setStyle(button2.ButtonStyle.ENABLE);
        }else if(actionCommand.equals(btn2.getText())) {
            btn2.setStyle(button2.ButtonStyle.ENABLE);
        }else if(actionCommand.equals(btn3.getText())) {
            btn3.setStyle(button2.ButtonStyle.ENABLE);
        }else if(actionCommand.equals(btn4.getText())) {
            btn4.setStyle(button2.ButtonStyle.ENABLE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtRequest = new javax.swing.JLabel();
        txtContent = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn1 = new com.fpoly.swing.button2();
        btn2 = new com.fpoly.swing.button2();
        btn3 = new com.fpoly.swing.button2();
        btn4 = new com.fpoly.swing.button2();
        lblSequence = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(247, 255, 247));

        txtRequest.setBackground(new java.awt.Color(1, 119, 41));
        txtRequest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRequest.setText("QuestionRequest:");

        txtContent.setBackground(new java.awt.Color(1, 119, 41));
        txtContent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtContent.setText("QuestionContent:");

        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 4, 4));

        btn1.setText("button21");
        buttonGroup1.add(btn1);
        jPanel1.add(btn1);

        btn2.setText("button23");
        buttonGroup1.add(btn2);
        jPanel1.add(btn2);

        btn3.setText("button22");
        buttonGroup1.add(btn3);
        jPanel1.add(btn3);

        btn4.setText("button24");
        buttonGroup1.add(btn4);
        jPanel1.add(btn4);

        lblSequence.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSequence.setForeground(new java.awt.Color(0, 155, 18));
        lblSequence.setText("sequence");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                    .addComponent(txtRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSequence)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSequence)
                .addGap(11, 11, 11)
                .addComponent(txtRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContent)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.button2 btn1;
    private com.fpoly.swing.button2 btn2;
    private com.fpoly.swing.button2 btn3;
    private com.fpoly.swing.button2 btn4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblSequence;
    private javax.swing.JLabel txtContent;
    private javax.swing.JLabel txtRequest;
    // End of variables declaration//GEN-END:variables
}
