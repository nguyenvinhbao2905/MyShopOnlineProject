package io.github.nvbao.onlineshop.entity.usermanager;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.nvbao.onlineshop.enums.AccountStatus;
import io.github.nvbao.onlineshop.enums.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String userId;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false, unique = true)
    String email;

    String phoneNumber;

    @JsonIgnore
    @Column(nullable = false)
    String password;

    String fullName;

    @Enumerated(EnumType.STRING)
    Gender gender;

    String avatarUrl;

    @Enumerated(EnumType.STRING)
    AccountStatus accountStatus;

    boolean isVerified;
    String resetPasswordToken;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Customer customer;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Admin admin;

    //Tự động khởi tạo ngày
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
