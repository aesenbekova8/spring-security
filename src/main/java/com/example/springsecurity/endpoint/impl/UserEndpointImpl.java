package com.example.springsecurity.endpoint.impl;

import com.example.springsecurity.config.security.JWTTokenProvider;
import com.example.springsecurity.dto.request.CreateUserRequest;
import com.example.springsecurity.dto.request.SignInRequest;
import com.example.springsecurity.dto.response.JWTAuthenticationResponse;
import com.example.springsecurity.dto.response.UserView;
import com.example.springsecurity.endpoint.UserEndpoint;
import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.mapper.UserViewMapper;
import com.example.springsecurity.service.AuthService;
import com.example.springsecurity.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserEndpointImpl implements UserEndpoint {

    private final UserService userService;
    private final AuthService authService;
    private final JWTTokenProvider jwtTokenProvider;
    private final UserViewMapper userViewMapper;

    @Autowired
    public UserEndpointImpl(UserService userService,
                            AuthService authService,
                            JWTTokenProvider jwtTokenProvider,
                            UserViewMapper userViewMapper) {
        this.userService = userService;
        this.authService = authService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userViewMapper = userViewMapper;
    }

    @Override
    @Transactional
    public UserView signUp(@NonNull CreateUserRequest request) {
        return userViewMapper.toUserView(userService.signUp(request));
    }

    @Override
    @Transactional
    public JWTAuthenticationResponse signIn(@NonNull SignInRequest request) {

        User user = userService.getByUsername(request.getUsername());

        Authentication authentication = authService.getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        Set<Role> roles = user.getRoles();

        return new JWTAuthenticationResponse(jwt, roles);
    }
}
