package com.lawrence.crud.mapper;

import com.lawrence.crud.dto.UserResponse;
import com.lawrence.crud.entity.User;

import java.util.List;

public interface UserMapper {
    UserResponse fromEntityToResponse(User entity);

    List<UserResponse> fromEntitiesToReponses(List<User> entities);
}
