package com.adebisi.interface_package;

import com.adebisi.staff.Cashier;
import com.adebisi.staff.Manager;
import com.adebisi.store.Store;

public interface IManager {



      void sackCashier( String cashierId);


     Cashier hireCashier(String name);


}
