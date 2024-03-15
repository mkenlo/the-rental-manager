package com.mkenlo.rentalmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Landlord;

@Repository
public interface LandlordRepository extends CrudRepository<Landlord, Long>{

    List<Landlord> findAll(); 

    Landlord findById(long id);

}
