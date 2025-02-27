package io.github.nvbao.onlineshop.service.user;


import io.github.nvbao.onlineshop.dto.request.user.UserCreationRequest;
import io.github.nvbao.onlineshop.entity.usermanager.User;
import io.github.nvbao.onlineshop.mapper.UserMapper;
import io.github.nvbao.onlineshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User createUser(UserCreationRequest request) {
        User user = userMapper.toUser(request);

        if (userRepository.existsByUsername(request.getUsername()) || userRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("User existed!!!");

        return userRepository.save(user);
    }

//    @Transactional
//    public Optional<User> updateUser(String userId, UserUpdateRequest request) {
//        return getUserById(userId).map(user -> {
//
//            return userRepository.save(user);
//        });
//
//    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }


}
