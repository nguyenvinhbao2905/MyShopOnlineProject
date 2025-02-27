package io.github.nvbao.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    String productId;

    @Column(name = "product_name", nullable = false)
    String productName;
    String description;
    String details;
    String imageUrl;

    @Column(nullable = false)
    BigDecimal price;

    @Column(nullable = false)
    int stockQuantity;

    int soldQuantity;

    @Column(name = "brand")
    String brand;

    @Column(nullable = false)
    BigDecimal shippingFee;

    @ElementCollection
    @CollectionTable(name = "product_colors", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "color")
    List<String> colors;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("products")
    Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Review> reviews;

    double averageRating;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    Discount discount;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;


}
