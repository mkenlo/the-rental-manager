package com.mkenlo.rentalmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Tenant;

@Repository
public interface TenantRepository extends CrudRepository<Tenant, Long> {

    List<Tenant> findAll();

    Tenant findById(long id);

}
