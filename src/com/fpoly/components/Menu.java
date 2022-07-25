package com.fpoly.components;

import com.fpoly.DAO.SubjectDAO;
import com.fpoly.event.EventMenu;
import com.fpoly.event.EventMenuSelected;
import com.fpoly.event.EventShowPopupMenu;
import com.fpoly.models.ModelMenu;
import com.fpoly.models.Subject;
import com.fpoly.swing.MenuAnimation;
import com.fpoly.swing.MenuItem;
import com.fpoly.swing.scrollbar.ScrollBarCustom;
import com.fpoly.utils.Auth;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {

    /**
     * @return the showMenu
     */
    public boolean isShowMenu() {
        return showMenu;
    }

    /**
     * @param event the event to set
     */
    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }
    
    public void addLogOutEvent(ActionListener event) {
        btnLogOut.addActionListener(event);
    }

    /**
     * @param enableMenu the enableMenu to set
     */
    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    /**
     * @param showMenu the showMenu to set
     */
    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    /**
     * @param eventShowPopUp the eventShowPopUp to set
     */
    public void addEventShowPopUp(EventShowPopupMenu eventShowPopUp) {
        this.eventShowPopUp = eventShowPopUp;
    }

    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopUp;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    private SubjectDAO sbjDAO;
    private Subject sbj;
    
    
    public String[] getSubmenu() {
        sbjDAO = new SubjectDAO();
        List<Subject> list = sbjDAO.selectAll();
        String[] SubjectArray = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            String name = list.get(i).getSubjectName();
            SubjectArray[i] =  name;
        }
        return SubjectArray;
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.setBorder(null);
        sp.getInsets().set(0, 0, 0, 0);
        sp.setViewportBorder(null);
        sp.getViewport().setBorder(null);
        sp.getViewport().getInsets().set(0, 0, 0, 0);
        layout = new MigLayout("wrap , fillx, insets 0", "[fill]", "[]0[]0[]");
        panel.setLayout(layout);
    }

     public void initMenuItem() {
        if (Auth.isAdmin()) {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/fpoly/icons/user_secured_20px.png")), "My Info", "Update My Info", "Change password"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/fpoly/icons/elective_20px.png")), "Subjects", getSubmenu()));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/fpoly/icons/3.png")), "Test", "Testing", "Ranking"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/fpoly/icons/3.png")), "Management", "Create Test", "Create Subject", "List"));
        } else {
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/fpoly/icons/user_secured_20px.png")), "My Info", "Update My Info", "Change password", "Delete Account"));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/fpoly/icons/elective_20px.png")), "Subjects", getSubmenu()));
            addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/fpoly/icons/3.png")), "Test", "Testing"));
        }

    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopUp.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideAllMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    
    public void addExitEvent(ActionListener event) {
        btnExit.addActionListener(event);
    }
    
    public void addHomeEvent(MouseAdapter event) {
        profile1.addMouseListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile1 = new com.fpoly.components.Profile();
        btnExit = new com.fpoly.swing.button2();
        btnLogOut = new com.fpoly.swing.button2();

        setPreferredSize(new java.awt.Dimension(230, 230));

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        btnExit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/shutdown_20px.png"))); // NOI18N
        btnExit.setText("        Exit");
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExit.setIconTextGap(5);

        btnLogOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/icons/logout_20px.png"))); // NOI18N
        btnLogOut.setText("        Log out");
        btnLogOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogOut.setIconTextGap(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(profile1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(67, 198, 172), getWidth(), -120, new Color(248, 255, 174));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.fpoly.swing.button2 btnExit;
    private com.fpoly.swing.button2 btnLogOut;
    private javax.swing.JPanel panel;
    private com.fpoly.components.Profile profile1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
