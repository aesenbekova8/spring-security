package com.example.springsecurity.mapper;

import com.example.springsecurity.dto.response.UserView;
import com.example.springsecurity.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserViewMapper {
    public UserView toUserView(User user){
        return UserView.builder()
                .id(user.getId())
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();
    }
}