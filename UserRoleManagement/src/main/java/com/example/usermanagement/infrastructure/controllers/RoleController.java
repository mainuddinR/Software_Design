package com.example.usermanagement.infrastructure.controllers;

import com.example.usermanagement.application.RoleService;
import com.example.usermanagement.domain.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<UUID> createRole(@RequestParam String roleName) {
        UUID roleId = roleService.createRole(roleName);
        return ResponseEntity.ok(roleId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable UUID id) {
        Optional<Role> role = roleService.getRoleById(id);
        return role.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
