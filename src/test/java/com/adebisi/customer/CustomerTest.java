package com.adebisi.customer;

import com.adebisi.staff.Cashier;
import com.adebisi.staff.Manager;
import com.adebisi.store.Store;
import com.adebisi.enum_file.Category;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {


    Store store;
    Cashier susan;
    Cashier kola;
    Cashier tola;
    Cashier bola;
    Manager manager;
    @BeforeEach
    void unit(){
        store=null;
        manager=null;
     store = new Store(50000);
        store.employManager("Cornelius");
      manager = store.currentManager;
         susan = manager.hireCashier("Susan" );
         kola = manager.hireCashier("kola" );
         tola = manager.hireCashier("Tola" );
         bola = manager.hireCashier("Bola" );

        store.addproduct("mango",20,0, Category.FOODSTUFF);
        store.addproduct("orange",20,50,Category.FOODSTUFF);
        store.addproduct("beans",20,50,Category.FOODSTUFF);
        store.addproduct("plantain",20,50,Category.FOODSTUFF);
        store.addproduct("peanut",20,50,Category.FOODSTUFF);
    }
    @AfterEach
    void before(){
        System.out.println("****************");
        System.out.println("LOL");

    }

    @Test
    @DisplayName("Testing when a customer tries to buy out of stock product")
    void customerBuy() {
        Customer customer = new Customer(store,"wale", 6000);
       try {
           customer.addToCart(1, 2);
       }catch(Exception e){

       }
        assertAll(
                ()-> assertEquals(0,customer.getCart().size()),
                ()->  assertEquals(6000, customer.getMoneyOwned())
        );
    }

    @Test
    @DisplayName("Testing when a customer tries to buy IN_STOCK product")
    void customerBuyA() {
        Customer customer = new Customer(store,"wale", 6000);
        try {
            customer.addToCart(3, 2);
            customer.addToCart(3, 2);
        }catch(Exception e){}
        assertAll(
                ()-> assertEquals(2,customer.getCart().size()),
                ()->  assertEquals((6000), customer.getMoneyOwned())
        );
    }

    @Test
    @DisplayName("Testing when a cashier attend to a customer")
    void cashierAttendToCustomer() {
        Customer customer = new Customer(store,"wale", 6000);
       try {
           customer.addToCart(3, 2);
           customer.addToCart(3, 2);
           susan.sell(customer);
       }catch(Exception e){

       }
        assertAll(
                ()-> assertEquals(0,customer.getCart().size()),
               ()->  assertEquals(false, customer.isBuyChecker())
        );
    }
}