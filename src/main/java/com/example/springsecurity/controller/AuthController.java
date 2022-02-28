package com.example.springsecurity.controller;

import com.example.springsecurity.dto.request.CreateUserRequest;
import com.example.springsecurity.dto.request.SignInRequest;
import com.example.springsecurity.dto.response.JWTAuthenticationResponse;
import com.example.springsecurity.dto.response.UserView;
import com.example.springsecurity.endpoint.UserEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final UserEndpoint userEndpoint;

    @Autowired
    public AuthController(UserEndpoint userEndpoint) {
        this.userEndpoint = userEndpoint;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserView> signUp(@Valid @RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userEndpoint.signUp(request));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JWTAuthenticationResponse> signIn(@Valid @RequestBody SignInRequest signInRequest) {
        JWTAuthenticationResponse response = userEndpoint.signIn(signInRequest);
        return ResponseEntity.ok(response);
    }
}
