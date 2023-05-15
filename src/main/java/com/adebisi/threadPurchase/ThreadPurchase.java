package com.adebisi.threadPurchase;

import com.adebisi.customer.Customer;
import com.adebisi.staff.Cashier;

public class ThreadPurchase extends Thread {

    Cashier cashier;
    Customer customer;

    public ThreadPurchase( Cashier cashier, Customer customer){
        super();
        this.cashier = cashier;
        this.customer = customer;
    }

    public void run(){
        try {
            synchronized (cashier.store){
            customer.makePurchase();
            cashier.sell(customer);}
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
