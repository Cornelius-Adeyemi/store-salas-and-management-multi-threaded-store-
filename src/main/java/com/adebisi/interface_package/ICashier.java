package com.adebisi.interface_package;

import com.adebisi.customer.Customer;

public interface ICashier {


     void sell( Customer c) throws Exception;

     void attendToCustomer( boolean attend_based_on_number_of_item_in_cart) throws Exception;

}
