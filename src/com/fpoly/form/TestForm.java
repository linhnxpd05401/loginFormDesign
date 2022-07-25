package com.fpoly.form;

import com.fpoly.DAO.AnswerAndQuestionDao;
import com.fpoly.DAO.TestDAO;
import com.fpoly.DAO.TestingProgressDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.components.Card;
import com.fpoly.components.Congralulate;
import com.fpoly.components.TestInfo;
import com.fpoly.dialog.MessageDialog;
import com.fpoly.main.Main;
import com.fpoly.models.AnswerAndQuestion;
import com.fpoly.models.ModelCard;
import com.fpoly.models.Test;
import com.fpoly.swing.scrollbar.ScrollBarCustom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import com.fpoly.models.TestProcessing;
import com.fpoly.models.User;
import com.fpoly.swing.button2;
import com.fpoly.utils.Auth;
import java.awt.Color;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class TestForm extends javax.swing.JPanel {

    private int indexQues = 0;
    private int indexTest;
    private int point = 0;
    private TestingProgressDAO tpDAO;
    private boolean choose;

    public TestForm() {
        initComponents();
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.setBorder(null);
        sp.getInsets().set(0, 0, 0, 0);
        sp.setViewportBorder(null);
        sp.getViewport().setBorder(null);
        sp.getViewport().getInsets().set(0, 0, 0, 0);
        hide(true);
        init();
    }

    void hide(boolean flg) {
        panelChooseTest.setVisible(flg);
        panelTest.setVisible(!flg);
    }

    UserDAO usDao = new UserDAO();
    TestDAO testDAO = new TestDAO();
    TestInfo testInfo = new TestInfo();
    List<Test> list = testDAO.selectAll();
    User user = usDao.selectByAccountID(Auth.acc.getID());

    int min = list.get(indexTest).getTime();
    int sec = 0;

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (sec == 0) {
                sec = 60;
                min--;
            }
            if (min < 0) {
                min = 0;
                sec = 0;
            } else {
                sec--;
                setTime(min, sec);
            }
        }
    });

    public void setTime(int min, int sec) {
        lblMinute.setText("" + min);
        lblSecond.setText("" + sec);
        if (sec < 10) {
            lblSecond.setText("0" + sec);
        }
    }

    private void init() {
        panelTest.setBorder(new EmptyBorder(20, 20, 20, 20));
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/com/fpoly/icons/lock_50px.png"));
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/com/fpoly/icons/padlock_50px.png"));
        tpDAO = new TestingProgressDAO();
        for (int i = 0; i < CardContainer.getComponentCount(); i++) {
            List<TestProcessing> listLp = tpDAO.checkUnlock(user.getUserID(), list.get(i).getTestID());
            Card card = (Card) CardContainer.getComponent(i);
            if (user.getCoin() < list.get(i).getCoinToPass()) {
                card.setEnabled(false);
                card.setData(new ModelCard(list.get(i).getTestName(), list.get(i).getNumberOfQues(), 0, icon1));

            } else {
                card.setEnabled(true);
                card.setData(new ModelCard(list.get(i).getTestName(), list.get(i).getNumberOfQues(), 0, icon2));
            }
            if (listLp.size() > 0) {
                double percent = dataProcess();
                card.setEnabled(true);
                card.setBackground(new Color(0, 204, 255));
                card.setColorGradient(new Color(0, 102, 255));
                card.setData(new ModelCard(list.get(i).getTestName(), list.get(i).getNumberOfQues(), (int) percent, icon2));
            }

        }

        testInfo.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (min > 0) {
                    timer.start();
                }
                if (e.getActionCommand().equals("UNLOCK")) {
                    if (user.getCoin() >= list.get(indexTest).getPassingPoint()) {
                        tpDAO = new TestingProgressDAO();
                        int userID = user.getUserID();
                        int testID = list.get(indexTest).getTestID();
                        int mark = 0;
                        Date testingDay = new Date(System.currentTimeMillis());
                        boolean status = false;
                        TestProcessing tp = new TestProcessing(userID, testID, mark, testingDay, status);
                        tpDAO.insert(tp);
                        hide(false);
                        User usCoin = new User(userID, (user.getCoin() - list.get(indexTest).getCoinToPass()));
                        usDao.updateCoin(usCoin);
                    } else {
                        MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
                        mess.showMessage(MessageDialog.MessageType.ERROR, "Your coins are not enough!");
                    }
                }
                if (e.getActionCommand().equals("START AGAIN")) {
                    hide(false);
                }
            }
        });
    }

    private double dataProcess() {
        double percentage = 0;
        tpDAO = new TestingProgressDAO();
        List<TestProcessing> listTp = tpDAO.SelectByUserID(user.getUserID());
        TestProcessing tp = listTp.get(0);
        if (tp.isStatus()) {
            percentage = 100;
        } else {
            Test test = testDAO.SELECT_BY_ID(tp.getTestID());
            percentage = ((1.0) * tp.getMark() / test.getPassingPoint()) * 100;
        }
        return percentage;
    }

    private void addDataForTestInfo(int index) {
        testInfo.addData(list.get(index).getTestName(), list.get(index).getTime());
        panelInfo.add(testInfo);
        panelInfo.repaint();
        panelInfo.revalidate();
    }

    private void initDataQuestion(int indexTest, int indexQues) {
        AnswerAndQuestionDao tsqDAO = new AnswerAndQuestionDao();
        List<AnswerAndQuestion> listQues = tsqDAO.selectByTestID(list.get(indexTest).getTestID());
        if (indexQues < listQues.size()) {
            lblRequest.setText((indexQues + 1) + ". " + listQues.get(indexQues).getRequest());
            lblContent.setText(listQues.get(indexQues).getQuestionContent());
            btn1.setText(listQues.get(indexQues).getAnswer1());
            btn2.setText(listQues.get(indexQues).getAnswer2());
            btn3.setText(listQues.get(indexQues).getAnswer3());
            btn4.setText(listQues.get(indexQues).getAnswer4());
        } else {
            setEnableBtn(false);
        }
    }

    private void checkAsw(String asw, button2 btn) {
        AnswerAndQuestionDao tsqDAO = new AnswerAndQuestionDao();
        List<AnswerAndQuestion> listQues = tsqDAO.selectByTestID(list.get(indexTest).getTestID());
        if (indexQues < listQues.size()) {
            if (asw.equals(listQues.get(indexQues).getRightAnswer())) {
                point++;
                btn.setText("");
                ImageIcon icon = new ImageIcon(getClass().getResource("/com/fpoly/icons/ok_50px.png"));
                btn.setDisabledIcon(icon);
                btn.setStyle(button2.ButtonStyle.SECONDARY);
            } else {
                btn.setText("");
                btn.setDisabledIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/cancel_50px.png")));
                btn.setStyle(button2.ButtonStyle.DESTRUCTIVE);
            }
        }
    }

    private void setEnableBtn(boolean Enable) {
        btn1.setEnabled(Enable);
        btn1.setIcon(new ImageIcon(""));
        btn2.setEnabled(Enable);
        btn2.setIcon(new ImageIcon(""));
        btn3.setEnabled(Enable);
        btn3.setIcon(new ImageIcon(""));
        btn4.setEnabled(Enable);
        btn4.setIcon(new ImageIcon(""));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelChooseTest = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        CardContainer = new javax.swing.JPanel();
        test1 = new com.fpoly.components.Card();
        test2 = new com.fpoly.components.Card();
        test3 = new com.fpoly.components.Card();
        test4 = new com.fpoly.components.Card();
        test5 = new com.fpoly.components.Card();
        test6 = new com.fpoly.components.Card();
        test7 = new com.fpoly.components.Card();
        test8 = new com.fpoly.components.Card();
        test9 = new com.fpoly.components.Card();
        test10 = new com.fpoly.components.Card();
        test11 = new com.fpoly.components.Card();
        test12 = new com.fpoly.components.Card();
        test13 = new com.fpoly.components.Card();
        panelInfo = new javax.swing.JPanel();
        panelTest = new javax.swing.JPanel();
        panelClock = new javax.swing.JPanel();
        lblMinute = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSecond = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblRequest = new javax.swing.JLabel();
        lblContent = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn1 = new com.fpoly.swing.button2();
        btn2 = new com.fpoly.swing.button2();
        btn3 = new com.fpoly.swing.button2();
        btn4 = new com.fpoly.swing.button2();
        btnNext = new com.fpoly.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(900, 703));
        setLayout(new java.awt.CardLayout());

        panelChooseTest.setBackground(new java.awt.Color(255, 255, 255));

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        CardContainer.setBackground(new java.awt.Color(255, 255, 255));
        CardContainer.setLayout(new java.awt.GridLayout(0, 1, 5, 5));

        test1.setBackground(new java.awt.Color(0, 204, 255));
        test1.setColorGradient(new java.awt.Color(0, 102, 255));
        test1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test1MouseClicked(evt);
            }
        });
        CardContainer.add(test1);

        test2.setBackground(new java.awt.Color(0, 204, 255));
        test2.setColorGradient(new java.awt.Color(0, 102, 204));
        test2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test2MouseClicked(evt);
            }
        });
        CardContainer.add(test2);

        test3.setBackground(new java.awt.Color(0, 204, 255));
        test3.setColorGradient(new java.awt.Color(0, 102, 204));
        test3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test3MouseClicked(evt);
            }
        });
        CardContainer.add(test3);

        test4.setBackground(new java.awt.Color(0, 204, 255));
        test4.setColorGradient(new java.awt.Color(0, 102, 204));
        test4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test4MouseClicked(evt);
            }
        });
        CardContainer.add(test4);

        test5.setBackground(new java.awt.Color(0, 204, 255));
        test5.setColorGradient(new java.awt.Color(0, 102, 204));
        test5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test5MouseClicked(evt);
            }
        });
        CardContainer.add(test5);

        test6.setBackground(new java.awt.Color(0, 204, 255));
        test6.setColorGradient(new java.awt.Color(0, 102, 204));
        test6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test6MouseClicked(evt);
            }
        });
        CardContainer.add(test6);

        test7.setBackground(new java.awt.Color(0, 204, 255));
        test7.setColorGradient(new java.awt.Color(0, 102, 204));
        test7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test7MouseClicked(evt);
            }
        });
        CardContainer.add(test7);

        test8.setBackground(new java.awt.Color(0, 204, 255));
        test8.setColorGradient(new java.awt.Color(0, 102, 204));
        test8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test8MouseClicked(evt);
            }
        });
        CardContainer.add(test8);

        test9.setBackground(new java.awt.Color(0, 204, 255));
        test9.setColorGradient(new java.awt.Color(0, 102, 204));
        test9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test9MouseClicked(evt);
            }
        });
        CardContainer.add(test9);

        test10.setBackground(new java.awt.Color(0, 204, 255));
        test10.setColorGradient(new java.awt.Color(0, 102, 204));
        test10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test10MouseClicked(evt);
            }
        });
        CardContainer.add(test10);

        test11.setBackground(new java.awt.Color(0, 204, 255));
        test11.setColorGradient(new java.awt.Color(0, 102, 204));
        test11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test11MouseClicked(evt);
            }
        });
        CardContainer.add(test11);

        test12.setBackground(new java.awt.Color(0, 204, 255));
        test12.setColorGradient(new java.awt.Color(0, 102, 204));
        test12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test12MouseClicked(evt);
            }
        });
        CardContainer.add(test12);

        test13.setBackground(new java.awt.Color(0, 204, 255));
        test13.setColorGradient(new java.awt.Color(0, 102, 204));
        test13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                test13MouseClicked(evt);
            }
        });
        CardContainer.add(test13);

        sp.setViewportView(CardContainer);

        panelInfo.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout panelChooseTestLayout = new javax.swing.GroupLayout(panelChooseTest);
        panelChooseTest.setLayout(panelChooseTestLayout);
        panelChooseTestLayout.setHorizontalGroup(
            panelChooseTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChooseTestLayout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
        );
        panelChooseTestLayout.setVerticalGroup(
            panelChooseTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
            .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );

        add(panelChooseTest, "card4");

        panelTest.setBackground(new java.awt.Color(255, 255, 255));
        panelTest.setLayout(new java.awt.BorderLayout());

        panelClock.setBackground(new java.awt.Color(255, 255, 255));

        lblMinute.setBackground(new java.awt.Color(255, 255, 255));
        lblMinute.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblMinute.setForeground(new java.awt.Color(162, 7, 7));
        lblMinute.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinute.setText("00");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(162, 7, 7));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(":");

        lblSecond.setBackground(new java.awt.Color(255, 255, 255));
        lblSecond.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lblSecond.setForeground(new java.awt.Color(162, 7, 7));
        lblSecond.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSecond.setText("00");

        javax.swing.GroupLayout panelClockLayout = new javax.swing.GroupLayout(panelClock);
        panelClock.setLayout(panelClockLayout);
        panelClockLayout.setHorizontalGroup(
            panelClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClockLayout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(lblMinute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSecond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(350, 350, 350))
        );
        panelClockLayout.setVerticalGroup(
            panelClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClockLayout.createSequentialGroup()
                .addGroup(panelClockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(lblSecond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMinute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        panelTest.add(panelClock, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(216, 255, 224));

        lblRequest.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblRequest.setForeground(new java.awt.Color(7, 99, 30));
        lblRequest.setText("Request");

        lblContent.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblContent.setForeground(new java.awt.Color(7, 99, 30));
        lblContent.setText("Question content");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        btn1.setText("button22");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1);

        btn2.setText("button24");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2);

        btn3.setText("button23");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3);

        btn4.setText("button21");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4);

        btnNext.setBackground(new java.awt.Color(246, 98, 0));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next");
        btnNext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContent)
                            .addComponent(lblRequest)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addGap(323, 323, 323)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContent)
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        panelTest.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        add(panelTest, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (choose == true) {
            AnswerAndQuestionDao tsqDAO = new AnswerAndQuestionDao();
            List<AnswerAndQuestion> listQues = tsqDAO.selectByTestID(list.get(indexTest).getTestID());
            tpDAO = new TestingProgressDAO();
            if (indexQues == (listQues.size() - 1)) {
                btnNext.setText("Finish");
                btnNext.setBackground(new Color(5, 117, 230));

                setEnableBtn(false);
            } else if (indexQues < listQues.size()) {
                indexQues++;
                initDataQuestion(indexTest, indexQues);
                setEnableBtn(true);
                choose = false;
            }

            if (min == 0) {
                List<TestProcessing> listTp = tpDAO.checkPass(user.getUserID(), list.get(indexTest).getTestID());
                if (point >= list.get(indexTest).getPassingPoint()) {
                    int userID = user.getUserID();
                    int mark = point;
                    Date date = new Date(System.currentTimeMillis());
                    TestProcessing tp = new TestProcessing(userID, mark, date);
                    tpDAO.updateTestPass(tp);
                    btnNext.setEnabled(false);
                } else if (!listTp.isEmpty()) {
                    if (listTp.get(0).getMark() < point) {
                        int userID = user.getUserID();
                        int mark = point;
                        Date date = new Date(System.currentTimeMillis());
                        TestProcessing tp = new TestProcessing(userID, mark, date);
                        tpDAO.updateMark(tp);
                        btnNext.setEnabled(false);
                    }
                } else {
                    int userID = user.getUserID();
                    int mark = point;
                    Date date = new Date(System.currentTimeMillis());
                    TestProcessing tp = new TestProcessing(userID, mark, date);
                    tpDAO.updateMark(tp);
                    btnNext.setEnabled(false);
                }
                panelTest.removeAll();
                Congralulate congra = new Congralulate();
                congra.updateLabel(point, list.get(indexTest).getPassingPoint());
                panelTest.add(congra);
                panelTest.repaint();
                panelTest.revalidate();
            }

            if (evt.getActionCommand().equals("Finish")) {
                List<TestProcessing> listTp = tpDAO.checkPass(user.getUserID(), list.get(indexTest).getTestID());
                if (point >= list.get(indexTest).getPassingPoint()) {
                    int userID = user.getUserID();
                    int mark = point;
                    Date date = new Date(System.currentTimeMillis());
                    TestProcessing tp = new TestProcessing(userID, mark, date);
                    tpDAO.updateTestPass(tp);
                    btnNext.setEnabled(false);
                } else if (!listTp.isEmpty()) {
                    if (listTp.get(0).getMark() < point) {
                        int userID = user.getUserID();
                        int mark = point;
                        Date date = new Date(System.currentTimeMillis());
                        TestProcessing tp = new TestProcessing(userID, mark, date);
                        tpDAO.updateMark(tp);
                        btnNext.setEnabled(false);
                    }
                } else {
                    int userID = user.getUserID();
                    int mark = point;
                    Date date = new Date(System.currentTimeMillis());
                    TestProcessing tp = new TestProcessing(userID, mark, date);
                    tpDAO.updateMark(tp);
                    btnNext.setEnabled(false);
                }
                panelTest.removeAll();
                Congralulate congra = new Congralulate();
                congra.updateLabel(point, list.get(indexTest).getPassingPoint());
                panelTest.add(congra);
                panelTest.repaint();
                panelTest.revalidate();
                timer.stop();
            }
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        String asw = evt.getActionCommand();
        setEnableBtn(false);
        checkAsw(asw, btn1);
        choose = true;
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        String asw = evt.getActionCommand();
        setEnableBtn(false);
        checkAsw(asw, btn2);
        choose = true;
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        String asw = evt.getActionCommand();
        setEnableBtn(false);
        checkAsw(asw, btn3);
        choose = true;
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        String asw = evt.getActionCommand();
        setEnableBtn(false);
        checkAsw(asw, btn4);
        choose = true;
    }//GEN-LAST:event_btn4ActionPerformed

    private void test1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test1MouseClicked
        indexTest = 0;
        testInfo.checkLock(user.getCoin(), list.get(0).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(0);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test1MouseClicked

    private void test2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test2MouseClicked
        indexTest = 1;
        testInfo.checkLock(user.getCoin(), list.get(1).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(1);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test2MouseClicked

    private void test3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test3MouseClicked
        indexTest = 2;
        testInfo.checkLock(user.getCoin(), list.get(3).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(2);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test3MouseClicked

    private void test4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test4MouseClicked
        indexTest = 3;
        testInfo.checkLock(user.getCoin(), list.get(3).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(3);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test4MouseClicked

    private void test5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test5MouseClicked
        indexTest = 4;
        testInfo.checkLock(user.getCoin(), list.get(4).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(4);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test5MouseClicked

    private void test6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test6MouseClicked
        indexTest = 5;
        testInfo.checkLock(user.getCoin(), list.get(5).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(5);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test6MouseClicked

    private void test7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test7MouseClicked
        indexTest = 6;
        testInfo.checkLock(user.getCoin(), list.get(6).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(6);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test7MouseClicked

    private void test8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test8MouseClicked
        indexTest = 7;
        testInfo.checkLock(user.getCoin(), list.get(7).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(7);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test8MouseClicked

    private void test9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test9MouseClicked
        indexTest = 8;
        testInfo.checkLock(user.getCoin(), list.get(8).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(8);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test9MouseClicked

    private void test10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test10MouseClicked
        indexTest = 9;
        testInfo.checkLock(user.getCoin(), list.get(10).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(9);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test10MouseClicked

    private void test11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test11MouseClicked
        indexTest = 10;
        testInfo.checkLock(user.getCoin(), list.get(11).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(10);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test11MouseClicked

    private void test12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test12MouseClicked
        indexTest = 11;
        testInfo.checkLock(user.getCoin(), list.get(12).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(11);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test12MouseClicked

    private void test13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_test13MouseClicked
        indexTest = 12;
        testInfo.checkLock(user.getCoin(), list.get(12).getCoinToPass(), user.getUserID(), list.get(indexTest).getTestID());
        addDataForTestInfo(12);
        initDataQuestion(indexTest, indexQues);
    }//GEN-LAST:event_test13MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardContainer;
    private com.fpoly.swing.button2 btn1;
    private com.fpoly.swing.button2 btn2;
    private com.fpoly.swing.button2 btn3;
    private com.fpoly.swing.button2 btn4;
    private com.fpoly.swing.Button btnNext;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblContent;
    private javax.swing.JLabel lblMinute;
    private javax.swing.JLabel lblRequest;
    private javax.swing.JLabel lblSecond;
    private javax.swing.JPanel panelChooseTest;
    private javax.swing.JPanel panelClock;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelTest;
    private javax.swing.JScrollPane sp;
    private com.fpoly.components.Card test1;
    private com.fpoly.components.Card test10;
    private com.fpoly.components.Card test11;
    private com.fpoly.components.Card test12;
    private com.fpoly.components.Card test13;
    private com.fpoly.components.Card test2;
    private com.fpoly.components.Card test3;
    private com.fpoly.components.Card test4;
    private com.fpoly.components.Card test5;
    private com.fpoly.components.Card test6;
    private com.fpoly.components.Card test7;
    private com.fpoly.components.Card test8;
    private com.fpoly.components.Card test9;
    // End of variables declaration//GEN-END:variables
}
