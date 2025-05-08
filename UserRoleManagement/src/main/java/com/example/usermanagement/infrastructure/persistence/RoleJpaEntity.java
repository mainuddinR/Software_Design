package com.example.usermanagement.infrastructure.persistence;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class RoleJpaEntity {
    @Id
    private UUID id;

    private String roleName;

    // Getters, setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}