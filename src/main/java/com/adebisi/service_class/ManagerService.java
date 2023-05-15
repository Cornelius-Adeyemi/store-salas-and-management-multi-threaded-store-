package com.adebisi.service_class;


import com.adebisi.interface_package.IManager;
import com.adebisi.staff.Cashier;
import com.adebisi.staff.Manager;

public class ManagerService implements IManager {

    private Manager manager;

    public ManagerService(Manager manager){
        this.manager = manager;
    }

    @Override
    public void sackCashier(String cashierId) {
        manager.sackCashier(cashierId);
    }

    @Override
    public Cashier hireCashier(String name) {
        return manager.hireCashier(name);
    }
}
