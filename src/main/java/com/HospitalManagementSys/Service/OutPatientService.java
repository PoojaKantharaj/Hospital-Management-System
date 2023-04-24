package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Payload.OutPatientDto;
import org.springframework.stereotype.Service;


public interface OutPatientService {

    public void RegisterOutPatient(OutPatientDto outPatientDto, long reportId);

    public OutPatientDto getOutPatientById(long pId);

}
