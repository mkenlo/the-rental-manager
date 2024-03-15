package com.mkenlo.rentalmanager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.TemporalType;

import jakarta.persistence.Temporal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User profile;

    String firstname;

    @NotBlank
    String lastname;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dob;

    @NotNull
    String ssn;

    @NotNull
    String currentAddress;

    @NotNull
    String occupation;

    @NotNull
    String employerName;

    @NotNull
    String employerAddress;

    @Column(nullable = true)
    String employerPhoneNum;

    @NotNull
    int annualSalary;

    @Column(nullable = true)
    String vehiculeInfos;

    @OneToMany(mappedBy = "applicant")
    List<RentalApplication> rentApplications;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getEmployerPhoneNum() {
        return employerPhoneNum;
    }

    public void setEmployerPhoneNum(String employerPhoneNum) {
        this.employerPhoneNum = employerPhoneNum;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(int annualSalary) {
        this.annualSalary = annualSalary;
    }

    public String getVehiculeInfos() {
        return vehiculeInfos;
    }

    public void setVehiculeInfos(String vehiculeInfos) {
        this.vehiculeInfos = vehiculeInfos;
    }

    public List<RentalApplication> getRentApplications() {
        return rentApplications;
    }

    public void setRentApplications(List<RentalApplication> rentApplications) {
        this.rentApplications = rentApplications;
    }

}
