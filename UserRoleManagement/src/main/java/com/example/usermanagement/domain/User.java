package com.example.usermanagement.domain;

import com.example.usermanagement.domain.Role;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private Set<Role> roles = new HashSet<>();

    // constructor, addRole()

    public User(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email; //deleted roles assignment
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    //getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}