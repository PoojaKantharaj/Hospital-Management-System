package com.HospitalManagementSys.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "in_patient")
public class InPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "in_patient_id")
    private long pId;

    @OneToOne
    @JoinColumn(name = "lab_id")
    private LabReport labReport;

    @Column(name = "room_no")
    private  int roomNo;

    @Column(name = "date_of_admission")
    private Date dateOfAdmission;

    @Column(name = "date_of_discharge")
    private Date dateOfDischarge;

    @Column(name = "admission_fee")
    private int admissionFee;

    /*@OneToOne(mappedBy = "inpatient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bill bill;*/

    @OneToOne(mappedBy = "inPatient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bill bill;

/*    @OneToOne(mappedBy = "inPatient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Room room;*/

/*
    @Column(name = "admission_status")
    private String admissionStatus;
*/

}
