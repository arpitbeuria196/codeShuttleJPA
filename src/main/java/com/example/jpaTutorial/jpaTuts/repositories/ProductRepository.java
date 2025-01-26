package com.example.jpaTutorial.jpaTuts.repositories;

import com.example.jpaTutorial.jpaTuts.Entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findBycreatedAtAfter(LocalDateTime after);
}
