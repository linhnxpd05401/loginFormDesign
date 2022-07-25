package com.fpoly.main;

import com.fpoly.DAO.QuestionExerciseDAO;
import com.fpoly.DAO.SubjectDAO;
import com.fpoly.DAO.TheorryDAO;
import com.fpoly.DAO.UnitsDAO;
import com.fpoly.components.Header;
import com.fpoly.components.Menu;
import com.fpoly.dialog.MessageDialog;
import com.fpoly.form.FormHome;
import com.fpoly.form.InsertTest;
import com.fpoly.form.MainForm;
import com.fpoly.form.RateForm;
import com.fpoly.form.SubjectForm;
import com.fpoly.form.TestForm;
import com.fpoly.form.UserUpdateFrom;
import com.fpoly.form.changePass;
import com.fpoly.models.QuestionExercise;
import com.fpoly.models.Subject;
import com.fpoly.models.Theory;
import com.fpoly.models.Units;
import com.fpoly.swing.MenuItem;
import com.fpoly.swing.PopUpMenu;
import com.fpoly.swing.icon.GoogleMaterialDesignIcons;
import com.fpoly.swing.icon.IconFontSwing;
import com.fpoly.utils.Auth;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author nxlin
 */
public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    private UserUpdateFrom updateForm;
    private SubjectDAO subjectDAO;
    private Subject subject;
    private UnitsDAO unitDAO;
    private TheorryDAO theoryDAO;
    int index = 0;

    public Main() throws ParseException {
        initComponents();
        init();

    }

    public void init() throws ParseException {
        subjectDAO = new SubjectDAO();
        theoryDAO = new TheorryDAO();
        unitDAO = new UnitsDAO();
        List<Subject> list = subjectDAO.selectAll();
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        main = new MainForm();
        header = new Header();
        updateForm = new UserUpdateFrom();
        menu.addEvent((int menuIndex, int subMenuIndex) -> {
            System.out.println("Menu Index: " + menuIndex + " Submenu Index: " + subMenuIndex);
            //Menu admin
            if (Auth.isAdmin()) {
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        main.showForm(updateForm);
                    } else if (subMenuIndex == 1) {
                        main.showForm(new changePass());
                    }
                }
                if (menuIndex == 1) {
                    for (int i = 0; i < list.size(); i++) {
                        if (subMenuIndex == i) {
                            SubjectForm sbjForm = new SubjectForm();
                            subject = list.get(i);
                            sbjForm.setSbj(subject);
                            sbjForm.initCardData(subject);
                            sbjForm.addImage();
                            sbjForm.setImage(list.get(i).getSubjectImage());
                            main.showForm(sbjForm);
                            if (!animator.isRunning()) {
                                animator.start();
                            }
                            menu.setEnableMenu(false);
                            if (menu.isShowMenu()) {
                                menu.hideAllMenu();
                            }
                            sbjForm.addEventCard1(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    List<Units> units = unitDAO.selectBySubjectId(subject.getSubjectID());
                                    List<Theory> theories = theoryDAO.selectByUnitID(units.get(0).getUnitID());
                                    String imageName = theories.get(0).getTheoruContent();
                                    sbjForm.addImage();
                                    sbjForm.setImage(imageName);
                                }
                            });
                            sbjForm.addEventCard2(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    List<Units> units = unitDAO.selectBySubjectId(subject.getSubjectID());
                                    List<Theory> theories = theoryDAO.selectByUnitID(units.get(1).getUnitID());
                                    String imageName = theories.get(0).getTheoruContent();
                                    sbjForm.addImage();
                                    sbjForm.setImage(imageName);

                                }
                            });
                            sbjForm.addEventCard3(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    List<Units> units = unitDAO.selectBySubjectId(subject.getSubjectID());
                                    List<Theory> theories = theoryDAO.selectByUnitID(units.get(2).getUnitID());
                                    String imageName = theories.get(0).getTheoruContent();
                                    sbjForm.addImage();
                                    sbjForm.setImage(imageName);
                                }

                            });

                            sbjForm.addEventCard4(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    sbjForm.addExFprm(index);
                                }
                            });

                            Main this1 = this;
                            sbjForm.addEventNext(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    QuestionExerciseDAO quesDAO = new QuestionExerciseDAO();
                                    List<QuestionExercise> list = quesDAO.selectBySubjectID(subject.getSubjectID());
                                    if (index == (list.size() - 1)) {
                                        sbjForm.updatePoint();
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                try {
                                                    Thread.sleep(2000);
                                                    main.removeAll();
                                                    main.add(new FormHome());
                                                } catch (InterruptedException ex) {
                                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                } catch (ParseException ex) {
                                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        }).start();
                                    } else if (index < (list.size() - 1)) {
                                        index++;
                                        sbjForm.addExFprm(index);
                                    }
                                    sbjForm.setEnableButton(true);

                                }
                            });
                            sbjForm.getAsw1();
                            sbjForm.getAsw2();
                            sbjForm.getAsw3();
                            sbjForm.getAsw4();
                        }
                    }
                }
                if (menuIndex == 2) {
                    if (subMenuIndex == 0) {
                        main.showForm(new TestForm());
                    }
                }
                if (menuIndex == 3) {
                    if (subMenuIndex == 0) {
                        main.showForm(new InsertTest());
                    }
                }
            } //Menu user
            else {
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        main.showForm(updateForm);
                    } else if (subMenuIndex == 1) {
                        main.showForm(new changePass());
                    } else if (subMenuIndex == 2) {
                        //Delete Account
                    }
                }
                if (menuIndex == 1) {
                    for (int i = 0; i < list.size(); i++) {
                        if (subMenuIndex == i) {
                            SubjectForm sbjForm = new SubjectForm();
                            subject = list.get(i);
                            sbjForm.setSbj(subject);
                            sbjForm.initCardData(subject);
                            sbjForm.addImage();
                            sbjForm.setImage(list.get(i).getSubjectImage());
                            main.showForm(sbjForm);
                            if (!animator.isRunning()) {
                                animator.start();
                            }
                            menu.setEnableMenu(false);
                            if (menu.isShowMenu()) {
                                menu.hideAllMenu();
                            }
                            sbjForm.addEventCard1(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    List<Units> units = unitDAO.selectBySubjectId(subject.getSubjectID());
                                    List<Theory> theories = theoryDAO.selectByUnitID(units.get(0).getUnitID());
                                    String imageName = theories.get(0).getTheoruContent();
                                    sbjForm.addImage();
                                    sbjForm.setImage(imageName);
                                }
                            });
                            sbjForm.addEventCard2(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    List<Units> units = unitDAO.selectBySubjectId(subject.getSubjectID());
                                    List<Theory> theories = theoryDAO.selectByUnitID(units.get(1).getUnitID());
                                    String imageName = theories.get(0).getTheoruContent();
                                    sbjForm.addImage();
                                    sbjForm.setImage(imageName);

                                }
                            });
                            sbjForm.addEventCard3(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    List<Units> units = unitDAO.selectBySubjectId(subject.getSubjectID());
                                    List<Theory> theories = theoryDAO.selectByUnitID(units.get(2).getUnitID());
                                    String imageName = theories.get(0).getTheoruContent();
                                    sbjForm.addImage();
                                    sbjForm.setImage(imageName);
                                }

                            });

                            sbjForm.addEventCard4(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    sbjForm.addExFprm(index);
                                }
                            });

                            Main this1 = this;
                            sbjForm.addEventNext(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    QuestionExerciseDAO quesDAO = new QuestionExerciseDAO();
                                    List<QuestionExercise> list = quesDAO.selectBySubjectID(subject.getSubjectID());
                                    if (index == (list.size() - 1)) {
                                        sbjForm.updatePoint();
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                try {
                                                    Thread.sleep(2000);
                                                    main.removeAll();
                                                    main.add(new FormHome());
                                                } catch (InterruptedException ex) {
                                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                } catch (ParseException ex) {
                                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        }).start();
                                    } else if (index < (list.size() - 1)) {
                                        index++;
                                        sbjForm.addExFprm(index);
                                    }
                                    sbjForm.setEnableButton(true);

                                }
                            });
                            sbjForm.getAsw1();
                            sbjForm.getAsw2();
                            sbjForm.getAsw3();
                            sbjForm.getAsw4();

                        }
                    }
                }
                if (menuIndex == 2) {
                    if (subMenuIndex == 0) {
                        main.showForm(new TestForm());
                    }
                }
            }

        });
        updateForm.addCancelEvent((ActionEvent e) -> {
            this.dispose();
            try {
                new Main().setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        menu.addLogOutEvent((ActionEvent e) -> {
            Auth.clear();
            this.dispose();
            new LoginForm1(this, true).setVisible(true);
        });
        menu.addExitEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
                mess.showMessage(MessageDialog.MessageType.QUESTION, "You really want to exit?");
                if (mess.isOk() == true) {
                    System.exit(0);
                }
            }
        });
        menu.addEventShowPopUp((Component com) -> {
            MenuItem item = (MenuItem) com;
            PopUpMenu popup = new PopUpMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
            int x1 = Main.this.getX() + 52;
            int y1 = Main.this.getY() + com.getY() + 86;
            popup.setLocation(x1, y1);
            popup.setVisible(true);
        });
        menu.addHomeEvent(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    main.showForm(new FormHome());
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        menu.initMenuItem();

        bg.add(menu, "w 300!, spany 2");
        bg.add(header, "h 50!, wrap, w 100%");
        header.addWebEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String url = "https://www.facebook.com/The-LEA-Academy-101254109350178";
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                        try {
                            desktop.browse(new URI(url));
                        } catch (URISyntaxException ex) {
                        } catch (IOException ex) {
                        }
                    }
            }

        });
        header.addRateEvent(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  main.showForm(new RateForm());
            }
        
        });
        
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (240 * (1f - fraction));
                } else {
                    width = 60 + (240 * fraction);

                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent((ActionEvent e) -> {
            if (!animator.isRunning()) {
                animator.start();
            }
            menu.setEnableMenu(false);
            if (menu.isShowMenu()) {
                menu.hideAllMenu();
            }
        });
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        main.showForm(new FormHome());
    }

    public void reload() throws ParseException {
        this.dispose();
        new Main().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1249, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables

}
