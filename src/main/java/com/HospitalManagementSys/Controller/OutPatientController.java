package com.HospitalManagementSys.Controller;

import com.HospitalManagementSys.Payload.OutPatientDto;
import com.HospitalManagementSys.Service.OutPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitalManagementSystem/outpatient")
public class OutPatientController {

    @Autowired
    private OutPatientService outPatientService;

    //http://localhost:9090/api/hospitalManagementSystem/outpatient/create/reportId/2
    @PostMapping("/create/reportId/{reportId}")
    public ResponseEntity<String> createOutPatient(@RequestBody OutPatientDto outPatientDto, @PathVariable("reportId") long reportId){
        outPatientService.RegisterOutPatient(outPatientDto, reportId);
        return new ResponseEntity<>("out patient details saved successfully", HttpStatus.CREATED);
    }

    //http://localhost:9090/api/hospitalManagementSystem/outpatient/pId/1
    @GetMapping("pId/{pId}")
    public ResponseEntity<OutPatientDto> getOutPatientDetails(@PathVariable("pId") long pId){
        OutPatientDto outPatientDto = outPatientService.getOutPatientById(pId);
        return new ResponseEntity<>(outPatientDto, HttpStatus.OK);
    }
}
