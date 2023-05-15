package com.adebisi.service_class;

import com.adebisi.customer.Customer;
import com.adebisi.interface_package.ICashier;
import com.adebisi.staff.Cashier;

public class CashierService implements ICashier {

    Cashier cashier;

    public CashierService( Cashier cashier ){
        this.cashier = cashier;
    }

    @Override
    public void sell(Customer c) throws Exception {
        cashier.sell(c);
    }
    public Cashier getCashier(){
        return cashier;
    }
    @Override
    public void attendToCustomer(boolean attend_based_on_number_of_item_in_cart) throws Exception {
     cashier.attendToCustomer(attend_based_on_number_of_item_in_cart);
    }
}
