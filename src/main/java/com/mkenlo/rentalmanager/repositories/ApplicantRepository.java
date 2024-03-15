package com.mkenlo.rentalmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Applicant;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
    List<Applicant> findAll();

    Applicant findById(long id);

}
