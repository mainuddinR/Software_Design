package com.example.usermanagement.infrastructure.persistence;

import com.example.usermanagement.application.interfaces.*;
import com.example.usermanagement.domain.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final RoleJpaRepository roleJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
    }

    @Override
    public UUID save(User user) {
        UserJpaEntity entity = new UserJpaEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setRoles(user.getRoles().stream().map(r -> {
            RoleJpaEntity roleEntity = new RoleJpaEntity();
            roleEntity.setId(r.getId());
            roleEntity.setRoleName(r.getRoleName());
            return roleEntity;
        }).collect(Collectors.toSet()));
        return userJpaRepository.save(entity).getId();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userJpaRepository.findById(id).map(entity -> {
            User user = new User(entity.getId(), entity.getName(), entity.getEmail());
            Set<Role> roles = entity.getRoles().stream()
                    .map(r -> new Role(r.getRoleName(), r.getId()))
                    .collect(Collectors.toSet());
            user.setRoles(roles);
            return user;
        });
    }

    @Override
    public void assignRole(UUID userId, Role role) {
        UserJpaEntity userEntity = userJpaRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        RoleJpaEntity roleEntity = roleJpaRepository.findById(role.getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        userEntity.getRoles().add(roleEntity);
        userJpaRepository.save(userEntity);
    }
}
