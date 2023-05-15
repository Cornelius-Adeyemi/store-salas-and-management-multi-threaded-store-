package com.adebisi.interface_package;

import com.adebisi.customer.Customer;
import com.adebisi.customer.PurchaseProductAbstract;
import com.adebisi.enum_file.Availability;
import com.adebisi.store.Product;

import java.util.ArrayList;

public interface ICustomer {


     int getMoneyOwned();

     void setMoneyOwned(int moneyOwned);

     void setTotalCost(int totalCost);

    void setBuyChecker(boolean buyChecker);


     int getTotalCost() ;



   ArrayList<PurchaseProductAbstract> getCart();



    public void makePurchase() throws Exception;


    void addToCart(int productNumber, int quantity ) throws  Exception;



     void displayCartDetails();

    public void joinQueue() throws Exception;
}
