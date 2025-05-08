package com.example.usermanagement.infrastructure.controllers;

import com.example.usermanagement.application.UserService;
import com.example.usermanagement.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UUID> createUser(@RequestParam String name, @RequestParam String email) {
        UUID userId = userService.createUser(name, email);
        return ResponseEntity.ok(userId);
    }

    @PostMapping("/{userId}/assign-role/{roleId}")
    public ResponseEntity<String> assignRole(
            @PathVariable UUID userId,
            @PathVariable UUID roleId
    ) {
        userService.assignRole(userId, roleId);
        return ResponseEntity.ok("Role assigned successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
