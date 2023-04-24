package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Entities.Doctor;
import com.HospitalManagementSys.Payload.DoctorDto;

import java.util.List;

public interface DoctorService {

    public void createDoctorRegistration(DoctorDto doctorDto);

    public DoctorDto getDoctorById(long doctorId);

}
