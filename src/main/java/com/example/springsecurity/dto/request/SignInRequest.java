package com.example.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SignInRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
