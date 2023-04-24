package com.HospitalManagementSys.Payload;
import com.HospitalManagementSys.Entities.Bill;
import lombok.Data;

import java.util.Date;

@Data
public class OutPatientDto {

    private long pId;

    private Date dateOfTreatment;

    private LabReportDto labReport;

    /*private BillDto bill;*/
}
