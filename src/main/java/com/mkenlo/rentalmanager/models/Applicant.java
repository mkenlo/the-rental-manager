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

}
