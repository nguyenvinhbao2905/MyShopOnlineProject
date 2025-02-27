package io.github.nvbao.onlineshop.dto.request.user;


import io.github.nvbao.onlineshop.enums.AccountStatus;
import io.github.nvbao.onlineshop.enums.Gender;
import io.github.nvbao.onlineshop.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    String username;
    String email;
    String phoneNumber;
    String password;
    String fullName;
    Gender gender;
    String avatarUrl;
    Role role;
    AccountStatus accountStatus = AccountStatus.ACTIVE;
    boolean isVerified = false;
}
