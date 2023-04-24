package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Payload.LabReportDto;

public interface LabReportService {
     public void  createLabReport(LabReportDto labReportDto, long doctorId, long patientId);

     public LabReportDto getReportById(long labReportId);
}
