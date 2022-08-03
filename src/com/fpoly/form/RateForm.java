/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpoly.form;

import com.fpoly.DAO.RateDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.dialog.MessageDialog;
import com.fpoly.models.Rate;
import com.fpoly.swing.RateLog;
import com.fpoly.swing.scrollbar.ScrollBarCustom;
import com.fpoly.utils.Auth;
import com.fpoly.utils.XValidate;
import java.awt.event.MouseAdapter;
import java.sql.JDBCType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;

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
        initProGress();
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
    
    void ClearRateLog(){
        CardContainer.removeAll();
        CardContainer.repaint();
        CardContainer.revalidate();
    }
    
    void initProGress() {
        RateDAO rtDAO = new RateDAO();
        int FiveStar = rtDAO.countStar(5);
        int FourStar = rtDAO.countStar(4);
        int ThreeStar = rtDAO.countStar(3);
        int TwoStar = rtDAO.countStar(2);
        int OneStar = rtDAO.countStar(1);
        int sum = FiveStar + FourStar + ThreeStar + TwoStar + OneStar;
//        System.out.println(sum);
        float FivePernt = Math.round(((1.0) * FiveStar / sum) * 100);
        float FourPercent = Math.round(((1.0) * FourStar / sum) * 100);
        float ThreePercent = Math.round(((1.0) * ThreeStar / sum) * 100);
        float TwoPercent = Math.round(((1.0) * TwoStar / sum) * 100);
        float OnePercent = Math.round(((1.0) * OneStar / sum) * 100);
        //System.out.println(FivePernt);
        prg5Star.setValue((int) FivePernt);
        prg4Star.setValue((int) FourPercent);
        prg3Star.setValue((int) ThreePercent);
        prg2Star.setValue((int) TwoPercent);
        prg1Star.setValue((int) OnePercent);

        /*
            3 lượt 4 sao - 0.1 sao tổng 
            1 lượt 5 sao =  0.1 sao tổng
            2 lượt 3 sao - 0.1 sao tổng
           1  lượt 2 sao - 0.2 sao tổng
            1 lượt 1 sao - 0.3 sao tổng
         */
        double OvrallRate = 5;
        OvrallRate = 5 + (FiveStar * (0.1)) - ((FourStar / 2) * (0.2)) - ((ThreeStar / 1) * (0.2)) - (TwoStar * (0.3)) - (OneStar * (0.4));
        double roundOff = Math.round(OvrallRate * 100) / 100;
        if (roundOff > 5) {
            roundOff = 5;
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
        }
        if (roundOff >= 4.5 && roundOff < 5) {
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_half_20px.png")));
        }
        if (roundOff >= 4 && roundOff < 4.5) {
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
        }
        if (roundOff >= 3.5 && roundOff < 4) {
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_half_20px.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
        }
        if (roundOff >= 3 && roundOff < 3.5) {
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
        }
        if (roundOff >= 2.5 && roundOff < 3) {
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_half_20px.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
        }
        if (roundOff >= 2 && roundOff < 2.5) {
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
        }
        if (roundOff >= 1.5 && roundOff < 2) {
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_half_20px.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
        }
        if (roundOff >= 1 && roundOff < 1.5) {
            lbl1StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_1.png")));
            lbl2StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl3StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl4StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
            lbl5StarOverall.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_20px_4.png")));
        }
        
        lblOveralStar.setText(String.valueOf(roundOff));
        
    }
    
    int Star;
    
    void starColor1() {
        Star = 1;
        final ScheduledExecutorService svc = Executors.newScheduledThreadPool(1);
        svc.schedule(new Runnable() {
            @Override
            public void run() {
                btn1Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn2Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn3Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn4Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn5Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
            }
            
        }, 1, TimeUnit.MICROSECONDS);
    }
    
    void starColor2() {
        Star = 2;
        final ScheduledExecutorService svc = Executors.newScheduledThreadPool(1);
        svc.schedule(new Runnable() {
            @Override
            public void run() {
                btn1Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn2Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn3Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn4Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn5Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
            }
            
        }, 1, TimeUnit.MICROSECONDS);
    }
    
    void starColor3() {
        Star = 3;
        final ScheduledExecutorService svc = Executors.newScheduledThreadPool(1);
        svc.schedule(new Runnable() {
            @Override
            public void run() {
                btn1Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn2Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn3Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn4Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn5Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                
            }
            
        }, 1, TimeUnit.MICROSECONDS);
    }
    
    void starColor4() {
        Star = 4;
        final ScheduledExecutorService svc = Executors.newScheduledThreadPool(1);
        svc.schedule(new Runnable() {
            @Override
            public void run() {
                btn1Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn2Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn3Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn4Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn5Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
            }
            
        }, 1, TimeUnit.MICROSECONDS);
    }
    
    void starColor5() {
        Star = 5;
        final ScheduledExecutorService svc = Executors.newScheduledThreadPool(1);
        svc.schedule(new Runnable() {
            @Override
            public void run() {
                btn1Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn2Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn3Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn4Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
                btn5Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px.png")));
            }
            
        }, 1, TimeUnit.MICROSECONDS);
    }
    
    void starColorOrigin() {
        
        final ScheduledExecutorService svc = Executors.newScheduledThreadPool(1);
        svc.schedule(new Runnable() {
            @Override
            public void run() {
                btn1Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn2Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn3Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn4Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
                btn5Star.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png")));
            }
            
        }, 1, TimeUnit.MICROSECONDS);
        
    }
    
    Rate setData() {
        Date dt = new Date();
        Rate rt = new Rate();
        UserDAO userDAO = new UserDAO();
        int usID = userDAO.selectByAccountID(Auth.acc.getID()).getUserID();
        rt.setStar(Star);
        rt.setComment(txtComment.getText());
        rt.setUserID(usID);
        rt.setDate(dt);
        return rt;
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtComment = new com.fpoly.swing.MyTextField();
        btnRate = new com.fpoly.swing.Button();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        StarRate = new javax.swing.JPanel();
        StarHover = new javax.swing.JPanel();
        btn1Star = new javax.swing.JButton();
        btn2Star = new javax.swing.JButton();
        btn3Star = new javax.swing.JButton();
        btn4Star = new javax.swing.JButton();
        btn5Star = new javax.swing.JButton();
        sp = new javax.swing.JScrollPane();
        CardContainer = new javax.swing.JPanel();

        panelOverall.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("RATING OVERVIEW");

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

        prg5Star.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 91, 3)));
        prg5Star.setForeground(new java.awt.Color(0, 204, 51));
        prg5Star.setString("");

        prg4Star.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 91, 3)));
        prg4Star.setForeground(new java.awt.Color(0, 204, 51));
        prg4Star.setString("");

        prg3Star.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 91, 3)));
        prg3Star.setForeground(new java.awt.Color(0, 204, 51));
        prg3Star.setString("");

        prg2Star.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 91, 3)));
        prg2Star.setForeground(new java.awt.Color(0, 204, 51));
        prg2Star.setString("");

        prg1Star.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(3, 91, 3)));
        prg1Star.setForeground(new java.awt.Color(0, 204, 51));
        prg1Star.setString("");

        panelRate.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("PLEASE RATE FOR US TO HAVE MORE MOTIVATION :");

        jLabel14.setText("LEAVE YOUR OPTIONS AND COMMENT HERE :");

        btnRate.setBackground(new java.awt.Color(204, 255, 204));
        btnRate.setForeground(new java.awt.Color(51, 153, 0));
        btnRate.setText("RATE");
        btnRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRateActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Thanks for always using our app ! More help please contact :");

        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("HotLine : 0333333333");

        jLabel17.setForeground(new java.awt.Color(51, 51, 255));
        jLabel17.setText("Gmail : quanthpd05478@fpt.edu.vn");

        StarRate.setLayout(new java.awt.CardLayout());

        StarHover.setBackground(new java.awt.Color(255, 255, 255));

        btn1Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn1Star.setBorderPainted(false);
        btn1Star.setContentAreaFilled(false);
        btn1Star.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1StarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn1StarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn1StarMouseExited(evt);
            }
        });

        btn2Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn2Star.setBorderPainted(false);
        btn2Star.setContentAreaFilled(false);
        btn2Star.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2StarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn2StarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn2StarMouseExited(evt);
            }
        });

        btn3Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn3Star.setBorderPainted(false);
        btn3Star.setContentAreaFilled(false);
        btn3Star.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3StarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn3StarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn3StarMouseExited(evt);
            }
        });

        btn4Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn4Star.setBorderPainted(false);
        btn4Star.setContentAreaFilled(false);
        btn4Star.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4StarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn4StarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn4StarMouseExited(evt);
            }
        });

        btn5Star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_star_40px_1.png"))); // NOI18N
        btn5Star.setBorderPainted(false);
        btn5Star.setContentAreaFilled(false);
        btn5Star.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5StarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn5StarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn5StarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout StarHoverLayout = new javax.swing.GroupLayout(StarHover);
        StarHover.setLayout(StarHoverLayout);
        StarHoverLayout.setHorizontalGroup(
            StarHoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StarHoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn1Star, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn2Star, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btn3Star, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btn4Star, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn5Star, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        StarHoverLayout.setVerticalGroup(
            StarHoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StarHoverLayout.createSequentialGroup()
                .addGroup(StarHoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn1Star)
                    .addComponent(btn2Star)
                    .addComponent(btn3Star)
                    .addComponent(btn4Star)
                    .addComponent(btn5Star))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StarRate.add(StarHover, "card2");

        javax.swing.GroupLayout panelRateLayout = new javax.swing.GroupLayout(panelRate);
        panelRate.setLayout(panelRateLayout);
        panelRateLayout.setHorizontalGroup(
            panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StarRate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRateLayout.createSequentialGroup()
                .addGroup(panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRateLayout.setVerticalGroup(
            panelRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRateLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StarRate, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtComment, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(1, 1, 1)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(23, 23, 23)
                .addComponent(btnRate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(8, 8, 8)
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelOverallLayout.createSequentialGroup()
                                .addComponent(lbl1StarOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl2StarOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl3StarOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl4StarOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(lbl5StarOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelOverallLayout.createSequentialGroup()
                                .addComponent(lblOveralStar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(13, 13, 13)))
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10)
                        .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prg2Star, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(prg3Star, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prg4Star, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prg5Star, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prg1Star, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(panelRate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOverallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(prg1Star, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl1StarOverall)
                    .addComponent(lbl2StarOverall)
                    .addComponent(lbl3StarOverall)
                    .addComponent(lbl4StarOverall)
                    .addComponent(lbl5StarOverall))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOverall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        CardContainer.setBackground(new java.awt.Color(255, 255, 255));
        CardContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        CardContainer.setLayout(new java.awt.GridLayout(9999, 1, 5, 5));
        sp.setViewportView(CardContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn1StarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1StarMouseEntered
//        starColor1();
    }//GEN-LAST:event_btn1StarMouseEntered

    private void btn2StarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2StarMouseEntered
//        starColor2();
    }//GEN-LAST:event_btn2StarMouseEntered

    private void btn3StarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3StarMouseEntered
//        starColor3();
    }//GEN-LAST:event_btn3StarMouseEntered

    private void btn4StarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4StarMouseEntered
//        starColor4();
    }//GEN-LAST:event_btn4StarMouseEntered

    private void btn5StarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5StarMouseEntered
//        starColor5();
    }//GEN-LAST:event_btn5StarMouseEntered

    private void btn1StarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1StarMouseExited
//        starColorOrigin();
    }//GEN-LAST:event_btn1StarMouseExited

    private void btn2StarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2StarMouseExited
//        starColorOrigin();
    }//GEN-LAST:event_btn2StarMouseExited

    private void btn3StarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3StarMouseExited
//        starColorOrigin();
    }//GEN-LAST:event_btn3StarMouseExited

    private void btn4StarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4StarMouseExited
//        starColorOrigin();
    }//GEN-LAST:event_btn4StarMouseExited

    private void btn5StarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5StarMouseExited
        // starColorOrigin();
    }//GEN-LAST:event_btn5StarMouseExited

    private void btn1StarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1StarMouseClicked
        starColor1();
    }//GEN-LAST:event_btn1StarMouseClicked

    private void btn2StarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2StarMouseClicked
        starColor2();
    }//GEN-LAST:event_btn2StarMouseClicked

    private void btn3StarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3StarMouseClicked
        starColor3();
    }//GEN-LAST:event_btn3StarMouseClicked

    private void btn4StarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4StarMouseClicked
        starColor4();
    }//GEN-LAST:event_btn4StarMouseClicked

    private void btn5StarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5StarMouseClicked
        starColor5();
    }//GEN-LAST:event_btn5StarMouseClicked

    private void btnRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRateActionPerformed
        RateDAO rateDAO = new RateDAO();
        Rate rt = setData();
        if (Star > 0
                && XValidate.checkNullText(txtComment)) {
            rateDAO.insert(rt);
            starColorOrigin();
            ClearRateLog();
            Init();
            initProGress();
        }
    }//GEN-LAST:event_btnRateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardContainer;
    private javax.swing.JPanel StarHover;
    private javax.swing.JPanel StarRate;
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
