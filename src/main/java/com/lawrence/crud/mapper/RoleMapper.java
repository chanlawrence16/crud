package com.lawrence.crud.mapper;

import com.lawrence.crud.dto.RoleResponse;
import com.lawrence.crud.entity.Role;

import java.util.List;

public interface RoleMapper {
    RoleResponse fromEntityToResponse(Role entity);

    List<RoleResponse> fromEntitiesToReponses(List<Role> entities);
}
