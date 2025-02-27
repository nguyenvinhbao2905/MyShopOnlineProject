package io.github.nvbao.onlineshop.entity.usermanager;

import io.github.nvbao.onlineshop.entity.Order;
import io.github.nvbao.onlineshop.entity.Review;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "customers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String customerId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Order> orders;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Review> reviews;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<UserAddress> addresses;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<PaymentInfo> paymentInfos;
}
