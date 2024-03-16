package com.mkenlo.rentalmanager.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.Landlord;
import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.PropertyManager;
import com.mkenlo.rentalmanager.repositories.PropertyRepository;

@Service
public class PropertyService {
    PropertyRepository propertyRepository;
    final int pageSize = 5;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public Page<Property> getAll(int page) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return propertyRepository.findAll(pageable);
    }

    public Page<Property> getPropertiesByOwner(Landlord owner, int page) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return propertyRepository.findByOwner(owner, pageable);
    }

    public Page<Property> getPropertiesByPropertyManager(PropertyManager manager, int page) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return propertyRepository.findByPropertyManager(manager, pageable);
    }

    public Property getById(long id) {
        return propertyRepository.findById(id);
    }

    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    public void delete(long id) {
        propertyRepository.deleteById(id);
    }

}