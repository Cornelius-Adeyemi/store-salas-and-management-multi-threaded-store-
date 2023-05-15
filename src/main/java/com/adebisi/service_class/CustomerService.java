package com.adebisi.service_class;

import com.adebisi.customer.Customer;
import com.adebisi.customer.PurchaseProductAbstract;
import com.adebisi.interface_package.ICustomer;
import com.adebisi.interface_package.IPurchaseProduct;

import java.util.ArrayList;

public class CustomerService implements ICustomer {

    Customer customer;
    public CustomerService(Customer customer){
        this.customer = customer;
    }
    @Override
    public int getMoneyOwned() {
        return customer.getMoneyOwned();
    }

    @Override
    public void setMoneyOwned(int moneyOwned) {
         customer.setMoneyOwned(moneyOwned);
    }

    @Override
    public void setTotalCost(int totalCost) {
        customer.setTotalCost(totalCost);
    }

    @Override
    public void setBuyChecker(boolean buyChecker) {
      customer.setBuyChecker(buyChecker);
    }

    @Override
    public int getTotalCost() {
        return customer.getTotalCost();
    }



    @Override
    public ArrayList<PurchaseProductAbstract> getCart() {
        return customer.getCart();
    }

    @Override
    public void makePurchase() throws Exception {
        customer.makePurchase();
    }


    @Override
    public void addToCart(int productNumber, int quantity) throws Exception {
       customer.addToCart(productNumber,quantity);
    }

    @Override
    public void displayCartDetails() {
      customer.displayCartDetails();
    }

    @Override
    public void joinQueue() throws Exception {
        customer.joinQueue();
    }

    public Customer getCustomer(){
        return customer;
    }
}
