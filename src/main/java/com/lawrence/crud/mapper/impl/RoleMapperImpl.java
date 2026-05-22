package com.lawrence.crud.mapper.impl;

import com.lawrence.crud.dto.RoleResponse;
import com.lawrence.crud.dto.UserResponse;
import com.lawrence.crud.entity.Role;
import com.lawrence.crud.entity.User;
import com.lawrence.crud.mapper.RoleMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleResponse fromEntityToResponse(Role entity) {
        if (entity == null) {
            return null;
        }
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(entity.getId());
        roleResponse.setName(entity.getName());
        return roleResponse;
    }

    @Override
    public List<RoleResponse> fromEntitiesToReponses(List<Role> entities) {
        List<RoleResponse> responses = new ArrayList<>();
        for (Role entity : entities) {
            RoleResponse roleResponse = fromEntityToResponse(entity);
            responses.add(roleResponse);
        }
        return responses;
    }
}
