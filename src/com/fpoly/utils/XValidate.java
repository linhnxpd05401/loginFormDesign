/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpoly.utils;

import com.fpoly.dialog.MessageDialog;
import com.fpoly.main.Main;
import javax.swing.JTextField;
import com.fpoly.DAO.TestDAO;
import java.util.regex.Pattern;
import javax.swing.JTextArea;

/**
 *
 * @author bimzc
 */
public class XValidate {

    public static boolean checkEmpty(JTextField field, String Mess) {
        if (field.equals("")) {
            MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
            mess.showMessage(MessageDialog.MessageType.INFORMATION, Mess);
            field.grabFocus();
            return true;
        }
        return false;
    }
    
    public static boolean checkNullText(JTextField txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
            mess.showMessage(MessageDialog.MessageType.INFORMATION, "Please input" + txt.getName());
            txt.grabFocus();
            return false;
        }
    }
    
    public static boolean checkNullTextAr(JTextArea txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
            mess.showMessage(MessageDialog.MessageType.INFORMATION, "Please input" + txt.getName());
            txt.grabFocus();
            return false;
        }
    }

    public static boolean checkTestID(JTextField field) {
        TestDAO tsDAO = new TestDAO();
        if (tsDAO.SELECT_BY_ID(Integer.parseInt(field.getText())) == null) {
            MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
            mess.showMessage(MessageDialog.MessageType.INFORMATION, "Their is no test to insert ,please check Test Number !.");
            field.grabFocus();
            return false;
        }
        return true;
    }
    
    public static boolean isNumber(JTextField field){
        String regx = "[0-9]+";
        Pattern pt = Pattern.compile(regx);
        pt = Pattern.compile("\\d+");
        if (pt.matcher(field.getText()).matches()==false) {
            MessageDialog mess = new MessageDialog(Main.getFrames()[0], true);
            mess.showMessage(MessageDialog.MessageType.INFORMATION, "Must be a number !.");
            field.grabFocus();
            return false;
        }
        return true;
    }
}
