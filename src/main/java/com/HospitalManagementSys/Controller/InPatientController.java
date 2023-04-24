package com.HospitalManagementSys.Controller;

import com.HospitalManagementSys.Payload.InPatientDto;
import com.HospitalManagementSys.Service.InPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitalManagementSystem/inpatient")
public class InPatientController {

    @Autowired
    private InPatientService inPatientService;

    //http://localhost:9090/api/hospitalManagementSystem/inpatient/admit/reportId/1
    @PostMapping("/admit/reportId/{reportId}")
    public ResponseEntity<String> createInpatientRegistration(@RequestBody InPatientDto inPatientDto, @PathVariable("reportId") long reportId){
        String msg = inPatientService.createInPatientDetails(inPatientDto, reportId);
        return  new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //http://localhost:9090/api/hospitalManagementSystem/inpatient/admissionDetails/inPatientId/1
    @GetMapping("admissionDetails/inPatientId/{inPatientId}")
    public ResponseEntity<InPatientDto> getInPatientDetails(@PathVariable("inPatientId") long inPatientId){
        InPatientDto inPatientDto = inPatientService.getInPatientId(inPatientId);
        return  new ResponseEntity<>(inPatientDto, HttpStatus.OK);
    }
}
