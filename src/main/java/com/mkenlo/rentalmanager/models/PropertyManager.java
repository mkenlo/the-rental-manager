package com.mkenlo.rentalmanager.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PropertyManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User profile;

    @OneToMany(mappedBy = "propertyManager", fetch = FetchType.LAZY)
    Set<Property> managedProperties;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getProfile() {
        return profile;
    }

    public void setProfile(User profile) {
        this.profile = profile;
    }

    public Set<Property> getManagedProperties() {
        return managedProperties;
    }

    public void setManagedProperties(Set<Property> managedProperties) {
        this.managedProperties = managedProperties;
    }

}
