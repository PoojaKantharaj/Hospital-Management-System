package com.HospitalManagementSys.Payload;

import lombok.Data;

import javax.persistence.Column;

@Data
public class BillDto {

    private long billId;
    private int medicineCharges;
    private int labcharges;
    private String patientType;
    private int billCharges;
    private long healthCard;
    private int noOfDays;
    private int operationCharges;
    private int roomCharges;
    private OutPatientDto outPatient;
    private InPatientDto inPatient;
}
