
package com.fpoly.models;

public class Top10 {
    private int userID;
    private String userName;
    private String image;
    private int totalMark;
    private int coin;
    
    public Top10() {
    }

    public Top10(int userID, String userName, String image, int totalMark, int coin) {
        this.userID = userID;
        this.userName = userName;
        this.image = image;
        this.totalMark = totalMark;
        this.coin = coin;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    
    


    
}
