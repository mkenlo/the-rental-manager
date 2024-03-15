package com.mkenlo.rentalmanager.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mkenlo.rentalmanager.models.Payments;
import com.mkenlo.rentalmanager.models.PropertyOccupation;
import com.mkenlo.rentalmanager.models.Tenant;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payments, Long> {

    List<Payments> findByTenant(Tenant tenant);

    List<Payments> findByTenantAndLease(Tenant tenant, PropertyOccupation lease);

    Payments findById(long id);

}
