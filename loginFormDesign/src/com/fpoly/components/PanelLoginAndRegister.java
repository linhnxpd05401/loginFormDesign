/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.components;

import com.fpoly.models.LoginAccounts;

import com.fpoly.swing.Button;
import com.fpoly.swing.MyPasswordField;
import com.fpoly.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author nxlin
 */
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    /**
     * @return the user
     */
//    public User getUser() {
//        return user;
//    }

//    private User user;
    private LoginAccounts acc;

    public PanelLoginAndRegister(ActionListener eventregister, ActionListener eventLogin) {
        initComponents();
        initLogin(eventLogin);
        initRegister(eventregister);
        login.setVisible(false);
        register.setVisible(true);

    }

    private void initRegister(ActionListener eventregister) {
        register.setLayout(new MigLayout("wrap", "push[Center]push", "push[]15[]10[]10[]20[]push"));
//        JLabel icon = new JLabel();
//        icon.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/rsz_1pngegg_3.png")));
//        register.add(icon);
        JLabel label = new JLabel("Create A New Account");
        label.setFont(new Font("sansserif", 1, 40));
        label.setForeground(new Color(45, 133, 115));
        register.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/user.png")));
        txtUser.setHint("Name");
        register.add(txtUser, "w 70%, h 50");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 70%, h 50");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 70%, h 50");
        Button cmd = new Button();
        cmd.setBackground(new Color(45, 133, 115));
        cmd.setForeground(new Color(248, 255, 174));
        cmd.addActionListener(eventregister);
        cmd.setText("Create Account");
        cmd.setFont(new Font("sansserif", 1, 18));
        register.add(cmd, "w 60%, h 50");
        cmd.addActionListener((ActionEvent e) -> {
            String userName = txtUser.getText().trim();
            String email = txtEmail.getText().trim();
            String pass = String.valueOf(txtPass.getPassword());
            acc = new LoginAccounts(userName, email, pass);
        });
    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[Center]push", "push[]25[]10[]10[]10[]25[]push"));
//        JLabel icon = new JLabel();
//        icon.setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/rsz_1pngegg_3.png")));
//        login.add(icon);
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 40));
        label.setForeground(new Color(45, 133, 115));
        login.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 70%, h 50");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 70%, h 50");
        JButton cmdForgot = new JButton("Forget your password?");
        cmdForgot.setForeground(new Color(5, 117, 230));
        cmdForgot.setFont(new Font("sansserif", 1, 15));
        cmdForgot.setContentAreaFilled(false);
        cmdForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForgot);
        Button cmd = new Button();
        cmd.setBackground(new Color(45, 133, 115));
        cmd.setForeground(new Color(248, 255, 174));
        cmd.setText("Sign In");
        cmd.setFont(new Font("sansserif", 1, 18));
        cmd.addActionListener(eventLogin);
        login.add(cmd, "w 60%, h 50");
        cmd.addActionListener((ActionEvent e) -> {
            String userName = txtEmail.getText().trim();
            String pass = String.valueOf(txtPass.getPassword());
            acc = new LoginAccounts(userName, pass);
        });
    }
    
    public  LoginAccounts getAcc() {
        return acc;
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
