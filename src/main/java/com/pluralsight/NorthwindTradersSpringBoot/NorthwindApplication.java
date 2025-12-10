package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class NorthwindApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("jdbcProductDao")
    //autowire the productDao interface
    private ProductDao productDao;

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("""
                    ============ Welcome to the Product Admin Menu ============
                        1) Display All Products
                        2) Add a Product
                        3) Delete a Product
                        4) Update Product Details
                        5) Search by Keyword
                        6) Exit
                    """);
            switch(scanner.nextInt()){
                case 1:
                    displayAllProducts();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    private void displayAllProducts(){

        List<Product> products = productDao.getAll();

        products.forEach(System.out::println);

    }
}
