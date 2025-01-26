package com.example.jpaTutorial.jpaTuts.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor
@AllArgsConstructor
@Builder // Adds a builder pattern for creating objects
@Entity
@Table(
        name = "Product_Table",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_unique", columnNames = {"sku"}),
                @UniqueConstraint(name = "title_price_unique", columnNames = {"title_x", "price"})
        },
        indexes = {
                @Index(name = "sku_index", columnList = "sku")
        }
)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false) // This column cannot be null
    private String sku;

    @Column(name = "title_x") // Maps this field to the "title_x" column
    private String title;

    private BigDecimal price; // For monetary values

    private Integer quantity; // Represents stock or count

    @CreationTimestamp // Automatically generates a timestamp when the entity is created
    private LocalDateTime createdAt;

    @UpdateTimestamp // Automatically updates the timestamp when the entity is updated
    private LocalDateTime updatedAt;

}
