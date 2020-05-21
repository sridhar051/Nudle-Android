package com.intern.nudleapp.userAccount;

public class CartItemModel {
    public static final int CART_ITEM=0;
    public static final int TOTAL_AMT=1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    // cart item
    private int productImage;
    private String productTitle;
    private int freecoupons;
    private String productprice;
    private String cuttedprice;
    private int productquantity,offersapplied,couponsapplied;

    public CartItemModel(int type, int productImage, String productTitle, int freecoupons, String productprice, String cuttedprice, int productquantity, int offersapplied, int couponsapplied) {
        this.type = type;
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freecoupons = freecoupons;
        this.productprice = productprice;
        this.cuttedprice = cuttedprice;
        this.productquantity = productquantity;
        this.offersapplied = offersapplied;
        this.couponsapplied = couponsapplied;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreecoupons() {
        return freecoupons;
    }

    public void setFreecoupons(int freecoupons) {
        this.freecoupons = freecoupons;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getCuttedprice() {
        return cuttedprice;
    }

    public void setCuttedprice(String cuttedprice) {
        this.cuttedprice = cuttedprice;
    }

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }

    public int getOffersapplied() {
        return offersapplied;
    }

    public void setOffersapplied(int offersapplied) {
        this.offersapplied = offersapplied;
    }

    public int getCouponsapplied() {
        return couponsapplied;
    }

    public void setCouponsapplied(int couponsapplied) {
        this.couponsapplied = couponsapplied;
    }
    //cart item
    //cart total
    private String  totalitems;
    private String totalItemPrice,Deliveryprice,savedamount,totalamount;

    public CartItemModel(int type, String totalitems, String totalItemPriceo, String deliveryprice,String totalamount, String savedamount) {
        this.type = type;
        this.totalitems = totalitems;
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

    public String getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(String totalitems) {
        this.totalitems = totalitems;
    }

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
//cart total
}
