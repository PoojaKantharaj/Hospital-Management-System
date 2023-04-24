package com.HospitalManagementSys.Controller;

import com.HospitalManagementSys.Payload.BillDto;
import com.HospitalManagementSys.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hospitalManagementSystem/bill")
public class BillController {

    @Autowired
    private BillService billService;

    //http://localhost:9090/api/hospitalManagementSystem/bill/createbill/InpatientId/1
    @PostMapping("/createbill/InpatientId/{patientId}")
    public ResponseEntity<String> createinPatientbill(@RequestBody BillDto billDto, @PathVariable ("patientId") long patientId){
        billService.createInPatientBill(billDto, patientId);
        return new ResponseEntity<>("InPatient bill created sucessfully", HttpStatus.CREATED);
    }

    //http://localhost:9090/api/hospitalManagementSystem/bill/createbill/OutpatientId/1
    @PostMapping("/createbill/OutpatientId/{patientId}")
    public ResponseEntity<String> createOutPatientbill(@RequestBody BillDto billDto, @PathVariable ("patientId") long patientId){
        billService.createOutPatientBill(billDto, patientId);
        return new ResponseEntity<>("OutPatient bill created sucessfully", HttpStatus.CREATED);
    }

    //http://localhost:9090/api/hospitalManagementSystem/bill/generate/billId/1
    @GetMapping("generate/billId/{billId}")
    public ResponseEntity<BillDto> generateBill(@PathVariable("billId") long billId){
        BillDto billDto = billService.generateFinalBill(billId);
        return new ResponseEntity<>(billDto, HttpStatus.OK);
    }

}
