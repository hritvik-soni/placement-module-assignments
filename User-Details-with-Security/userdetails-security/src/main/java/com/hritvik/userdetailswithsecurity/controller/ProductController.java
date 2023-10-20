package com.hritvik.userdetailswithsecurity.controller;

;
import com.hritvik.userdetailswithsecurity.model.Product;
import com.hritvik.userdetailswithsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }



    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER,ROLE_ADMIN')")

    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }





}
