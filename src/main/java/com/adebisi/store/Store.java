package com.adebisi.store;

import com.adebisi.comparator_class.CustomerQueueComparator;
import com.adebisi.customer.Customer;
import com.adebisi.staff.Cashier;
import com.adebisi.staff.Manager;
import com.adebisi.enum_file.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Store {

     public double income;
     public  ArrayList<Product> productList = new ArrayList<>();


     private ArrayList<Customer> fifoQueue = new ArrayList<>();



     private PriorityQueue<Customer> ByQuantityQueue = new PriorityQueue<>(new CustomerQueueComparator());



      public Manager currentManager;

     public  HashMap<String, Cashier> list = new HashMap<>();





     public Store(double income ){
         this.income = income;


     }

    public ArrayList<Customer> getFifoQueue() {
        return fifoQueue;
    }

    public PriorityQueue<Customer> getByQuantityQueue() {
        return ByQuantityQueue;
    }

    public  void employManager(String name){
        Manager.employManager(this,name);
        currentManager = Manager.getCurretManager();

    }

    public synchronized ArrayList<Product> getProductList(){
         return productList;
    }


    public Cashier getCashier(String cashierId){
         if(list.containsKey(cashierId)){
            return  list.get(cashierId);
         }else{
             System.out.println("wrong cashier details");
             return null;
         }

    }


    public void addproduct(String name, double price, int quantity, Category category){
        Product n = null;
        n = new Product(name, price, quantity, category );
        productList.add(n);

    }



}









