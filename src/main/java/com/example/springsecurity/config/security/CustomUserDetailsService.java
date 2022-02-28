package com.example.springsecurity.config.security;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.repository.UserRepository;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static java.lang.String.format;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(format("User with username: %s not found", username))
                );
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(@NonNull Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(format("User with id: %s not found", id))
        );
        return UserPrincipal.create(user);
    }
}
