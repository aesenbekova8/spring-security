package com.example.springsecurity.service;

import com.example.springsecurity.dto.request.SignInRequest;
import org.springframework.security.core.Authentication;

public interface AuthService {
    Authentication getAuthentication(SignInRequest request);
}
