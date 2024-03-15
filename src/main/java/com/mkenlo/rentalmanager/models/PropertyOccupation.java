package com.mkenlo.rentalmanager.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

@Entity
public class PropertyOccupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "property_id")
    Property property;

    String occupationStatus;

    @NotNull
    long rentPrice;

    @NotNull
    @Future
    @Temporal(TemporalType.DATE)
    Date moveInDate;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    Date moveOutDate;

    @NotNull
    int leaseLength;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getOccupationStatus() {
        return occupationStatus;
    }

    public void setOccupationStatus(String occupationStatus) {
        this.occupationStatus = occupationStatus;
    }

    public long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Date getMoveInDate() {
        return moveInDate;
    }

    public void setMoveInDate(Date moveInDate) {
        this.moveInDate = moveInDate;
    }

    public Date getMoveOutDate() {
        return moveOutDate;
    }

    public void setMoveOutDate(Date moveOutDate) {
        this.moveOutDate = moveOutDate;
    }

    public int getLeaseLength() {
        return leaseLength;
    }

    public void setLeaseLength(int leaseLength) {
        this.leaseLength = leaseLength;
    }

}
