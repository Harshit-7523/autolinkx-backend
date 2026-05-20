package com.ecommerce.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.user_service.entity.Product;
import com.ecommerce.user_service.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")



@CrossOrigin(origins = "*")



public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }    
    
}
