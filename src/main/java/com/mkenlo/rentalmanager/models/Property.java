package com.mkenlo.rentalmanager.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    List<RentalApplication> rentApplications;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<PropertyOccupation> propertyOccupations;

    public Property() {
        this.rentApplications = new ArrayList<>();
        this.propertyOccupations = new ArrayList<>();
    }

    @PostUpdate
    private void onUpdate() {
        this.updatedOn = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public int getNumBed() {
        return numBed;
    }

    public void setNumBed(int numBed) {
        this.numBed = numBed;
    }

    public float getNumBath() {
        return numBath;
    }

    public void setNumBath(float numBath) {
        this.numBath = numBath;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getFloorplan() {
        return floorplan;
    }

    public void setFloorplan(String floorplan) {
        this.floorplan = floorplan;
    }

    public int getMinLeasePrice() {
        return minLeasePrice;
    }

    public void setMinLeasePrice(int minLeasePrice) {
        this.minLeasePrice = minLeasePrice;
    }

    public int getMinLeaseLength() {
        return minLeaseLength;
    }

    public void setMinLeaseLength(int minLeaseLength) {
        this.minLeaseLength = minLeaseLength;
    }

    public Date getAcquiredOn() {
        return acquiredOn;
    }

    public void setAcquiredOn(Date acquiredOn) {
        this.acquiredOn = acquiredOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Landlord getOwner() {
        return owner;
    }

    public void setOwner(Landlord owner) {
        this.owner = owner;
    }

    public PropertyManager getPropertyManager() {
        return propertyManager;
    }

    public void setPropertyManager(PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
    }

    public List<RentalApplication> getRentApplications() {
        return rentApplications;
    }

    public void setRentApplications(List<RentalApplication> rentApplications) {
        this.rentApplications = rentApplications;
    }

    public List<PropertyOccupation> getPropertyOccupations() {
        return propertyOccupations;
    }

    public void setPropertyOccupations(List<PropertyOccupation> propertyOccupations) {
        this.propertyOccupations = propertyOccupations;
    }

}
