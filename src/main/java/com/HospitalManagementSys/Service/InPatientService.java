package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Payload.InPatientDto;

public interface InPatientService {

    public String createInPatientDetails(InPatientDto inPatientDto, long reportId);

    public InPatientDto getInPatientId(long inPatientId);
}
