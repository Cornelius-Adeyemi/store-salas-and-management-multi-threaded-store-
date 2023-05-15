package com.adebisi.customer;

import com.adebisi.interface_package.ICustomer;
import com.adebisi.interface_package.IPurchaseProduct;
import com.adebisi.store.Product;
import com.adebisi.store.Store;
import com.adebisi.enum_file.Availability;

import java.util.ArrayList;

public class Customer implements ICustomer {

    Store store;
    private int moneyOwned;
    private int totalCost=0;
    public final String name;
    private boolean buyChecker =false;

    private ArrayList<PurchaseProductAbstract> cart = new ArrayList<>();


    public Customer( Store store ,String name, int moneyOwned){
        this.name = name;
        this.moneyOwned = moneyOwned;
        this.store = store;
    }


    public int getMoneyOwned() {
        return moneyOwned;
    }

    public void setMoneyOwned(int moneyOwned) {
        this.moneyOwned -= moneyOwned;
    }



    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setBuyChecker(boolean buyChecker) {
        this.buyChecker = buyChecker;
    }

//    public void setCart(ArrayList<PurchaseProduct> cart) {
//        this.cart = cart;
//    }



    public int getTotalCost() {
        return totalCost;
    }

    public boolean isBuyChecker() {
        return buyChecker;
    }

    public ArrayList<PurchaseProductAbstract> getCart() {

        return cart;
    }



   public void clearCart(){
      this.cart.removeAll(this.cart);
   }

   public void addToCart(int productNumber, int quantity ) throws Exception{
       ArrayList<Product> productList = store.getProductList();
       Product purchaseProductDetails = productList.get((productNumber-1));

       double price= purchaseProductDetails.price;
       double total = price * quantity;
       if(!(purchaseProductDetails.Out_Of_Stock == Availability.OUT_OF_STOCK)) {
           PurchaseProduct r = null;

               buyChecker = true;
               totalCost += total;


               r = new PurchaseProduct(purchaseProductDetails.name, quantity, (int) total, (int) price, productNumber-1);
               cart.add(r);

       }else{
           throw new Exception(name+ "; " + purchaseProductDetails.name+" is out of stock");
       }

   }



   public void makePurchase() throws Exception{
        if(totalCost < moneyOwned){
        synchronized (store) {

            ArrayList<Product> productList = store.getProductList();
            for(int i =0; i< cart.size();i++){
                PurchaseProductAbstract purchaseProduct = cart.get(i);
                Product product = productList.get(purchaseProduct.index);
                if(purchaseProduct.quantitPurchase<=product.quanity){
                 product.quanity -= purchaseProduct.quantitPurchase;
                    product.Out_Of_Stock = (product.quanity ==0)? Availability.OUT_OF_STOCK :Availability.IN_STOCK;

                }else{

                    throw new Exception( this.name+","+product.name +" is either out of stock or not up to the quantity you selected. we have"+ product.quanity);
                }

            }

        }
        }else{

            throw new Exception( this.name+" You do not have enough money to carry out this transaction");
        }

   }

   public void oldAddToCart(int productNumber, int quantity ) throws  Exception{

       ArrayList<Product> productList = store.productList;
       Product purchaseProductDetails = productList.get((productNumber-1));

       double price= purchaseProductDetails.price;
       double total = price * quantity;
       if(!(purchaseProductDetails.Out_Of_Stock == Availability.OUT_OF_STOCK)) {
           PurchaseProduct r = null;
           if (total <= moneyOwned && purchaseProductDetails.quanity >= quantity) {
                buyChecker = true;
                totalCost += total;


              purchaseProductDetails.quanity -= quantity;
              purchaseProductDetails.Out_Of_Stock = (purchaseProductDetails.quanity ==0)? Availability.OUT_OF_STOCK :Availability.IN_STOCK;

               r = new PurchaseProduct(purchaseProductDetails.name, quantity, (int) total, (int) price, (productNumber-1));
               cart.add(r);

           } else {

               if (total >= moneyOwned) {
                   throw new Exception("You don't have enough money to carry out this transaction");
               } else {
                   throw new Exception("We only have " + purchaseProductDetails.quanity + " quanty of" + purchaseProductDetails.name);
               }
           }
       }else{
           throw new Exception(purchaseProductDetails.name+" is out of stock");
       }


   }


    @Override
    public String toString() {
        return "{ Name: " +name +", " + "Balance: " + moneyOwned +  " }";
    }

    public void displayCartDetails(){
       for(PurchaseProductAbstract x: cart){
           System.out.println(x);
       }
       System.out.println("  ");
        System.out.println("Total cost         \s \t\t\t\t\t\t\s\s\s\s$" + totalCost);
        System.out.println("Customer Change    \s \t\t\t\t\t\t\s\s\s\s$" + moneyOwned);
    }

    public void joinQueue() throws Exception{
        if(buyChecker){
       store.getFifoQueue().add(this);
       store.getByQuantityQueue().add(this);
        }else{

            throw new Exception("You have to have to cart before you can join the queue");
        }

    }


    private class PurchaseProduct extends PurchaseProductAbstract implements IPurchaseProduct {


        PurchaseProduct(String productName,int quantitPurchase, int totalCost, int unitPrice,int index){
            super(productName,quantitPurchase,totalCost,unitPrice,index);

        }


        @Override
        public String toString() {
            return productName + "\t\t\t" + "$"+ unitPrice +"/one" + "\t\t\t" + quantitPurchase+"qty" +"\t\t\t"+ "$"+totalPrice;
        }
    }
}
