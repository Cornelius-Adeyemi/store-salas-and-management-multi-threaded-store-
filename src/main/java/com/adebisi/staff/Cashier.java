package com.adebisi.staff;

import com.adebisi.customer.Customer;
import com.adebisi.interface_package.ICustomer;
import com.adebisi.store.Store;

public class Cashier extends StoreStaff {



     public Cashier(Store store,String name, String id, String position) {
        super(store ,name, id, position);
    }

  public void sell( Customer c) throws Exception{

         boolean buyChecker = c.isBuyChecker();
         if(store.list.containsKey(id)) {
             if (buyChecker) {
                 System.out.println("********* RECEIPT **********");
                 System.out.println("Receipt issued by: " + name);
                 System.out.println("Receipt issued to: " + c.name);

                 c.setBuyChecker(false);
                 c.setMoneyOwned(c.getTotalCost());

                 store.income += c.getTotalCost();
                 c.displayCartDetails();
                 c.setTotalCost(0);
                 // moneyOwned -= total;
                 //store.income += total;

                 //purchaseProductDetails.quanity -= quantity;
                 // purchaseProductDetails.Out_Of_Stock = (purchaseProductDetails.quanity ==0)? Availability.OUT_OF_STOCK :Availability.IN_STOCK;



                  c.clearCart();
             } else {
                 throw new Exception("Please pick the product you want to get");
             }
         }else{
             throw new Exception("This cashier no longer works for the store");
         }

  }


    public void attendToCustomer( boolean attend_based_on_number_of_item_in_cart) throws Exception{
        if(store.list.containsKey(id)) {
            if(!attend_based_on_number_of_item_in_cart){
                store.getByQuantityQueue().removeAll(store.getByQuantityQueue());
            while (store.getFifoQueue().size() != 0) {
                Customer c = null;
                c = store.getFifoQueue().get(0);

                System.out.println("********* RECEIPT **********");
                System.out.println("Receipt issued by: " + name);
                System.out.println("Receipt issued to: " + c.name);

                c.setBuyChecker(false);
                c.setMoneyOwned(c.getTotalCost());

                store.income += c.getTotalCost();
                c.displayCartDetails();
                c.setTotalCost(0);



                c.clearCart();
                store.getFifoQueue().remove(c);


            }
            }else{
                store.getFifoQueue().removeAll(store.getFifoQueue());
                while(!(store.getByQuantityQueue().isEmpty())){
                    Customer c = null;
                    c = store.getByQuantityQueue().poll();

                    System.out.println("********* RECEIPT **********");
                    System.out.println("Receipt issued by: " + name);
                    System.out.println("Receipt issued to: " + c.name);

                    c.setBuyChecker(false);
                    c.setMoneyOwned(c.getTotalCost());

                    store.income += c.getTotalCost();
                    c.displayCartDetails();
                    c.setTotalCost(0);


                }
            }

        }else{

            throw new Exception("This cashier no longer works for the store");
        }

    }





}
