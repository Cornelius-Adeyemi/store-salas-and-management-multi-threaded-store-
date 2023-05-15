package com.adebisi.customer;

public abstract class PurchaseProductAbstract {
    public String productName;
    public int quantitPurchase;
    public int unitPrice;
    public int index;
    public int totalPrice;

    PurchaseProductAbstract(String productName,int quantitPurchase, int totalCost, int unitPrice,int index){
        this.productName = productName;
        this.quantitPurchase = quantitPurchase;
        this.totalPrice = totalCost;
        this.unitPrice = unitPrice;
        this.index = index;
    }

}
