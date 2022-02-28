package com.example.springsecurity.service;

import com.example.springsecurity.dto.request.CreateUserRequest;
import com.example.springsecurity.entity.User;

public interface UserService {
    User signUp(CreateUserRequest request);
    User getByUsername(String username);
}
