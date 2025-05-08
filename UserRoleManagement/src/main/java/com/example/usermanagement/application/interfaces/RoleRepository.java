package com.example.usermanagement.application.interfaces;

import com.example.usermanagement.domain.*;
import java.util.*;

public interface RoleRepository {
    UUID save(Role role);
    Optional<Role> findById(UUID id);
}