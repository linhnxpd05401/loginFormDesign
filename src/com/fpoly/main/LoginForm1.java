
package com.fpoly.main;

import com.fpoly.DAO.AccountsDAO;
import com.fpoly.DAO.UserDAO;
import com.fpoly.components.Message;
import com.fpoly.components.PanelCover;
import com.fpoly.components.PanelLoading;
import com.fpoly.components.PanelLoginAndRegister;
import com.fpoly.components.PanelVerifiCoce;
import com.fpoly.models.Accounts;
import com.fpoly.models.ModelMessage;
import com.fpoly.models.User;
import com.fpoly.swing.ButtonOutLine;
import com.fpoly.utils.Auth;
import com.fpoly.utils.XEmail;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
public class LoginForm1 extends javax.swing.JDialog {

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
    private AccountsDAO lgDAO;
    private UserDAO userDAO;
    private User user;
    private Accounts account;

    public LoginForm1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }
    
    private void init() {

        this.setBackground(new Color(0, 0, 0, 0));
        lgDAO = new AccountsDAO();
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
        LoginForm1 this1 = this;
        exited.addActionListener((e) -> {
            System.exit(0);
        });

        panelVerifiCoce.addEventButtonOK(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lgDAO = new AccountsDAO();
                account = loginAndRegister.getAcc();
                Accounts accountGetSQL = lgDAO.selectByTK(account.getEmail());
                int id = accountGetSQL.getID();
                String code = accountGetSQL.getVetifyCode();
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
        lgDAO = new AccountsDAO();
        userDAO = new UserDAO();
        account = loginAndRegister.getAcc();
        Accounts newAcount;
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
                    user = new User(newAcount.getID(), account.getUsername(), newAcount.getEmail());
                    userDAO.insert(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void sendEmail(Accounts acc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                loeading.setVisible(true);
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
        lgDAO = new AccountsDAO();
        Accounts acc = loginAndRegister.getAcc();
        Accounts accountInSQL = lgDAO.selectByTK(acc.getEmail());
        if (accountInSQL == null) {
            showMessage(Message.MessageType.ERROR, "Email or Password incorrect");
        } else {
            if (!acc.getPassword().equals(accountInSQL.getPassword())) {
                showMessage(Message.MessageType.ERROR, "Password incorrect");
            } else {
                showMessage(Message.MessageType.SUCCESS, "Login Success");
                loeading.setVisible(true);
               
                LoginForm1 this1 = this;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            loeading.setVisible(false);
                            Auth.acc = lgDAO.selectByTK(acc.getEmail() );
                            this1.dispose();
                            new Main().setVisible(true);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ParseException ex) {
                            Logger.getLogger(LoginForm1.class.getName()).log(Level.SEVERE, null, ex);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1241, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


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
            java.util.logging.Logger.getLogger(LoginForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginForm1 dialog = new LoginForm1(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
