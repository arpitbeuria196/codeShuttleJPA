package com.example.jpaTutorial.jpaTuts.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity// this is cosnidered as entity
@Table(name = "Product_Table",
        uniqueConstraints = {
            @UniqueConstraint(name = "sku_unique", columnNames = {"sku"}),
            @UniqueConstraint(name = "title_price_unique", columnNames = {"title_x","price"} )
        },
        indexes = {
            @Index(name = "sku_index", columnList = "sku")
        }
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(nullable = false)
    private  String sku;

    @Column(name = "title_x")
    private  String title;

    private BigDecimal price;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
