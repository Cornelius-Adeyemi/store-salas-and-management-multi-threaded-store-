package com.adebisi.store.display;

import com.adebisi.staff.Cashier;
import com.adebisi.store.Store;

public class DisplayCashier {

    private Store store;

    public DisplayCashier(Store store) {
        this.store = store;
    }


    public void display(){
       int number = 1;
       for(Cashier x: store.list.values()){

           System.out.println(number + " " + x);
           System.out.println(" ");
           number++;
       }
   }
}
