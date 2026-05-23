package com.lawrence.crud.service.impl;

import com.lawrence.crud.dto.RoleResponse;
import com.lawrence.crud.entity.Role;
import com.lawrence.crud.mapper.RoleMapper;
import com.lawrence.crud.repository.RoleRepository;
import com.lawrence.crud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleResponse findRoleById(Integer id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isEmpty()) {
            return null;
        } else {
            Role role = optionalRole.get();
            RoleResponse response = roleMapper.fromEntityToResponse(role);
            return response;
        }
    }

    @Override
    public List<RoleResponse> findAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        List<RoleResponse> roleResponseList = roleMapper.fromEntitiesToReponses(roleList);
        return roleResponseList;
    }
}
