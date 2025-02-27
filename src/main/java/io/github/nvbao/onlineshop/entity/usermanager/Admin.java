package io.github.nvbao.onlineshop.entity.usermanager;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "admins")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String adminId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(nullable = false)
    String adminCode;

    boolean hasSuperAdminAccess;
}
