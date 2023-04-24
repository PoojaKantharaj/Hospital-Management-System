package com.HospitalManagementSys.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lab_report")
public class LabReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lab_id")
    private long labId;

    @Column(name = "lab_no")
    private long labNo;

    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_age")
    private int age;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "amount")
    private int amount;

    @OneToOne(mappedBy = "labReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private InPatient inPatient;

/*    @OneToOne(mappedBy = "labReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private OutPatient outPatient;*/

}
