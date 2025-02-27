package io.github.nvbao.onlineshop.repository;

import io.github.nvbao.onlineshop.entity.usermanager.User;
import io.github.nvbao.onlineshop.enums.AccountStatus;
import io.github.nvbao.onlineshop.enums.Gender;
import io.github.nvbao.onlineshop.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByAccountStatus(AccountStatus status);
    List<User> findByGender(Gender gender);
    Optional<User> findByResetPasswordToken(String token);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    List<User> findByIsVerified(boolean isVerified);

}
