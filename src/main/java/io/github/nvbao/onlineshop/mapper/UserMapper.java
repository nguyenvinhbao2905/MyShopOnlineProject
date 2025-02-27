package io.github.nvbao.onlineshop.mapper;


import io.github.nvbao.onlineshop.dto.request.user.UserCreationRequest;
import io.github.nvbao.onlineshop.entity.usermanager.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
}
