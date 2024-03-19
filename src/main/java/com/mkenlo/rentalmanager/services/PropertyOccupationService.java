package com.mkenlo.rentalmanager.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkenlo.rentalmanager.models.Landlord;
import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.PropertyManager;
import com.mkenlo.rentalmanager.models.PropertyOccupation;
import com.mkenlo.rentalmanager.models.RentalApplication;
import com.mkenlo.rentalmanager.models.Tenant;
import com.mkenlo.rentalmanager.repositories.PropertyOccupationRepository;

@Service
public class PropertyOccupationService {

    @Autowired
    PropertyOccupationRepository repository;

    @Autowired
    TenantService tenantService;

    public List<PropertyOccupation> getByLandlord(Landlord landlord) {
        return repository.findByLandlord(landlord);
    }

    public List<PropertyOccupation> getByManager(PropertyManager manager) {
        return repository.findByManager(manager);
    }

    public List<PropertyOccupation> getByProperty(Property property) {
        return repository.findByProperty(property);
    }

    public List<PropertyOccupation> getByTenant(Tenant tenant) {
        return repository.findByTenant(tenant);
    }

    public List<PropertyOccupation> getCurrentlyLeasing() {
        return repository.getCurrentlyLeasing(new Date());
    }

    public PropertyOccupation save(PropertyOccupation property) {
        return repository.save(property);
    }

    public PropertyOccupation createOccupancy(RentalApplication approvedApplication) {
        if (approvedApplication.getStatus().equalsIgnoreCase("rejected"))
            return null;

        PropertyOccupation occupancy = new PropertyOccupation();
        occupancy.setLeaseLength(approvedApplication.getLeaseLength());
        occupancy.setMoveInDate(approvedApplication.getPotentialMoveInDate());
        Tenant newTenant = new Tenant();
        newTenant.setProfile(approvedApplication.getApplicant().getProfile());

        tenantService.save(newTenant);

        occupancy.setTenant(newTenant);

        occupancy.setProperty(approvedApplication.getProperty());

        occupancy.setOccupationStatus(1); // available for move in
        return repository.save(occupancy);
    }
}
