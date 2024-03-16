package com.mkenlo.rentalmanager.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Landlord;
import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.PropertyManager;

@Repository
public interface PropertyRepository extends PagingAndSortingRepository<Property, Long> {

    Page<Property> findAll(Pageable pageable);

    Property findById(long id);

    Page<Property> findByOwner(Landlord owner, Pageable pageable);

    Page<Property> findByPropertyManager(PropertyManager manager, Pageable pageable);

    Property save(Property property);

    void deleteById(long id);

}