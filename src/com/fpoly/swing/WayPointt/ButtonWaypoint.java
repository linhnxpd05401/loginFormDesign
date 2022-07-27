package com.fpoly.swing.WayPointt;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonWaypoint extends JButton {

    public ButtonWaypoint() {
        setContentAreaFilled(false);
        setIcon(new ImageIcon(getClass().getResource("/com/fpoly/icons/icons8_home_address_30px.png")));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(30, 30));
    }
}
