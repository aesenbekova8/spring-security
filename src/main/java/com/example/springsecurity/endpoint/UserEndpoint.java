package com.example.springsecurity.endpoint;

import com.example.springsecurity.dto.request.CreateUserRequest;
import com.example.springsecurity.dto.request.SignInRequest;
import com.example.springsecurity.dto.response.JWTAuthenticationResponse;
import com.example.springsecurity.dto.response.UserView;

public interface UserEndpoint {
    UserView signUp(CreateUserRequest request);
    JWTAuthenticationResponse signIn(SignInRequest request);
}
