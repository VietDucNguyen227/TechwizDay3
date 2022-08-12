package com.example.healthassistant.service;

import com.example.healthassistant.model.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByName(String name);
}
