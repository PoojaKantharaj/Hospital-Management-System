package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Entities.Doctor;
import com.HospitalManagementSys.Entities.Patient;
import com.HospitalManagementSys.Payload.DoctorDto;
import com.HospitalManagementSys.Payload.PatientDto;
import com.HospitalManagementSys.Repository.DoctorRepository;
import com.HospitalManagementSys.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void createPatientDetails(PatientDto patientDto, long doctorId) {
        Patient patient = mapToEntity(patientDto);
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + doctorId));
        /*List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor);*/
        patient.setDoctor(doctor);
        patientRepository.save(patient);
    }

    @Override
    public PatientDto getPatientById(long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found with id " + patientId));
        PatientDto patientDto = mapToDto(patient);
        return patientDto;
    }

    public PatientDto mapToDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAge(patient.getAge());
        patientDto.setAddress(patient.getAddress());
        patientDto.setDisease(patient.getDisease());
        patientDto.setGender(patient.getGender());
        patientDto.setMobile(patient.getMobile());
        patientDto.setDoctor(mapToDto(patient.getDoctor()));
        return patientDto;
    }

    public DoctorDto mapToDto(Doctor doctor){
        DoctorDto doctordto = new DoctorDto();
        doctordto.setId(doctor.getId());
        doctordto.setName(doctor.getName());
        doctordto.setEmail(doctor.getEmail());
        doctordto.setAddress(doctor.getAddress());
        doctordto.setMobile(doctor.getMobile());
        doctordto.setDepartment(doctor.getDepartment());
        doctordto.setEmpType(doctor.getEmpType());
        return doctordto;
    }



    public Patient mapToEntity(PatientDto patientDto){
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setAge(patientDto.getAge());
        patient.setAddress(patientDto.getAddress());
        patient.setDisease(patientDto.getDisease());
        patient.setGender(patientDto.getGender());
        patient.setMobile(patientDto.getMobile());
        return patient;
    }
}
