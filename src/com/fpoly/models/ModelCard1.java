package com.fpoly.models;

import javax.swing.Icon;

public class ModelCard1 {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(double values) {
        this.description = description;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public ModelCard1(String title, String description, Icon icon) {
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

    public ModelCard1() {
    }

    private String title;
    private String description;
    private Icon icon;
}
