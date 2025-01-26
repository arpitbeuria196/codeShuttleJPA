package com.example.jpaTutorial.jpaTuts.repositories;

import com.example.jpaTutorial.jpaTuts.Entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Correct method: Use Pageable for pagination and sorting
    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    // Correct method: Find products created after a specific date
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);
}
