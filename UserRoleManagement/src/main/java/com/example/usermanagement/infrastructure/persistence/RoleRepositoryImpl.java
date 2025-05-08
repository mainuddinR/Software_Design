package com.example.usermanagement.infrastructure.persistence;

import com.example.usermanagement.application.interfaces.*;
import com.example.usermanagement.domain.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RoleRepositoryImpl implements RoleRepository {
    private final RoleJpaRepository roleJpaRepository;

    public RoleRepositoryImpl(RoleJpaRepository roleJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
    }

    @Override
    public UUID save(Role role) {
        RoleJpaEntity entity = new RoleJpaEntity();
        entity.setId(role.getId());
        entity.setRoleName(role.getRoleName());
        return roleJpaRepository.save(entity).getId();
    }

    @Override
    public Optional<Role> findById(UUID id) {
        return roleJpaRepository.findById(id).map(entity -> new Role(entity.getRoleName(), entity.getId()));
    }
}