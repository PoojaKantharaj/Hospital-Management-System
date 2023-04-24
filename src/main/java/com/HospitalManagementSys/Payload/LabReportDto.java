package com.HospitalManagementSys.Payload;

import com.HospitalManagementSys.Entities.Doctor;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class LabReportDto {

    private long labId;
    private long labNo;
    private long patientId;
    private String patientName;
    private int Age;
    private String Mobile;
    private String category;
    private Date date;
    private ReportDoctorDetailsDto doctor;
    private int amount;
}
