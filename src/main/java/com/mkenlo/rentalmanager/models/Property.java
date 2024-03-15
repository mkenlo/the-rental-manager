package com.mkenlo.rentalmanager.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    String name;

    @Column(nullable = true)
    String description;

    @NotBlank
    String address;

    @NotBlank
    String propertyType;

    @NotNull
    int surface;

    @Column(nullable = true)
    int numBed;

    @Column(nullable = true)
    float numBath = 1;

    @Column(nullable = true)
    String amenities;

    @Column(nullable = true)
    String floorplan;

    @NotNull
    int minLeasePrice;

    @NotNull
    int minLeaseLength;

    @Temporal(TemporalType.DATE)
    Date acquiredOn;

    @Temporal(TemporalType.DATE)
    Date updatedOn;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    Set<Image> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    Landlord owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    PropertyManager propertyManager;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    Set<RentalApplication> rentApplications;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<PropertyOccupation> propertyOccupations;

    @PostUpdate
    private void onUpdate() {
        this.updatedOn = new Date();
    }
}
