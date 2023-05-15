package com.adebisi.comparator_class;

import com.adebisi.customer.Customer;

import java.util.Comparator;

public class CustomerQueueComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
       if(o1.getCart().size() < o2.getCart().size()){
           return 1;
       }else if(o1.getCart().size() > o2.getCart().size()){
           return -1;
       }else{
           return 0;
       }

    }
}
