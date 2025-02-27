package io.github.nvbao.onlineshop.entity.usermanager;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "admins")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission {

    @Id
    String roleName;
    String permission;
}
