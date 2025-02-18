package io.github.nvbao.onlineshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.logging.Level;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    String nameProduct;
    String price;
    String category;
    String stock;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
