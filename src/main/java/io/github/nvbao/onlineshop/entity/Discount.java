package io.github.nvbao.onlineshop.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long discountId;

    String codeVoucher;
    double percentage;

    @OneToMany(mappedBy = "discount")
    List<Product> products;
}
