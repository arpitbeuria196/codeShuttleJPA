package com.example.jpaTutorial.jpaTuts.controllers;


import com.example.jpaTutorial.jpaTuts.Entities.ProductEntity;
import com.example.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy)
    {
       return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
    }
}
