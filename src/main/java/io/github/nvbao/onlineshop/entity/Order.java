package io.github.nvbao.onlineshop.entity;


import io.github.nvbao.onlineshop.entity.usermanager.Customer;
import io.github.nvbao.onlineshop.entity.usermanager.User;
import io.github.nvbao.onlineshop.entity.usermanager.UserAddress;
import io.github.nvbao.onlineshop.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "user_address_id", nullable = false)
    UserAddress shippingAddress;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @Column(nullable = false)
    BigDecimal totalPrice;

    String paymentMethod;

    LocalDateTime orderDate;
    LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate() {
        orderDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
