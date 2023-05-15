package com.adebisi.store.display;

import com.adebisi.store.Product;
import com.adebisi.store.Store;
import com.adebisi.enum_file.Category;

import java.util.ArrayList;

public class DisplayProducts {

    private Store store;

    public DisplayProducts(Store store) {
        this.store = store;
    }

    public  void displayproducts(){
        ArrayList<Product> list = store.productList;
        System.out.println("Products Catalog ");
        int number = 1;
        for(Product x:list){
            System.out.println("--------------------------------------- ");
            System.out.println(number+"."+" "+ x.name + "\nprice: "+ x.price+"\nQuantity: "+ x.quanity +"\nCategory: "+ x.category+"\nStatus: "+x.Out_Of_Stock);
            System.out.println("---------------------------------------- ");
            number++;
        }
    }


    public void displayByCategory( Category category){
        ArrayList<Product> list = store.productList;
         System.out.println("********** " +category + " CATEGORY ******");
        for(int i=0; i<list.size();i++){
            Product product = list.get(i);
            if(product.category==category){
                System.out.println("-----------------------------------------");
                System.out.println((i+1)+"."+" "+ product.name + "\nprice: "+ product.price+"\nQuantity: "+ product.quanity +"\nCategory: "+ product.category+"\nStatus: "+product.Out_Of_Stock);
            }
        }
    }
}
