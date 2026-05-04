package com.example.labo02.controller;

import com.example.labo02.domain.entity.Product;
import com.example.labo02.service.impl.ProductoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductoServiceImpl productoService;

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productoService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }
}
