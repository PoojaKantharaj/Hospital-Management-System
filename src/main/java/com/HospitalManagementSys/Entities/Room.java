package com.HospitalManagementSys.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roomId;

    @Column(name = "room_no")
    private int roomNo;

    @Column(name = "room_type")
    private String roomType;

    @Column(name ="status")
    private String status;

/*    @OneToOne
    @JoinColumn(name = "in_patient_id")
    private InPatient inPatient;*/

    @Column(name = "in_patient_id")
    private long inPatientId;
}
