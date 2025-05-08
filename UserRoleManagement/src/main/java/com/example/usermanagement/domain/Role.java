package com.example.usermanagement.domain;

import java.util.UUID;

public class Role {
    private UUID id;
    private String roleName;

    // constructor, getters

    public Role(String roleName, UUID id) {
        this.roleName = roleName;
        this.id = id;
    }

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