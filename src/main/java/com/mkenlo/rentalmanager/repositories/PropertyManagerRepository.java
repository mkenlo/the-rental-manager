package com.mkenlo.rentalmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.PropertyManager;

@Repository
public interface PropertyManagerRepository extends CrudRepository<PropertyManager, Long> {

    List<PropertyManager> findAll();

    PropertyManager findById(long id);

}
