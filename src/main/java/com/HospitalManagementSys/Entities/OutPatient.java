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
@Table(name = "out_patient")
public class OutPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "out_patient_id")
    private long pId;

    @Column(name = "date_of_treatment")
    private Date dateOfTreatment;

    @OneToOne
    @JoinColumn(name = "lab_id")
    private LabReport labReport;

    /*@OneToOne(mappedBy = "outpatient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bill bill;*/

    @OneToOne(mappedBy = "outPatient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bill bill;

}
