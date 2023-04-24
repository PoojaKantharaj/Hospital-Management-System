package com.HospitalManagementSys.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_Id")
    private long Id;

    @Column(name = "patient_name")
    private String name;

    @Column(name = "patient_age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "disease")
    private String disease;

    /*@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Doctor> doctor = new HashSet<>();*/

    /*@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctor> doctor;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_Id", nullable = false)
    private Doctor doctor;

}
