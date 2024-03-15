package com.mkenlo.rentalmanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.PropertyManager;
import com.mkenlo.rentalmanager.repositories.PropertyManagerRepository;

@Service
public class ManagerService {

    PropertyManagerRepository repository;

    public ManagerService(PropertyManagerRepository repository) {
        this.repository = repository;
    }

    public List<PropertyManager> getAll() {
        return repository.findAll();
    }

    public PropertyManager getById(long id) {
        return repository.findById(id);
    }

    public PropertyManager save(PropertyManager PropertyManager) {
        return repository.save(PropertyManager);
    }

}
