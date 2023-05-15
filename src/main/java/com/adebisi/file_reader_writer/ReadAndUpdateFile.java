package com.adebisi.file_reader_writer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import com.adebisi.store.Product;
import com.adebisi.store.Store;
import com.adebisi.enum_file.Category;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;










public class ReadAndUpdateFile {

    Store store;

    public ReadAndUpdateFile(Store store){
        this.store = store;
    }

     public  void readFile(String pathName){
         try
         {
             File file = new File(pathName);   //creating a new file instance
             FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
              //creating Workbook instance that refers to .xlsx file
             XSSFWorkbook wb = new XSSFWorkbook(fis);
             XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
             Iterator<Row> itr = sheet.iterator();    //iterating over Excel file
             int number = 0;
             while (itr.hasNext()) {
                String name;
                 int price;
                 int qty;
                 String category;
                 Category ade;
                 Row row = itr.next();
                 if (number > 0) {
                     //iterating over each column
                     name = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
                     price = (int)row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                     qty = (int)row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                     category=  row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
                     if(category.equals("fashion")){
                         ade = Category.FASHION;
                     }else{
                         ade= Category.FOODSTUFF;
                     }

                    store.addproduct(name,price,qty,ade);
                 }

                 number++;
             }
             for (int index = sheet.getLastRowNum(); index >= sheet.getFirstRowNum(); index--) {
                 sheet.removeRow( sheet.getRow(index));
             }

             fis.close();
             FileOutputStream fo = new FileOutputStream(file);
             wb.write(fo);
             fo.close();


         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
     }


    public void updateFile(String pathName){

        try
        {
            File file = new File(pathName);   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Row row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue("Name");
            row1.createCell(1).setCellValue("Price");
            row1.createCell(2).setCellValue("Quanity");
            row1.createCell(3).setCellValue("Category");

            ArrayList<Product> productList = store.productList;

            int rowCount =1;

            for(Product product: productList){
                Row row = sheet.createRow(rowCount++);
                row.createCell(0).setCellValue(product.name);
                row.createCell(1).setCellValue(product.price);
                row.createCell(2).setCellValue(product.quanity);
                String category = (product.category == Category.FASHION) ? "fashion" : "foodstuff";
                row.createCell(3).setCellValue(category);

            }


            fis.close();
            FileOutputStream fo = new FileOutputStream(file);
            wb.write(fo);
            fo.close();
            
            System.out.println("file successfully updated");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
