/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpoly.form;

import com.fpoly.DAO.AnswerAndQuestionDao;
import com.fpoly.DAO.TestDAO;
import com.fpoly.dialog.MessageDialog;
import com.fpoly.main.Main;
import com.fpoly.models.AnswerAndQuestion;
import com.fpoly.models.Test;
import com.fpoly.swing.button2;
import com.fpoly.utils.XValidate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bimzc
 */
public class InsertTest extends javax.swing.JPanel {

    /**
     * Creates new form InsertTest
     */
    public InsertTest() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        AnswerAndQuestion.setBackground(new Color(255, 255, 255));
        designTable();
        hide(true);
        TestDetail.setBackground(new Color(255, 255, 255));
        loadTableTest();
    }

    private void table_head_color(JTable table_name) {
        DefaultTableCellRenderer head_render = new DefaultTableCellRenderer();

        head_render.setBackground(new Color(204, 153, 255));
        table_name.getTableHeader().setDefaultRenderer(head_render);

        //to call above method
        //table_head_color("write table name");
    }

    private void scroll_bar_color(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.GRAY;
            }
        });
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(Integer.MAX_VALUE, 2));
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(WIDTH, Integer.MAX_VALUE));
    }

    public void hide(boolean agree) {
        AnswerAndQuestion.setVisible(agree);
        PanelTestFull.setVisible(agree);
        PanelAnswerFull.setVisible(!agree);
        TestDetail.setVisible(!agree);
    }

    void designTable() {
        jTable2.getTableHeader().setOpaque(true);
        jTable2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table_head_color(jTable2);
        table_head_color(jTable3);
        scroll_bar_color(jScrollPane1);
        scroll_bar_color(jScrollPane3);
        jTable2.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable2.setRowHeight(25);
    }

    public void loadTableAns() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        AnswerAndQuestionDao aqqDao = new AnswerAndQuestionDao();
        List<Object[]> list = aqqDao.SELECT_MODEL();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void loadTableAnsFind() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        AnswerAndQuestionDao aqqDao = new AnswerAndQuestionDao();
        List<Object[]> list = aqqDao.SELECT_MODEL(txtFind.getText());
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void loadTableTest() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        TestDAO tsDAO = new TestDAO();
        List<Object[]> list = tsDAO.SELECT_MODEL();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    void setModelTest(Test test) {
        txtLevel.setText(String.valueOf(test.getLevel()));
        txtQuantity.setText(String.valueOf(test.getNumberOfQues()));
    }

    void setModelAns(AnswerAndQuestion Ans) {
        TestDAO tsDAO = new TestDAO();
        Test test = tsDAO.SELECT_BY_ID(Ans.getTestID());
        txtRequest.setText(Ans.getRequest());
        txtQues.setText(Ans.getQuestionContent());
        txtTestNumber.setText(String.valueOf(Ans.getTestID()));
        txtAns1.setText(Ans.getAnswer1());
        txtAns2.setText(Ans.getAnswer2());
        txtAns3.setText(Ans.getAnswer3());
        txtAns4.setText(Ans.getAnswer4());
        txtRightAns.setText(Ans.getRightAnswer());
        txtPoint1.setText(String.valueOf(Ans.getPoint()));
    }

    void Clear() {
        txtRequest.setText("");
        txtQues.setText("");
        txtTestNumber.setText("");
        txtAns1.setText("");
        txtAns2.setText("");
        txtAns3.setText("");
        txtAns4.setText("");
        txtRightAns.setText("");
        txtPoint1.setText("");
    }

    AnswerAndQuestion getModelAns() {
        AnswerAndQuestion Ans = new AnswerAndQuestion();
        int in = jTable2.getSelectedRow();
        Ans.setQuestionID((int) jTable2.getValueAt(in, 0));
        Ans.setTestID(Integer.parseInt(txtTestNumber.getText()));
        Ans.setRequest(txtRequest.getText());
        Ans.setQuestionContent(txtQues.getText());
        Ans.setAnswer1(txtAns1.getText());
        Ans.setAnswer2(txtAns2.getText());
        Ans.setAnswer3(txtAns3.getText());
        Ans.setAnswer4(txtAns4.getText());
        Ans.setRightAnswer(txtRightAns.getText());
        Ans.setPoint(Integer.parseInt(txtPoint1.getText()));
        return Ans;
    }

    Test getModeTest() {
        Test ts = new Test();
        int row = jTable3.getSelectedRow();
        ts.setTestID((int) jTable3.getValueAt(row, 0));
        ts.setLevel(Integer.parseInt(txtLevel.getText()));
        ts.setNumberOfQues(Integer.parseInt(txtQuantity.getText()));
        return ts;
    }

    public void clearTest() {
        txtLevel.setText("");
        txtQuantity.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIn4 = new javax.swing.JPanel();
        AnswerAndQuestion = new javax.swing.JPanel();
        txtQuantity = new com.fpoly.swing.TextField2();
        txtLevel = new com.fpoly.swing.TextField2();
        btnInsert = new com.fpoly.swing.button2();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new com.fpoly.swing.button2();
        btnGo = new com.fpoly.swing.button2();
        TestDetail = new javax.swing.JPanel();
        btnAnsUpdate = new com.fpoly.swing.button2();
        txtFind = new com.fpoly.swing.TextField2();
        btnAnsInsert = new com.fpoly.swing.button2();
        jPanel1 = new javax.swing.JPanel();
        txtRightAns = new com.fpoly.swing.TextField2();
        txtTestNumber = new com.fpoly.swing.TextField2();
        txtPoint1 = new com.fpoly.swing.TextField2();
        txContent = new com.fpoly.swing.textarea.TextAreaScroll();
        txtQues = new com.fpoly.swing.textarea.TextArea();
        txtRequest = new com.fpoly.swing.TextField2();
        txtAns1 = new com.fpoly.swing.TextField2();
        txtAns2 = new com.fpoly.swing.TextField2();
        txtAns3 = new com.fpoly.swing.TextField2();
        txtAns4 = new com.fpoly.swing.TextField2();
        button21 = new com.fpoly.swing.button2();
        btnSearch = new com.fpoly.swing.button2();
        jPanel3 = new javax.swing.JPanel();
        PanelAnswerFull = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        PanelTestFull = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlIn4.setBackground(new java.awt.Color(255, 255, 255));
        pnlIn4.setLayout(new java.awt.CardLayout());

        AnswerAndQuestion.setBackground(new java.awt.Color(255, 255, 255));

        txtQuantity.setLabelText("Number Of Question");

        txtLevel.setLabelText("Level Of Test");

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TEST DETAIL");

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnGo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/more_than_20px.png"))); // NOI18N
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AnswerAndQuestionLayout = new javax.swing.GroupLayout(AnswerAndQuestion);
        AnswerAndQuestion.setLayout(AnswerAndQuestionLayout);
        AnswerAndQuestionLayout.setHorizontalGroup(
            AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addGap(297, 297, 297))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnswerAndQuestionLayout.createSequentialGroup()
                        .addGroup(AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                                .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(73, 73, 73)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(73, 73, 73)
                                .addComponent(btnGo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(121, 121, 121))))
        );
        AnswerAndQuestionLayout.setVerticalGroup(
            AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pnlIn4.add(AnswerAndQuestion, "card3");

        TestDetail.setBackground(new java.awt.Color(255, 255, 255));
        TestDetail.setOpaque(false);

        btnAnsUpdate.setText("UPDATE");
        btnAnsUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnsUpdateActionPerformed(evt);
            }
        });

        txtFind.setLabelText("Input Test Number ");

        btnAnsInsert.setText("INSERT");
        btnAnsInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnsInsertActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        txtRightAns.setLabelText("Right Answer");
        jPanel1.add(txtRightAns);

        txtTestNumber.setLabelText("Test Number");
        jPanel1.add(txtTestNumber);

        txtPoint1.setLabelText("Point");
        jPanel1.add(txtPoint1);

        txContent.setLabelText("Question");

        txtQues.setColumns(20);
        txtQues.setRows(5);
        txContent.setViewportView(txtQues);

        txtRequest.setLabelText("Type Of Question");

        txtAns1.setLabelText("Answer 1");

        txtAns2.setLabelText("Answer 2");

        txtAns3.setLabelText("Answer 3");

        txtAns4.setLabelText("Answer 4");

        button21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/back_20px.png"))); // NOI18N
        button21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button21ActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/search_20px.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TestDetailLayout = new javax.swing.GroupLayout(TestDetail);
        TestDetail.setLayout(TestDetailLayout);
        TestDetailLayout.setHorizontalGroup(
            TestDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TestDetailLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(TestDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TestDetailLayout.createSequentialGroup()
                        .addComponent(button21, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(btnAnsUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(55, 55, 55)
                        .addComponent(btnAnsInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82)
                .addGroup(TestDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TestDetailLayout.createSequentialGroup()
                        .addComponent(txtFind, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAns1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAns2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAns3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAns4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        TestDetailLayout.setVerticalGroup(
            TestDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TestDetailLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(TestDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TestDetailLayout.createSequentialGroup()
                        .addComponent(txtRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txContent, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(TestDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnsInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAnsUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(TestDetailLayout.createSequentialGroup()
                        .addComponent(txtAns1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtAns2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtAns3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtAns4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(TestDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );

        pnlIn4.add(TestDetail, "card2");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.CardLayout());

        PanelAnswerFull.setBackground(new java.awt.Color(255, 255, 255));
        PanelAnswerFull.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numerical Oder", "Test Number", "Request ", "Question", "Answer 1", "Answer 2", "Answer 3", "Answer 4", "Right Answer ", "Point"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        PanelAnswerFull.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(PanelAnswerFull, "card2");

        PanelTestFull.setLayout(new java.awt.BorderLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numberical Order", "Level", "Questions Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setFocusable(false);
        jTable3.setOpaque(false);
        jTable3.setRowHeight(25);
        jTable3.setSelectionBackground(new java.awt.Color(153, 255, 255));
        jTable3.setShowHorizontalLines(false);
        jTable3.setShowVerticalLines(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable3MousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        PanelTestFull.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel3.add(PanelTestFull, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlIn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if (XValidate.checkNullText(txtLevel)
                && XValidate.checkNullText(txtQuantity)) {
            if (XValidate.isNumber(txtLevel)
                    && XValidate.isNumber(txtQuantity)) {
                TestDAO dAO = new TestDAO();
                Test ts = new Test();
                ts.setLevel(Integer.parseInt(txtLevel.getText()));
                ts.setNumberOfQues(Integer.parseInt(txtQuantity.getText()));
                dAO.insert(ts);
                loadTableTest();
                clearTest();
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void jTable3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MousePressed

    }//GEN-LAST:event_jTable3MousePressed

    private void btnAnsUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnsUpdateActionPerformed
        AnswerAndQuestionDao AnsdDao = new AnswerAndQuestionDao();
        if (XValidate.checkNullText(txtRequest)
                && XValidate.checkNullTextAr(txtQues)
                && XValidate.checkNullText(txtRightAns)
                && XValidate.checkNullText(txtPoint1)
                && XValidate.checkNullText(txtTestNumber)
                && XValidate.checkNullText(txtAns1)
                && XValidate.checkNullText(txtAns2)
                && XValidate.checkNullText(txtAns3)
                && XValidate.checkNullText(txtAns4)) {
            if (XValidate.isNumber(txtPoint1)
                    && XValidate.isNumber(txtTestNumber)) {
                AnswerAndQuestion Ans = getModelAns();
                AnswerAndQuestionDao andQuestionDao = new AnswerAndQuestionDao();
                andQuestionDao.update(Ans);
                loadTableAns();
                Clear();

            }
        }
        {
        }

    }//GEN-LAST:event_btnAnsUpdateActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        if (evt.getClickCount() == 1) {
            int index = jTable3.getSelectedRow();
            if (index >= 0) {
                int id = (int) jTable3.getValueAt(index, 0);
                TestDAO tsDAO = new TestDAO();
                Test test = tsDAO.SELECT_BY_ID(id);
                if (test != null) {
                    setModelTest(test);
                } else {

                }
            }
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            if (evt.getClickCount() == 2) {
                int row = jTable2.getSelectedRow();
                if (row >= 0) {
                    int quesId = (int) jTable2.getValueAt(row, 0);
                    AnswerAndQuestionDao aaqDao = new AnswerAndQuestionDao();
                    AnswerAndQuestion ans = aaqDao.SELECT_BY_ID(quesId);
                    if (ans != null) {
                        setModelAns(ans);
                    } else {
                        System.out.println("ngu");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (XValidate.checkNullText(txtLevel)
                && XValidate.checkNullText(txtQuantity)) {
            if (XValidate.isNumber(txtLevel)
                    && XValidate.isNumber(txtQuantity)) {
                TestDAO dAO = new TestDAO();
                Test ts = getModeTest();
                dAO.update(ts);
                loadTableTest();
                clearTest();
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAnsInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnsInsertActionPerformed

        if (XValidate.checkNullText(txtRequest)
                && XValidate.checkNullTextAr(txtQues)
                && XValidate.checkNullText(txtRightAns)
                && XValidate.checkNullText(txtPoint1)
                && XValidate.checkNullText(txtTestNumber)
                && XValidate.checkNullText(txtAns1)
                && XValidate.checkNullText(txtAns2)
                && XValidate.checkNullText(txtAns3)
                && XValidate.checkNullText(txtAns4)) {
            if (XValidate.isNumber(txtPoint1)
                    && XValidate.isNumber(txtTestNumber)) {
                AnswerAndQuestion Ans = new AnswerAndQuestion();
                Ans.setTestID(Integer.parseInt(txtTestNumber.getText()));
                Ans.setRequest(txtRequest.getText());
                Ans.setQuestionContent(txtQues.getText());
                Ans.setAnswer1(txtAns1.getText());
                Ans.setAnswer2(txtAns2.getText());
                Ans.setAnswer3(txtAns3.getText());
                Ans.setAnswer4(txtAns4.getText());
                Ans.setRightAnswer(txtRightAns.getText());
                Ans.setPoint(Integer.parseInt(txtPoint1.getText()));
                AnswerAndQuestionDao andQuestionDao = new AnswerAndQuestionDao();
                andQuestionDao.insert(Ans);
                loadTableAns();
                Clear();

            }
        }
        {
        }
    }//GEN-LAST:event_btnAnsInsertActionPerformed

    private void button21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button21ActionPerformed
        hide(true);
    }//GEN-LAST:event_button21ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        loadTableAnsFind();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed

        btnGo.setToolTipText("Go to Answer And Questions For Test");
        hide(false);
        loadTableAns();
    }//GEN-LAST:event_btnGoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AnswerAndQuestion;
    private javax.swing.JPanel PanelAnswerFull;
    private javax.swing.JPanel PanelTestFull;
    private javax.swing.JPanel TestDetail;
    private com.fpoly.swing.button2 btnAnsInsert;
    private com.fpoly.swing.button2 btnAnsUpdate;
    private com.fpoly.swing.button2 btnGo;
    private com.fpoly.swing.button2 btnInsert;
    private com.fpoly.swing.button2 btnSearch;
    private com.fpoly.swing.button2 btnUpdate;
    private com.fpoly.swing.button2 button21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JPanel pnlIn4;
    private com.fpoly.swing.textarea.TextAreaScroll txContent;
    private com.fpoly.swing.TextField2 txtAns1;
    private com.fpoly.swing.TextField2 txtAns2;
    private com.fpoly.swing.TextField2 txtAns3;
    private com.fpoly.swing.TextField2 txtAns4;
    private com.fpoly.swing.TextField2 txtFind;
    private com.fpoly.swing.TextField2 txtLevel;
    private com.fpoly.swing.TextField2 txtPoint1;
    private com.fpoly.swing.TextField2 txtQuantity;
    private com.fpoly.swing.textarea.TextArea txtQues;
    private com.fpoly.swing.TextField2 txtRequest;
    private com.fpoly.swing.TextField2 txtRightAns;
    private com.fpoly.swing.TextField2 txtTestNumber;
    // End of variables declaration//GEN-END:variables
}
