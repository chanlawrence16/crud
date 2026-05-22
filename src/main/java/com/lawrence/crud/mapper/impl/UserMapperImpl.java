package com.lawrence.crud.mapper.impl;

import com.lawrence.crud.dto.UserResponse;
import com.lawrence.crud.entity.User;
import com.lawrence.crud.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse fromEntityToResponse(User entity) {
        if (entity == null) {
            return null;
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setId(entity.getId());
        userResponse.setUsername(entity.getUsername());
        userResponse.setCreatedDate(entity.getCreatedDate());
        return userResponse;
    }

    @Override
    public List<UserResponse> fromEntitiesToReponses(List<User> entities) {
        List<UserResponse> responses = new ArrayList<>();
        for (User entity : entities) {
            UserResponse userResponse = fromEntityToResponse(entity);
            responses.add(userResponse);
        }
        return responses;
    }
}
