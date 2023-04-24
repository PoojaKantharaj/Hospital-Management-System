package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Entities.Doctor;
import com.HospitalManagementSys.Payload.DoctorDto;
import com.HospitalManagementSys.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{


    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void createDoctorRegistration(DoctorDto doctorDto) {
        Doctor doctor = mapToEntity(doctorDto);
        doctorRepository.save(doctor);
    }

    @Override
    public DoctorDto getDoctorById(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found with id " + doctorId));
        DoctorDto doctorDto = mapToDto(doctor);
        return doctorDto;
    }


    public Doctor mapToEntity(DoctorDto doctorDto){
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setMobile(doctorDto.getMobile());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setDepartment(doctorDto.getDepartment());
        doctor.setEmpType(doctorDto.getEmpType());
        return doctor;
    }

    public DoctorDto mapToDto(Doctor doctor){
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setMobile(doctor.getMobile());
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setDepartment(doctor.getDepartment());
        doctorDto.setEmpType(doctor.getEmpType());
        return doctorDto;
    }
}
