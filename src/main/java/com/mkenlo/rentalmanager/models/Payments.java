package com.mkenlo.rentalmanager.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_id")
    Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "lease_id")
    PropertyOccupation lease;

    @NotBlank
    double amount;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date paymentDate;

    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdateOn;

    @PrePersist
    private void onCreate() {
        this.paymentDate = new Date();
    }

    @PostUpdate
    private void onUpdate() {
        this.lastUpdateOn = new Date();
    }

    public Payments() {
    }

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getLastUpdateOn() {
        return lastUpdateOn;
    }

    public void setLastUpdateOn(Date lastUpdateOn) {
        this.lastUpdateOn = lastUpdateOn;
    }

    public PropertyOccupation getLease() {
        return lease;
    }

    public void setLease(PropertyOccupation lease) {
        this.lease = lease;
    }

}
