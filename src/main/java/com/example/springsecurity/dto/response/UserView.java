package com.example.springsecurity.dto.response;

import com.example.springsecurity.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserView {
    private Long id;
    private String username;
    private Set<Role> roles;
}