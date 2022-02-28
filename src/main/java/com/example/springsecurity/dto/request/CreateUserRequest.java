package com.example.springsecurity.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CreateUserRequest {

    @NotBlank @Email
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String rePassword;

}