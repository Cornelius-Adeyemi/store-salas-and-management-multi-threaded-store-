import com.adebisi.service_class.CashierService;
import com.adebisi.service_class.CustomerService;
import com.adebisi.service_class.ManagerService;
import com.adebisi.staff.Cashier;
import com.adebisi.customer.Customer;
import com.adebisi.staff.Manager;
import com.adebisi.store.Store;
import com.adebisi.enum_file.Category;
import com.adebisi.store.display.DisplayProducts;
import com.adebisi.store.display.DisplayCashier;
import com.adebisi.threadPurchase.ThreadPurchase;

public class Main {
    public static void main(String[] args) {
       try {
           Store store = new Store(50000);
           store.employManager("Adebisi");
           ManagerService myManager = new ManagerService(store.currentManager);


           Cashier susan = myManager.hireCashier("Susan");
           CashierService susanS = new CashierService(susan);
           Cashier kola = myManager.hireCashier("kola");
           Cashier tola = myManager.hireCashier("Tola");
           Cashier bola = myManager.hireCashier("Bola");

           DisplayCashier displayCashier = new DisplayCashier(store);

           DisplayProducts displayProducts = new DisplayProducts(store);
           displayCashier.display();
           System.out.println("************");
              //  myManager.sackCashier("cashier04" );
            displayCashier.display();

           System.out.println("************");

           store.addproduct("mango", 20, 50, Category.FOODSTUFF);
           store.addproduct("orange", 20, 50, Category.FOODSTUFF);
           store.addproduct("beans", 20, 50, Category.FOODSTUFF);
           store.addproduct("plantain", 20, 50, Category.FOODSTUFF);
           store.addproduct("peanut", 20, 50, Category.FOODSTUFF);
           String path = "/Users/decagon/IdeaProjects/task_one copy/src/main/java/com/adebisi/external_file/productSheet.xlsx";
//        ReadAndUpdateFile readAndUpdateFile = new ReadAndUpdateFile(store);
//        readAndUpdateFile.readFile(path,store);

           displayProducts.displayproducts();


           CustomerService c1 =  new CustomerService( new Customer(store, "Adebis", 6000000));

           c1.addToCart(1, 4);  // remain 50
           c1.addToCart(2, 4);

           CustomerService c2 =  new CustomerService( new Customer(store, "Shola", 6000000));

           c2.addToCart(1, 5);  // remain 50


           ThreadPurchase c1Thread = new ThreadPurchase(susanS.getCashier(),c1.getCustomer());
           ThreadPurchase c2Thread = new ThreadPurchase(susanS.getCashier(),c2.getCustomer());

          c1Thread.start();

           c2Thread.start();
           c1Thread.join();
           c2Thread.join();

           System.out.println("***************");
           displayProducts.displayproducts();










       }
       catch(Exception e){
           System.err.println(e.getMessage());
       }
    }

}