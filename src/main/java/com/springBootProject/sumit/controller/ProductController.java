package com.springbootproject.sumit.controller;

import com.springbootproject.sumit.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    /**
     *  Using @Autowired to Avoid creating object for Product
     */
    @Autowired
    private Product product;

    @GetMapping("/products")
    public Product getDetailsOfProduct() {
        // Product product = new Product();
        product.setAbout("Product details");
        product.setId(1234);
        product.setName("Encompass");
        product.setPrice(1000.20);
        return product;
    }
}
