package com.mkenlo.rentalmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Role;
import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findAll();

    Role findById(long id);

    Role findByName(String name);

    Role findByDisplayName(String displayName);

    List<Role> findByRoleType(String type);
}
