package com.fpoly.swing.progress;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar {

    private final ProgressCircleUI ui;

    public Progress() {
        setOpaque(false);
        setStringPainted(true);
        ui = new ProgressCircleUI();
        setUI(ui);
    }


    public String getString(int value) {
        return ((int) (value * ui.getAnimate())) + "%";
    }

    public void start() {
        ui.start();
    }
}
