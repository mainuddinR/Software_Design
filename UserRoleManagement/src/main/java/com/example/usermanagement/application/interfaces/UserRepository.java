package com.example.usermanagement.application.interfaces;

import com.example.usermanagement.domain.Role;
import com.example.usermanagement.domain.User;

import java.util.Optional;
import java.util.UUID;

// application/interfaces/UserRepository.java
public interface UserRepository {
    UUID save(User user);
    Optional<User> findById(UUID id);
    void assignRole(UUID userId, Role role);
}
