package com.mkenlo.rentalmanager.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "rental_application")
public class RentalApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "property_id")
    Property property;

    @Column(nullable = true)
    int leaseLength = 3;

    @NotNull
    @Min(value = 100)
    int rentPrice;

    @Column(nullable = true)
    int deposit = 50;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "please select a move in date")
    Date potentialMoveInDate;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date createdOn;

    @Lob
    String personalReferences;

    @Lob
    String housingHistory;

    String status;

    public RentalApplication() {
    }

    @PrePersist
    private void onCreate() {
        this.createdOn = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public int getLeaseLength() {
        return leaseLength;
    }

    public void setLeaseLength(int leaseLength) {
        this.leaseLength = leaseLength;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public Date getPotentialMoveInDate() {
        return potentialMoveInDate;
    }

    public void setPotentialMoveInDate(Date potentialMoveInDate) {
        this.potentialMoveInDate = potentialMoveInDate;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getHousingHistory() {
        return housingHistory;
    }

    public void setHousingHistory(String housingHistory) {
        this.housingHistory = housingHistory;
    }

    public String getPersonalReferences() {
        return personalReferences;
    }

    public void setPersonalReferences(String personalReferences) {
        this.personalReferences = personalReferences;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
