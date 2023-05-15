package com.adebisi.store;

import com.adebisi.enum_file.Availability;
import com.adebisi.enum_file.Category;

public class Product {
    public final String name;
    public final double price;

    public Availability Out_Of_Stock;

    public Category category;

    public int quanity;

    Product(String name, double price, int quantity, Category category){
        this.name = name;
        this.price = price;
        this.quanity = quantity;
        this.category = category;
        this.Out_Of_Stock = (quantity> 0)?Availability.IN_STOCK :Availability.OUT_OF_STOCK;

    }

    @Override
    public String toString() {
        return "{ name: " +name +", " + "price: " + price + ", " + "quanity: " + quanity+ " Category: "+ category+" }";
    }
}
