package com.fpoly.models;

import com.fpoly.swing.table.EventAction;
import com.fpoly.swing.table.ModelAction;
import com.fpoly.swing.table.ModelProfile;
import java.text.DecimalFormat;
import javax.swing.Icon;

public class ModelStudent {

    /**
     * @return the coin
     */
    public int getCoin() {
        return coin;
    }

    /**
     * @param coin the coin to set
     */
    public void setCoin(int coin) {
        this.coin = coin;
    }



    public ModelStudent() {
    }

    public ModelStudent(Icon icon, String name, String mark, int coin, int rank) {
        this.icon = icon;
        this.name = name;
        this.mark = mark;
        this.coin = coin;
        this.rank = rank;
    }





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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    

    private Icon icon;
    private String name;
    private String mark;
    private int coin;
    private int rank;


    public Object[] toRowTable(EventAction event) {
        return new Object[]{new ModelProfile(icon, name), mark, coin, rank};
    }
}
