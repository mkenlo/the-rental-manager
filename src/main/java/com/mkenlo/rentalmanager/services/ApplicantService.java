package com.mkenlo.rentalmanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.Applicant;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.repositories.ApplicantRepository;

@Service
public class ApplicantService {

    ApplicantRepository repository;

    public ApplicantService(ApplicantRepository repository) {
        this.repository = repository;
    }

    public List<Applicant> getAll() {
        return repository.findAll();
    }

    public Applicant getById(long id) {
        return repository.findById(id);
    }

    public Applicant save(Applicant Applicant) {
        return repository.save(Applicant);
    }

    public Applicant getByProfile(User profile) {
        return repository.findByProfile(profile);
    }
}
