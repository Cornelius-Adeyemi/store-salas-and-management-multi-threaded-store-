package com.adebisi.staff;

import com.adebisi.store.Store;

public abstract class StoreStaff {
   public Store store;
   public final String name;
   public final String id;
   public final String title;

    public StoreStaff(Store store,String name, String id, String position){
        this.store = store;
        this.name = name;
        this.id = id;
        this.title = position;
    }

    @Override
    public String toString() {
        return " Id: "+ id+"\n" +  "Name: "+name + "\n" + "Title "+ title;
    }
}
