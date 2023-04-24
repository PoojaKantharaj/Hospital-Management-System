package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Entities.Doctor;
import com.HospitalManagementSys.Entities.InPatient;
import com.HospitalManagementSys.Entities.LabReport;
import com.HospitalManagementSys.Entities.OutPatient;
import com.HospitalManagementSys.Payload.InPatientDto;
import com.HospitalManagementSys.Payload.LabReportDto;
import com.HospitalManagementSys.Payload.OutPatientDto;
import com.HospitalManagementSys.Payload.ReportDoctorDetailsDto;
import com.HospitalManagementSys.Repository.LabReportRepository;
import com.HospitalManagementSys.Repository.OutPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutPatientServiceImpl implements OutPatientService{

    @Autowired
    private OutPatientRepository outPatientRepository;

    @Autowired
    private LabReportRepository labReportRepository;

    @Override
    public void RegisterOutPatient(OutPatientDto outPatientDto, long reportId) {
        LabReport labReport = labReportRepository.findById(reportId).orElseThrow(() -> new RuntimeException("lab report not found with id " + reportId));
        OutPatient outPatient = mapToEntity(outPatientDto);
        outPatient.setLabReport(labReport);
        outPatientRepository.save(outPatient);
    }

    @Override
    public OutPatientDto getOutPatientById(long pId) {
        OutPatient outPatient = outPatientRepository.findById(pId).orElseThrow(() -> new RuntimeException("OutPatient not found with id " + pId));
        LabReport labReport = outPatient.getLabReport();
        OutPatientDto outPatientDto = mapToDto(outPatient, labReport);
        return outPatientDto;
    }

    public OutPatient mapToEntity(OutPatientDto outPatientDto) {
        OutPatient outPatient = new OutPatient();
        outPatient.setDateOfTreatment(outPatientDto.getDateOfTreatment());
        return outPatient;
    }

    public OutPatientDto mapToDto(OutPatient outPatient, LabReport labReport) {
        OutPatientDto outPatientDto = new OutPatientDto();
        outPatientDto.setPId(outPatient.getPId());
        outPatientDto.setLabReport(mapToDto(outPatient.getLabReport(), labReport.getDoctor()));
        outPatientDto.setDateOfTreatment(outPatient.getDateOfTreatment());
        return outPatientDto;
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
