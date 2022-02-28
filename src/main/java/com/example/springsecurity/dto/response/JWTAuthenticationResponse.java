package com.example.springsecurity.dto.response;

import com.example.springsecurity.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class JWTAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private Set<Role> roles;

    public JWTAuthenticationResponse(String accessToken,
                                     Set<Role> roles) {
        this.roles = roles;
        this.accessToken = accessToken;
    }
}
