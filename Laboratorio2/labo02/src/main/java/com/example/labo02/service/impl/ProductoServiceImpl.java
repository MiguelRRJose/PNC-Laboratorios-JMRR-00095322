package com.example.labo02.service.impl;

import com.example.labo02.domain.entity.Product;
import com.example.labo02.repository.ProductRepository;
import com.example.labo02.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct (Product product){
        productRepository.save(product);
    }
}
