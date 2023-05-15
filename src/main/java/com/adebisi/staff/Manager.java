package com.adebisi.staff;

import com.adebisi.interface_package.IManager;
import com.adebisi.store.Store;

public class Manager extends StoreStaff implements IManager {

    private static Manager myManager = null;
    private static int num =1;

    private Manager(Store store, String name, String id, String position) {
        super(store, name, id, position);
    }

    public static void employManager(Store store,String name){
        if(myManager ==null){
          String id= "manager111";
          String title = "Manager";

          myManager= new Manager(store, name, id,title);
           System.out.println("A new manager has been employed to manage the store. The manager id is "+id);
        }else {

            System.out.println("The store already has a manger");
        }

    }




    public static Manager getCurretManager(){
        if(myManager ==null){
             System.out.println("The store has no manager at the moment");
           return null;
        }else{
            return myManager;
        }
    }

    public  void sackCashier( String cashierId){
        if(store.list.containsKey(cashierId)){
            String name = store.list.get(cashierId).name;
            store.list.remove(cashierId);

            System.out.println(" you've successfully sacked "+name+ " from the store");
        }else{
            System.out.println("Their is no cashier with such id");
        }
    }

    public Cashier hireCashier( String name){
        Cashier r = null;
        if(store.list.size()<6){
            String id = "cashier0" + num;
            r = new Cashier(store,name,id, "Cashier");
            store.list.put(id,r);
            num++;
            System.out.println("The cashier id for " + r.name+ " is: "+ id);
            return r ;
        }else{
            System.out.println("maximum number of cashier the store can employ is 5");
            return null;
        }
    }


}
