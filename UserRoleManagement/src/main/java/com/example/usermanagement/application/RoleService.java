package com.example.usermanagement.application;

import com.example.usermanagement.application.interfaces.*;
import com.example.usermanagement.domain.*;
import java.util.*;

public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UUID createRole(String roleName) {
        Role role = new Role(roleName, UUID.randomUUID());
        return roleRepository.save(role);
    }

    public Optional<Role> getRoleById(UUID id) {
        return roleRepository.findById(id);
    }
}