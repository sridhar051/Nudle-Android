package com.intern.nudleapp;

public class TotalModel {

    private int totalitems;
    private String totalItemPrice,Deliveryprice,savedamount,totalamount;

    public TotalModel(String totalItemPrice, String deliveryprice, String totalamount, String savedamount) {
//        this.type = type;
//        this.totalitems = totalitems;
        this.totalItemPrice = totalItemPrice;
        Deliveryprice = deliveryprice;
        this.savedamount = savedamount;
        this.totalamount=totalamount;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

//    public int getTotalitems() {
//        return totalitems;
//    }
//
//    public void setTotalitems(int totalitems) {
//        this.totalitems = totalitems;
//    }

    public String getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(String totalamt) {
        this.totalItemPrice = totalamt;
    }

    public String getDeliveryprice() {
        return Deliveryprice;
    }

    public void setDeliveryprice(String deliveryprice) {
        Deliveryprice = deliveryprice;
    }

    public String getSavedamount() {
        return savedamount;
    }

    public void setSavedamount(String savedamount) {
        this.savedamount = savedamount;
    }
}
