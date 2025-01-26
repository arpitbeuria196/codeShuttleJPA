package com.example.jpaTutorial.jpaTuts.controllers;


import com.example.jpaTutorial.jpaTuts.Entities.ProductEntity;
import com.example.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private final int PAGE_SIZE = 2;

    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "1") Integer pageNumber) {

        // Create a PageRequest with sorting
        Pageable pageable = PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.by(sortBy));

        // Fetch products based on title and pagination
        return productRepository.findByTitleContainingIgnoreCase(title, pageable);
    }

}
