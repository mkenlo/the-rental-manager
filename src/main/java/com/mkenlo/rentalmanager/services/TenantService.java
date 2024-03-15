package com.mkenlo.rentalmanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.Tenant;
import com.mkenlo.rentalmanager.repositories.TenantRepository;

@Service
public class TenantService {

    TenantRepository repository;

    public TenantService(TenantRepository repository) {
        this.repository = repository;
    }

    public List<Tenant> getAll() {
        return repository.findAll();
    }

    public Tenant getById(long id) {
        return repository.findById(id);
    }

    public Tenant save(Tenant tenant) {
        return repository.save(tenant);
    }

}
