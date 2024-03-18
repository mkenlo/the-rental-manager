package com.mkenlo.rentalmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.Applicant;
import com.mkenlo.rentalmanager.models.RentalApplication;
import com.mkenlo.rentalmanager.repositories.RentApplicationRepository;

@Service
public class RentApplicationService {

    @Autowired
    RentApplicationRepository rentAppRepository;

    public RentalApplication getById(long id) {
        return rentAppRepository.findById(id);
    }

    public List<RentalApplication> getAll() {
        return rentAppRepository.findAll();
    }

    public RentalApplication save(RentalApplication rentApp) {
        return rentAppRepository.save(rentApp);
    }

    public List<RentalApplication> getByApplicant(Applicant applicant) {
        return rentAppRepository.findByApplicant(applicant);
    }
}
