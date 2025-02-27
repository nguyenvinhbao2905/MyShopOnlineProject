package io.github.nvbao.onlineshop.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long inventoryId;

    int totalStock;
    int reservedStock;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

}
