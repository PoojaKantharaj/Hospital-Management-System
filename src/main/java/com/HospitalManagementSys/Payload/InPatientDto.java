package com.HospitalManagementSys.Payload;

import com.HospitalManagementSys.Entities.Bill;
import lombok.Data;

import java.util.Date;

@Data
public class InPatientDto {

    private long pId;
    private LabReportDto labReport;
    private  int roomNo;
    private Date dateOfAdmission;
    private Date dateOfDischarge;
    private int admissionFee;
    /*private BillDto bill;*/
}
