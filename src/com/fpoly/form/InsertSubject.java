/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpoly.form;

import com.fpoly.DAO.AnswerAndQuestionDao;
import com.fpoly.DAO.SubjectDAO;
import com.fpoly.DAO.TestDAO;
import com.fpoly.components.Menu;
import com.fpoly.dialog.MessageDialog;
import com.fpoly.main.Main;
import com.fpoly.models.AnswerAndQuestion;
import com.fpoly.models.Subject;
import com.fpoly.models.Test;
import com.fpoly.swing.button2;
import com.fpoly.utils.XImage;
import com.fpoly.utils.XValidate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bimzc
 */
public class InsertSubject extends javax.swing.JPanel {

    Main main;

    public InsertSubject() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        AnswerAndQuestion.setBackground(new Color(255, 255, 255));
        designTable();
        hide(true);
        TestDetail.setBackground(new Color(255, 255, 255));
        loadTableSubject();
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
        table_head_color(tablSub);
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

    public void loadTableSubject() {
        DefaultTableModel model = (DefaultTableModel) tablSub.getModel();
        model.setRowCount(0);
        SubjectDAO sbDAO = new SubjectDAO();
        List<Object[]> list = sbDAO.SELECT_MODEL();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public void setModelSubject(Subject sb) {
        txtSubject.setText(String.valueOf(sb.getSubjectName()));
        txtPassPoint.setText(String.valueOf(sb.getPassingPint()));
        if (sb.getNote() == null) {
            txaNote.setText("This is empty !");
        } else {
            txaNote.setText(sb.getNote());
        }

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

    public boolean checkNull() {
        boolean flag = false;
        if (XValidate.checkNullText(txtSubject)
                && XValidate.checkNullText(txtPassPoint)) {
            if (XValidate.isNumber(txtPassPoint)) {
                flag = true;
            }
        }
        return flag;
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

    private void ChooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(Main.getFrames()[0]) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            url = file.getName();
//            image.setToolTipText(file.getName());
//              demoImag.setIcon(icon);
            this.repaint();
        }
    }

    String url = null;

    public Subject getModeSubjct() {
        Subject sb = new Subject();
        int row = tablSub.getSelectedRow();
        sb.setSubjectName(txtSubject.getText());
        sb.setNote(txaNote.getText());
        sb.setSubjectImage(url);
        sb.setPassingPint(Integer.parseInt(txtPassPoint.getText()));
        return sb;
    }

    public void clearTest() {
        txtSubject.setText("");
        txtPassPoint.setText("");
        txaNote.setText("");
//        demoImag.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_no_image_80px.png")));
    }

    public void addLoadTestEvent(ActionListener event) {
        btnLoad.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIn4 = new javax.swing.JPanel();
        AnswerAndQuestion = new javax.swing.JPanel();
        txtPassPoint = new com.fpoly.swing.TextField2();
        txtSubject = new com.fpoly.swing.TextField2();
        btnInsert = new com.fpoly.swing.button2();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new com.fpoly.swing.button2();
        btnGo = new com.fpoly.swing.button2();
        textAreaScroll1 = new com.fpoly.swing.textarea.TextAreaScroll();
        txaNote = new com.fpoly.swing.textarea.TextArea();
        btnImage = new com.fpoly.swing.button2();
        btnLoad = new com.fpoly.swing.button2();
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
        tablSub = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlIn4.setBackground(new java.awt.Color(255, 255, 255));
        pnlIn4.setLayout(new java.awt.CardLayout());

        AnswerAndQuestion.setBackground(new java.awt.Color(255, 255, 255));

        txtPassPoint.setLabelText("Pass Point");

        txtSubject.setLabelText("Subject Name");

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUBJECT DETAIL");

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

        textAreaScroll1.setLabelText("Note(Can let Empty)");
        textAreaScroll1.setOpaque(false);

        txaNote.setColumns(20);
        txaNote.setRows(5);
        textAreaScroll1.setViewportView(txaNote);

        btnImage.setText("Choose Image");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        btnLoad.setText("Load Test");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AnswerAndQuestionLayout = new javax.swing.GroupLayout(AnswerAndQuestion);
        AnswerAndQuestion.setLayout(AnswerAndQuestionLayout);
        AnswerAndQuestionLayout.setHorizontalGroup(
            AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addGap(297, 297, 297))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnswerAndQuestionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnImage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                                    .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPassPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnGo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        AnswerAndQuestionLayout.setVerticalGroup(
            AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnswerAndQuestionLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AnswerAndQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(button21, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
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
                        .addComponent(txtFind, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
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
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(4).setHeaderValue("Answer 1");
            jTable2.getColumnModel().getColumn(5).setHeaderValue("Answer 2");
            jTable2.getColumnModel().getColumn(6).setHeaderValue("Answer 3");
            jTable2.getColumnModel().getColumn(7).setHeaderValue("Answer 4");
            jTable2.getColumnModel().getColumn(8).setHeaderValue("Right Answer ");
            jTable2.getColumnModel().getColumn(9).setHeaderValue("Point");
        }

        PanelAnswerFull.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(PanelAnswerFull, "card2");

        PanelTestFull.setLayout(new java.awt.BorderLayout());

        tablSub.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numberical Order", "Subject Name", "Note", "Pass Point"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablSub.setFocusable(false);
        tablSub.setOpaque(false);
        tablSub.setRowHeight(25);
        tablSub.setSelectionBackground(new java.awt.Color(153, 255, 255));
        tablSub.setShowHorizontalLines(false);
        tablSub.setShowVerticalLines(false);
        tablSub.getTableHeader().setReorderingAllowed(false);
        tablSub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablSubMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablSubMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablSub);

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

            if (checkNull()) {

                SubjectDAO sbDAO = new SubjectDAO();
                Subject sb = getModeSubjct();
                sbDAO.insert(sb);
                loadTableSubject();
            }

    }//GEN-LAST:event_btnInsertActionPerformed

    private void tablSubMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablSubMousePressed

    }//GEN-LAST:event_tablSubMousePressed

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

    private void tablSubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablSubMouseClicked
        if (evt.getClickCount() == 2) {
            int index = tablSub.getSelectedRow();
            if (index >= 0) {
                int id = (int) tablSub.getValueAt(index, 0);
                SubjectDAO sbDAO = new SubjectDAO();
                Subject sb = sbDAO.selectByIDInt(id);
                if (sb != null) {
                    setModelSubject(sb);
                } else {

                }
            }
        }
    }//GEN-LAST:event_tablSubMouseClicked

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
        if (XValidate.checkNullText(txtSubject)
                && XValidate.checkNullText(txtPassPoint)) {
            if (XValidate.isNumber(txtPassPoint)) {
                SubjectDAO sbDAO = new SubjectDAO();
                Subject ts = getModeSubjct();
                int index = tablSub.getSelectedRow();
                int id = (int) tablSub.getValueAt(index, 0);
                ts.setSubjectID(id);
                sbDAO.update(ts);
                loadTableSubject();
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

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        ChooseImage();
    }//GEN-LAST:event_btnImageActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AnswerAndQuestion;
    private javax.swing.JPanel PanelAnswerFull;
    private javax.swing.JPanel PanelTestFull;
    private javax.swing.JPanel TestDetail;
    private com.fpoly.swing.button2 btnAnsInsert;
    private com.fpoly.swing.button2 btnAnsUpdate;
    private com.fpoly.swing.button2 btnGo;
    private com.fpoly.swing.button2 btnImage;
    private com.fpoly.swing.button2 btnInsert;
    private com.fpoly.swing.button2 btnLoad;
    private com.fpoly.swing.button2 btnSearch;
    private com.fpoly.swing.button2 btnUpdate;
    private com.fpoly.swing.button2 button21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel pnlIn4;
    private javax.swing.JTable tablSub;
    private com.fpoly.swing.textarea.TextAreaScroll textAreaScroll1;
    private com.fpoly.swing.textarea.TextAreaScroll txContent;
    private com.fpoly.swing.textarea.TextArea txaNote;
    private com.fpoly.swing.TextField2 txtAns1;
    private com.fpoly.swing.TextField2 txtAns2;
    private com.fpoly.swing.TextField2 txtAns3;
    private com.fpoly.swing.TextField2 txtAns4;
    private com.fpoly.swing.TextField2 txtFind;
    private com.fpoly.swing.TextField2 txtPassPoint;
    private com.fpoly.swing.TextField2 txtPoint1;
    private com.fpoly.swing.textarea.TextArea txtQues;
    private com.fpoly.swing.TextField2 txtRequest;
    private com.fpoly.swing.TextField2 txtRightAns;
    private com.fpoly.swing.TextField2 txtSubject;
    private com.fpoly.swing.TextField2 txtTestNumber;
    // End of variables declaration//GEN-END:variables
}