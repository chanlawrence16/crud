package com.lawrence.crud.controller;

import com.lawrence.crud.dto.RoleResponse;
import com.lawrence.crud.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    public RoleResponse findRolesById(@PathVariable Integer id) {
        return roleService.findRoleById(id);
    }

    @GetMapping
    public List<RoleResponse> findAllRoles(){
        return roleService.findAllRoles();
    }
}
