package com.mkenlo.rentalmanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.Role;
import com.mkenlo.rentalmanager.repositories.RoleRepository;

@Service
public class RoleService {

    RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public List<Role> getByRoleType(String type) {
        return roleRepository.findByRoleType(type);
    }

    public Role findByDisplayName(String name) {
        return roleRepository.findByDisplayName(name);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role save(Role role) {
        if (role != null)
            return roleRepository.save(role);
        return null;
    }

}
