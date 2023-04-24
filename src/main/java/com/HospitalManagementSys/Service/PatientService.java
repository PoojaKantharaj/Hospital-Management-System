package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Payload.PatientDto;

public interface PatientService {

    public void createPatientDetails(PatientDto patientDto, long doctorId);

    public PatientDto getPatientById(long patientId);
}
