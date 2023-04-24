package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Entities.Doctor;
import com.HospitalManagementSys.Entities.InPatient;
import com.HospitalManagementSys.Entities.LabReport;
import com.HospitalManagementSys.Entities.Room;
import com.HospitalManagementSys.Payload.DoctorDto;
import com.HospitalManagementSys.Payload.InPatientDto;
import com.HospitalManagementSys.Payload.LabReportDto;
import com.HospitalManagementSys.Payload.ReportDoctorDetailsDto;
import com.HospitalManagementSys.Repository.InPatientRepository;
import com.HospitalManagementSys.Repository.LabReportRepository;
import com.HospitalManagementSys.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InPatientServiceImpl implements InPatientService {

    @Autowired
    private InPatientRepository inPatientRepository;

    @Autowired
    private LabReportRepository labReportRepository;

    @Autowired
    private LabReportServiceImpl labReportService;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public String createInPatientDetails(InPatientDto inPatientDto, long reportId) {
        LabReport labReport = labReportRepository.findById(reportId).orElseThrow(() -> new RuntimeException("LabReport not found with id " + reportId));
        InPatient inPatient = mapToEntity(inPatientDto);
        int roomNo = inPatient.getRoomNo();
        Room byRoomNo = roomRepository.findByRoomNo(roomNo);
        if (byRoomNo.getStatus().equals("available")){
            inPatient.setLabReport(labReport);
            inPatientRepository.save(inPatient);
            byRoomNo.setStatus("occupied");
            byRoomNo.setInPatientId(inPatient.getPId());
            roomRepository.save(byRoomNo);
            return  "room booking was successful";
        }else {
            return "room is occupied, please try booking different room";
        }
    }

    @Override
    public InPatientDto getInPatientId(long inPatientId) {
        InPatient inPatient = inPatientRepository.findById(inPatientId).orElseThrow(() -> new RuntimeException("InPatient not found with id " + inPatientId));
        LabReport labReport = inPatient.getLabReport();
        InPatientDto inPatientDto = mapToDto(inPatient, labReport);
        return inPatientDto;
    }

    public InPatient mapToEntity(InPatientDto inPatientDto) {
        InPatient inPatient = new InPatient();
        inPatient.setRoomNo(inPatientDto.getRoomNo());
        inPatient.setDateOfAdmission(inPatientDto.getDateOfAdmission());
        inPatient.setDateOfDischarge(inPatientDto.getDateOfDischarge());
        inPatient.setAdmissionFee(inPatientDto.getAdmissionFee());
        return inPatient;
    }

    public InPatientDto mapToDto(InPatient inPatient, LabReport labReport) {
        InPatientDto inPatientDto = new InPatientDto();
        inPatientDto.setPId(inPatient.getPId());
        inPatientDto.setLabReport(mapToDto(inPatient.getLabReport(), labReport.getDoctor()));
        inPatientDto.setRoomNo(inPatient.getRoomNo());
        inPatientDto.setDateOfAdmission(inPatient.getDateOfAdmission());
        inPatientDto.setDateOfDischarge(inPatient.getDateOfDischarge());
        inPatientDto.setAdmissionFee(inPatient.getAdmissionFee());
        return inPatientDto;
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