package io.github.nvbao.onlineshop.entity.usermanager;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name = "roles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    @Id
    String roleName;
    String permission;

    @ManyToMany
    Set<Permission> permissions;
}
