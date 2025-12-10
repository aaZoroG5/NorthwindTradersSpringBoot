package com.pluralsight.NorthwindTradersSpringBoot.controllers;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    @Qualifier("jdbcProductDao")
    ProductDao productDao;

    @GetMapping("/")//this is going to reposd to a get request
    public String index(){
        return "this is magik";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productDao.getAll();
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productDao.add(product);
    }
}
