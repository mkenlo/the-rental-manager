package com.mkenlo.rentalmanager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Landlord;
import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.PropertyManager;
import com.mkenlo.rentalmanager.models.PropertyOccupation;
import com.mkenlo.rentalmanager.models.Tenant;

import java.util.Date;
import java.util.List;

@Repository
public interface PropertyOccupationRepository extends CrudRepository<PropertyOccupation, Long> {

    List<PropertyOccupation> findByProperty(Property property);

    List<PropertyOccupation> findByTenant(Tenant tenant);

    @Query("select p from PropertyOccupation p where p.moveInDate <= ?1 and p.moveOutDate >= ?1")
    List<PropertyOccupation> getCurrentlyLeasing(Date today);

    List<PropertyOccupation> findByMoveInDateAfterAndMoveOutDateBefore(Date today1, Date today2);

    @Query("select occ from PropertyOccupation occ join Property prop on occ.property.id=prop.id where prop.owner = ?1")
    List<PropertyOccupation> findByLandlord(Landlord landlord);

    @Query("select occ from PropertyOccupation occ join Property prop on occ.property.id=prop.id where prop.propertyManager = ?1")
    List<PropertyOccupation> findByManager(PropertyManager manager);

}
