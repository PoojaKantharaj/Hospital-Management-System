package com.HospitalManagementSys.Controller;

import com.HospitalManagementSys.Entities.Doctor;
import com.HospitalManagementSys.Payload.PatientDto;
import com.HospitalManagementSys.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitalManagementSystem/patient")
public class PatientController {

    @Autowired
    public PatientService patientService;

    //http://localhost:9090/api/hospitalManagementSystem/patient/createreg/doctorId/1
    @PostMapping("/createreg/doctorId/{doctorId}")
    public ResponseEntity<String> createPatientReg(@RequestBody PatientDto patientDto, @PathVariable("doctorId") long doctorId){
        patientService.createPatientDetails(patientDto, doctorId);
        return new ResponseEntity<>("Patient Registration Successfull!!", HttpStatus.CREATED);
    }

    //http://localhost:9090/api/hospitalManagementSystem/patient/patiendId/1
    @GetMapping("patiendId/{patientId}")
    public ResponseEntity<PatientDto> getPatientDetailsById(@PathVariable("patientId") long patientId){
        PatientDto dto = patientService.getPatientById(patientId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
