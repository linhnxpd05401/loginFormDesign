package com.fpoly.models;

import com.fpoly.swing.table.EventAction;
import com.fpoly.swing.table.ModelAction;
import com.fpoly.swing.table.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;

public class ModelStudent {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public ModelStudent(Icon icon, String name, String gender, String course, int fees) {
        this.icon = icon;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.fees = fees;
    }

    public ModelStudent() {
    }

    private Icon icon;
    private String name;
    private String gender;
    private String course;
    private int fees;

    public Object[] toRowTable(EventAction event) {
        return new Object[]{new ModelProfile(icon, name), gender, course, fees, new ModelAction(this, event)};
    }
}
