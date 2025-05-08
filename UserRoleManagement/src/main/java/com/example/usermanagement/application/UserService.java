package com.example.usermanagement.application;

import com.example.usermanagement.application.interfaces.*;
import com.example.usermanagement.domain.*;
import java.util.*;

public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UUID createUser(String name, String email) {
        User user = new User(UUID.randomUUID(), name, email);
        return userRepository.save(user);
    }

    public void assignRole(UUID userId, UUID roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.addRole(role);
        userRepository.assignRole(userId, role);
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }
}