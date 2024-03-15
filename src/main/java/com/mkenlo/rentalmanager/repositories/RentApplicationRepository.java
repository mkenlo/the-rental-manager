package com.mkenlo.rentalmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Applicant;
import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.RentalApplication;
import java.util.List;

@Repository
public interface RentApplicationRepository extends CrudRepository<RentalApplication, Long> {
    List<RentalApplication> findByApplicant(Applicant applicant);

    List<RentalApplication> findByProperty(Property property);

    List<RentalApplication> findAll();

    List<RentalApplication> findByStatus(boolean status);

    List<RentalApplication> findByLeaseLength(int leaseLength);

    RentalApplication findById(long id);
}
