package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Entities.Doctor;
import com.HospitalManagementSys.Entities.LabReport;
import com.HospitalManagementSys.Entities.Patient;
import com.HospitalManagementSys.Payload.DoctorDto;
import com.HospitalManagementSys.Payload.LabReportDto;
import com.HospitalManagementSys.Payload.ReportDoctorDetailsDto;
import com.HospitalManagementSys.Repository.DoctorRepository;
import com.HospitalManagementSys.Repository.LabReportRepository;
import com.HospitalManagementSys.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabReportServiceImpl implements LabReportService{

    @Autowired
    private LabReportRepository labReportRepository;
    
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void createLabReport(LabReportDto labReportDto, long doctorId, long patientId) {
        LabReport labReport = mapToEntity(labReportDto);
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found with id " + doctorId));
        labReport.setDoctor(doctor);
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("patient not found with id " + patientId));
        labReport.setPatientId(patient.getId());
        labReport.setPatientName(patient.getName());
        labReport.setAge(patient.getAge());
        labReport.setMobile(patient.getMobile());
        labReportRepository.save(labReport);
    }

    @Override
    public LabReportDto getReportById(long labReportId) {
        LabReport labReport = labReportRepository.findById(labReportId).orElseThrow(() -> new RuntimeException("lab report not found with id " + labReportId));
        Doctor doctor = labReport.getDoctor();
        LabReportDto labReportDto = mapToDto(labReport, doctor);
        /*labReportDto.setDoctor(mapToDto(doctor));*/
        return labReportDto;
    }

    public LabReport mapToEntity(LabReportDto labReportDto){
        LabReport labReport = new LabReport();
        labReport.setLabNo(labReportDto.getLabNo());
        labReport.setPatientId(labReportDto.getPatientId());
        labReport.setCategory(labReportDto.getCategory());
        labReport.setAmount(labReportDto.getAmount());
        labReport.setDate(labReportDto.getDate());
        return labReport;
    }

    public LabReportDto mapToDto(LabReport labReport, Doctor doctor){
        LabReportDto labReportDto = new LabReportDto();
        labReportDto.setLabId(labReport.getLabId());
        labReportDto.setLabNo(labReport.getLabNo());
        labReportDto.setPatientId(labReport.getPatientId());
        labReportDto.setCategory(labReport.getCategory());
        labReportDto.setAmount(labReport.getAmount());
        labReportDto.setDate(labReport.getDate());
        labReportDto.setPatientName(labReport.getPatientName());
        labReportDto.setAge(labReport.getAge());
        labReportDto.setMobile(labReport.getMobile());
        labReportDto.setDoctor(mapToDto(doctor));
        return labReportDto;
    }

    public ReportDoctorDetailsDto mapToDto(Doctor doctor){
        ReportDoctorDetailsDto doctordto = new ReportDoctorDetailsDto();
        doctordto.setId(doctor.getId());
        doctordto.setName(doctor.getName());
        doctordto.setDepartment(doctor.getDepartment());
        return doctordto;
    }


}
