package com.lawrence.crud.service;

import com.lawrence.crud.dto.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse findRoleById(Integer id);

    List<RoleResponse> findAllRoles();
}
