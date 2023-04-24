package com.HospitalManagementSys.Controller;

import com.HospitalManagementSys.Payload.LabReportDto;
import com.HospitalManagementSys.Repository.LabReportRepository;
import com.HospitalManagementSys.Service.LabReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitalManagementSystem/labReport")
public class LabReportController {

    @Autowired
    private LabReportService labReportService;

    //http://localhost:9090/api/hospitalManagementSystem/labReport/createLabReport/doctorId/1/patientId/1
    @PostMapping("/createLabReport/doctorId/{doctorId}/patientId/{patientId}")
    public ResponseEntity<String> createLabReport(@RequestBody LabReportDto labReportDto, @PathVariable("doctorId") long doctorId, @PathVariable("patientId") long patientId){
        labReportService.createLabReport(labReportDto, doctorId, patientId);
        return new ResponseEntity("Lab report generated successfully", HttpStatus.CREATED);
    }

    //http://localhost:9090/api/hospitalManagementSystem/labReport/labReportId/1
    @GetMapping("labReportId/{labReportId}")
    public ResponseEntity<LabReportDto> getLabReportById(@PathVariable("labReportId") long labReportId){
        LabReportDto labReportDto = labReportService.getReportById(labReportId);
        return new ResponseEntity<>(labReportDto, HttpStatus.OK);
    }

}
