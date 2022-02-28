package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
