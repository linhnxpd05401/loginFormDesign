package com.fpoly.form;

import com.fpoly.DAO.LearningProcessDAO;
import com.fpoly.DAO.QuestionExerciseDAO;
import com.fpoly.DAO.SubjectDAO;
import com.fpoly.DAO.TheorryDAO;
import com.fpoly.DAO.UnitsDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.components.Congralulate;
import com.fpoly.components.ExerciseForm;
import com.fpoly.models.LearningProcess;
import com.fpoly.models.ModelCard1;
import com.fpoly.models.QuestionExercise;
import com.fpoly.models.Subject;
import com.fpoly.models.Theory;
import com.fpoly.models.Units;
import com.fpoly.models.User;
import com.fpoly.swing.icon.GoogleMaterialDesignIcons;
import com.fpoly.swing.icon.IconFontSwing;
import com.fpoly.utils.Auth;
import com.fpoly.utils.XImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SubjectForm extends javax.swing.JPanel {

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the sbj
     */
    public Subject getSbj() {
        return sbj;
    }

    /**
     * @param sbj the sbj to set
     */
    public void setSbj(Subject sbj) {
        this.sbj = sbj;
    }

    private SubjectDAO sbjDAO;
    private Subject sbj;
    private UnitsDAO unitDAO;
    private Units unit;
    private TheorryDAO theoryDAO;
    private Theory theory;
    private QuestionExerciseDAO quesDAO;
    private QuestionExercise ques;
    ExerciseForm exForm = new ExerciseForm();
     Congralulate congras = new Congralulate();
    private int index = 0;
    private String asw;
    private int point;
    private LearningProcessDAO lpDAO;
    private LearningProcess lpro;
    private UserDAO userDAO;

    public SubjectForm() {
        initComponents();
    }

    public void initCardData(Subject sbj) {
        Icon icon = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.FIBER_NEW, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card11.setData(new ModelCard1("Vocabulary", sbj.getSubjectName(), icon));
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EQUALIZER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card12.setData(new ModelCard1("Grammar", "Grammar skill", icon1));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.LIGHTBULB_OUTLINE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card13.setData(new ModelCard1("Word skill", "", icon2));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.STYLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card14.setData(new ModelCard1("Excercise", "Multiple choice", icon3));
    }

    public void setImage(String imageName) {
        String imageUrl = "/com/fpoly/icons/" + imageName;
        ImageIcon imgIcon = new ImageIcon(getClass().getResource(imageUrl));
        Image img = XImage.resize(imgIcon.getImage(), 600, 550);
        ImageIcon resizedIcon = new ImageIcon(img);
        lblImage.setIcon(resizedIcon);
    }

    public void addEventCard1(MouseListener event) {

        card11.addMouseListener(event);
    }

    public void addEventCard2(MouseListener event) {

        card12.addMouseListener(event);
    }

    public void addEventCard3(MouseListener event) {

        card13.addMouseListener(event);
    }

    public void addEventCard4(MouseListener event) {

        card14.addMouseListener(event);
    }

    public void addEventNext(ActionListener event) {
        btnNext.addActionListener(event);
    }

    public void addExFprm(int index) {
        int subjectID = this.getSbj().getSubjectID();
        exForm.initQuestionData(subjectID, index);
        jPanel2.remove(lblImage);
        jPanel2.repaint();
        jPanel2.revalidate();
        jPanel2.add(exForm);
        btnNext.setVisible(true);
        this.index = index;
    }

    public void addImage() {
        jPanel2.remove(exForm);
        jPanel2.add(lblImage);
        jPanel2.repaint();
        jPanel2.revalidate();
        btnNext.setVisible(false);
    }

    public void getAsw1() {
        exForm.addEvent1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asw = e.getActionCommand();
                checkAsw(asw);
                exForm.setEnableAll(false);
                exForm.colorChange(asw);
                checkFinish();
            }
        });
    }

    public void getAsw2() {
        exForm.addEvent2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asw = e.getActionCommand();
                checkAsw(asw);
                exForm.setEnableAll(false);
                exForm.colorChange(asw);
                checkFinish();
            }
        });
    }

    public void getAsw3() {
        exForm.addEvent3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asw = e.getActionCommand();
                checkAsw(asw);
                exForm.setEnableAll(false);
                exForm.colorChange(asw);
                checkFinish();
            }
        });
    }

    public void getAsw4() {
        exForm.addEvent4(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                asw = e.getActionCommand();
                checkAsw(asw);
                exForm.setEnableAll(false);
                exForm.colorChange(asw);
                checkFinish();
            }
        });

    }

    public void checkAsw(String asw) {
        quesDAO = new QuestionExerciseDAO();
        int subjectID = this.getSbj().getSubjectID();
        List<QuestionExercise> list = quesDAO.selectBySubjectID(subjectID);
        if (list.get(index).getAswR().equals(asw)) {
            point += list.get(index).getPoint();
        }
    }

    public void updatePoint() {
        quesDAO = new QuestionExerciseDAO();
        lpDAO = new LearningProcessDAO();
        sbjDAO = new SubjectDAO();
        userDAO = new UserDAO();
        
        int subjectID = this.getSbj().getSubjectID();
        Subject subject = sbjDAO.selectByIDInt(subjectID);
        List<QuestionExercise> list = quesDAO.selectBySubjectID(subjectID);
        int userID = Auth.acc.getID();
        User us = userDAO.selectByAccountID(userID);
        int coin = point * 2;
        int totalCoin = us.getCoin()+coin;
        Date leanringDate = new Date(System.currentTimeMillis());
        boolean status;
        if (point >= subject.getPassingPint()) {
            List<LearningProcess> listPass = lpDAO.checkPass(subjectID, userID);
            if(listPass.size() == 0) {
                status = true;
                User user = new User(userID, totalCoin);
                userDAO.updateCoin(user);
                System.out.println(totalCoin);
            } else {
                status = false;
            }

        } else {
            status = false;
        }
        lpro = new LearningProcess(userID, subjectID, point, leanringDate, status);
        lpDAO.insert(lpro);
        jPanel2.removeAll();
        congras.updateLabel(point, subject.getPassingPint());
        jPanel2.add(congras);
        jPanel2.repaint();
        jPanel2.revalidate();
    }

    public void checkFinish() {
        quesDAO = new QuestionExerciseDAO();
        int subjectID = this.getSbj().getSubjectID();
        List<QuestionExercise> list = quesDAO.selectBySubjectID(subjectID);
        if (index == (list.size() - 1)) {
            btnNext.setText("Finish");
            btnNext.setSize(new Dimension(300, 50));
            btnNext.setBackground(new Color(255, 224, 0));
            btnNext.setForeground(new Color(121, 159, 12));
        }
    }

    public void setEnableButton(boolean enable) {
        exForm.setEnableAll(enable);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        card11 = new com.fpoly.components.Card1();
        card12 = new com.fpoly.components.Card1();
        card13 = new com.fpoly.components.Card1();
        card14 = new com.fpoly.components.Card1();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnNext = new com.fpoly.swing.ButtonOutLine();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(4, 0));

        card11.setBackground(new java.awt.Color(252, 74, 26));
        card11.setColorGradient(new java.awt.Color(247, 183, 51));
        jPanel1.add(card11);

        card12.setBackground(new java.awt.Color(100, 43, 115));
        card12.setColorGradient(new java.awt.Color(198, 66, 110));
        jPanel1.add(card12);

        card13.setBackground(new java.awt.Color(54, 209, 220));
        card13.setColorGradient(new java.awt.Color(91, 134, 229));
        jPanel1.add(card13);

        card14.setBackground(new java.awt.Color(220, 227, 91));
        card14.setColorGradient(new java.awt.Color(69, 182, 73));
        jPanel1.add(card14);

        jSeparator1.setBackground(new java.awt.Color(17, 151, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout(0, 10));

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/camera_20px.png"))); // NOI18N
        lblImage.setPreferredSize(new java.awt.Dimension(650, 700));
        jPanel2.add(lblImage, java.awt.BorderLayout.CENTER);

        btnNext.setBackground(new java.awt.Color(15, 163, 64));
        btnNext.setForeground(new java.awt.Color(15, 163, 64));
        btnNext.setText("Next");
        btnNext.setMaximumSize(new java.awt.Dimension(25, 40));
        btnNext.setMinimumSize(new java.awt.Dimension(25, 40));
        btnNext.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel2.add(btnNext, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jSeparator1)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.ButtonOutLine btnNext;
    private com.fpoly.components.Card1 card11;
    private com.fpoly.components.Card1 card12;
    private com.fpoly.components.Card1 card13;
    private com.fpoly.components.Card1 card14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables
}
