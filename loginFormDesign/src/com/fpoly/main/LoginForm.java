package com.fpoly.main;

import com.fpoly.DAO.LoginAccountsDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.components.Message;
import com.fpoly.components.PanelCover;
import com.fpoly.components.PanelLoading;
import com.fpoly.components.PanelLoginAndRegister;
import com.fpoly.components.PanelVerifiCoce;
import com.fpoly.models.LoginAccounts;
import com.fpoly.models.ModelMessage;
import com.fpoly.models.User;
import com.fpoly.swing.ButtonOutLine;
import com.fpoly.utils.XEmail;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author nxlin
 */
public class LoginForm extends javax.swing.JFrame {

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister loginAndRegister;
    private PanelVerifiCoce panelVerifiCoce;
    private PanelLoading loeading;
    private ButtonOutLine exited;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 50;
    private final double loginSize = 50;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private LoginAccountsDAO lgDAO;
    private UserDAO userDAO;
    private User user;
    private LoginAccounts account;
    private Main main;

    public LoginForm() {
        initComponents();
        init();
    }

    private void init() {
        this.setBackground(new Color(0, 0, 0, 0));
        lgDAO = new LoginAccountsDAO();
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loeading = new PanelLoading();
        panelVerifiCoce = new PanelVerifiCoce();
        exited = new ButtonOutLine();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        };

        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        };
        loginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin);

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }

        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        bg.setLayout(layout);
        bg.setLayer(loeading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(panelVerifiCoce, JLayeredPane.POPUP_LAYER);
        bg.add(loeading, "pos 0 0 100% 100%");
        bg.add(panelVerifiCoce, "pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos 1al 0 n 100%");
        exited.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/close_20px.png")));
        exited.setBorder(new EmptyBorder(6, 6, 6, 6));
        exited.setBackground(new Color(255, 255, 255, 0));
        bg.add(exited, "pos 1al 0 n", 0);
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        LoginForm this1 = this;
        exited.addActionListener((e) -> {
            this1.setVisible(false);
        });

        panelVerifiCoce.addEventButtonOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lgDAO = new LoginAccountsDAO();
                account = loginAndRegister.getAcc();
                LoginAccounts accountGetSQL = lgDAO.selectByTK(account.getEmail());
                int id = accountGetSQL.getID();
                int code = accountGetSQL.getVetifyCode();
                try {
                    if (lgDAO.verufyCodeWithUser(id, code)) {
                        lgDAO.updateVerifyCode(accountGetSQL.getID());
                        showMessage(Message.MessageType.SUCCESS, "Register Success");
                        panelVerifiCoce.setVisible(false);
                    } else {
                        showMessage(Message.MessageType.ERROR, "Verify Code Incorrect");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    showMessage(Message.MessageType.ERROR, "Error");
                }
            }
        });
    }

    private void register() {
        lgDAO = new LoginAccountsDAO();
        userDAO = new UserDAO();
        account = loginAndRegister.getAcc();
        LoginAccounts newAcount;
        if (account.getEmail().equals("") || account.getUsername().equals("") || account.getPassword().equals("")) {
            showMessage(Message.MessageType.ERROR, "Enter your info please!");
        } else {
            if (lgDAO.checkEmail(account.getEmail()) == false) {
                showMessage(Message.MessageType.ERROR, "Email already exit");
            } else {
                try {

                    lgDAO.insert(account);
                    newAcount = lgDAO.selectByTK(account.getEmail());
                    sendEmail(newAcount);
                    user = new User(newAcount.getID(), newAcount.getUsername(), newAcount.getEmail());
                    userDAO.insert(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void sendEmail(LoginAccounts acc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                loeading.setVisible(true);
//                System.out.println(acc.getVetifyCode());
                ModelMessage ms = new XEmail().sendMain(acc.getEmail(), acc.getVetifyCode());
                if (ms.isSuccess()) {
                    loeading.setVisible(false);
                    panelVerifiCoce.setVisible(true);
                } else {
                    loeading.setVisible(false);
                    showMessage(Message.MessageType.ERROR, ms.getMessage());
                }
            }
        }).start();
    }

    private void login() {
        main = new Main();
        lgDAO = new LoginAccountsDAO();
        LoginAccounts acc = loginAndRegister.getAcc();
        LoginAccounts accountInSQL = lgDAO.selectByTK(acc.getEmail());
        if (accountInSQL == null) {
            showMessage(Message.MessageType.ERROR, "Email or Password incorrect");
        } else {
            if (!acc.getPassword().equals(accountInSQL.getPassword())) {
                showMessage(Message.MessageType.ERROR, "Password incorrect");
            } else {
                showMessage(Message.MessageType.SUCCESS, "Login Success");
                loeading.setVisible(true);
                LoginForm this1 = this;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            loeading.setVisible(false);
                            this1.dispose();
                            main.setVisible(true);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        }
    }

    private void showMessage(Message.MessageType messageType, String message) {
        Message ms = new Message();
        ms.showMessage(messageType, message);

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    bg.add(ms, "pos 0.5al -30", 0);
                    ms.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    bg.remove(ms);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    ms.setShow(true);
                }
            }

        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    animator.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 840));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1144, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
