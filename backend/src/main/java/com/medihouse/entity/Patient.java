package com.medihouse.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
public class Patient {

    // =========================
    // PRIMARY KEY
    // =========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // =========================
    // PATIENT ID
    // Example: MH-00482
    // =========================

    @Column(name = "patient_id", unique = true, nullable = false)
    private String patientId;


    // =========================
    // PERSONAL INFORMATION
    // =========================

    @Column(nullable = false)
    private String fullName;


    private LocalDate dateOfBirth;


    private Integer age;


    private String gender;


    @Column(unique = true)
    private String nicPassport;


    // =========================
    // CONTACT INFORMATION
    // =========================

    private String phone;


    private String email;


    private String address;


    private String emergencyContact;


    // =========================
    // LOGIN INFORMATION
    // =========================

    @Column(unique = true, nullable = false)
    private String username;


    @Column(nullable = false)
    private String password;


    // =========================
    // ACCOUNT STATUS
    // =========================

    private String status;


    // =========================
    // CREATED DATE
    // =========================

    private LocalDateTime createdAt;


    // =========================
    // CONSTRUCTOR
    // =========================

    public Patient() {

        this.createdAt = LocalDateTime.now();

        this.status = "ACTIVE";
    }


    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() {

        return id;
    }


    public void setId(Long id) {

        this.id = id;
    }


    public String getPatientId() {

        return patientId;
    }


    public void setPatientId(String patientId) {

        this.patientId = patientId;
    }


    public String getFullName() {

        return fullName;
    }


    public void setFullName(String fullName) {

        this.fullName = fullName;
    }


    public LocalDate getDateOfBirth() {

        return dateOfBirth;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }


    public Integer getAge() {

        return age;
    }


    public void setAge(Integer age) {

        this.age = age;
    }


    public String getGender() {

        return gender;
    }


    public void setGender(String gender) {

        this.gender = gender;
    }


    public String getNicPassport() {

        return nicPassport;
    }


    public void setNicPassport(String nicPassport) {

        this.nicPassport = nicPassport;
    }


    public String getPhone() {

        return phone;
    }


    public void setPhone(String phone) {

        this.phone = phone;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail(String email) {

        this.email = email;
    }


    public String getAddress() {

        return address;
    }


    public void setAddress(String address) {

        this.address = address;
    }


    public String getEmergencyContact() {

        return emergencyContact;
    }


    public void setEmergencyContact(String emergencyContact) {

        this.emergencyContact = emergencyContact;
    }


    public String getUsername() {

        return username;
    }


    public void setUsername(String username) {

        this.username = username;
    }


    public String getPassword() {

        return password;
    }


    public void setPassword(String password) {

        this.password = password;
    }


    public String getStatus() {

        return status;
    }


    public void setStatus(String status) {

        this.status = status;
    }


    public LocalDateTime getCreatedAt() {

        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;
    }


    // =========================
    // TO STRING
    // =========================

    @Override
    public String toString() {

        return "Patient{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}