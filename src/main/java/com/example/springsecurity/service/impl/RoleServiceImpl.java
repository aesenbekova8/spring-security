package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.Role;
import com.example.springsecurity.repository.RoleRepository;
import com.example.springsecurity.service.RoleService;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Role getById(@NonNull Long id) {
        return roleRepository.getById(id);
    }
}
