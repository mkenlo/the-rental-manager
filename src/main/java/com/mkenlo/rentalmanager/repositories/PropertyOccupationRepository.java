package com.mkenlo.rentalmanager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.PropertyOccupation;
import com.mkenlo.rentalmanager.models.Tenant;

import java.util.List;

@Repository
public interface PropertyOccupationRepository extends CrudRepository<PropertyOccupation, Long> {

    List<PropertyOccupation> findByProperty(Property property);

    List<PropertyOccupation> findByTenant(Tenant tenant);

    @Query("select * from property_occupation p where p.move_in_date <= ?1 and p.move_out_date >= ?1;")
    List<PropertyOccupation> findCurrentlyLeasing(String today);

}
