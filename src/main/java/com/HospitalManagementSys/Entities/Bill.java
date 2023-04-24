package com.HospitalManagementSys.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private long billId;

    @Column(name = "medicine_charges")
    private int medicineCharges;

    @Column(name = "lab_charges")
    private int labcharges;

    @Column(name = "patient_type")
    private String patientType;

    @Column(name = "bill_charges")
    private int billCharges;

    @Column(name = "health_card")
    private long healthCard;

    @Column(name = "no_of_days")
    private int noOfDays;

    @Column(name = "operation_charges")
    private int operationCharges;

    @Column(name = "room_charges")
    private int roomCharges;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "in_patient_id")
    private InPatient inPatient;*/

    @OneToOne
    @JoinColumn(name = "in_patient_id")
    private InPatient inPatient;

    @OneToOne
    @JoinColumn(name = "out_patient_id")
    private OutPatient outPatient;



/*    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "out_patient_id")
    private OutPatient outPatient;*/

}
