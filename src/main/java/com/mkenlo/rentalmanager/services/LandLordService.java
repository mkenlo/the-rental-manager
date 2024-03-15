package com.mkenlo.rentalmanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.Landlord;
import com.mkenlo.rentalmanager.repositories.LandlordRepository;

@Service
public class LandLordService {

    LandlordRepository repository;

    public LandLordService(LandlordRepository repository) {
        this.repository = repository;
    }

    public List<Landlord> getAll() {
        return repository.findAll();
    }

    public Landlord getById(long id) {
        return repository.findById(id);
    }

    public Landlord save(Landlord Landlord) {
        return repository.save(Landlord);
    }
}
