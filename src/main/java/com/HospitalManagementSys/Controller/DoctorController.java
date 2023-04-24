package com.HospitalManagementSys.Controller;

import com.HospitalManagementSys.Payload.DoctorDto;
import com.HospitalManagementSys.Repository.DoctorRepository;
import com.HospitalManagementSys.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalManagementSystem/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //http://localhost:9090/api/hospitalManagementSystem/doctor/createreg
    @PostMapping("/createreg")
    public ResponseEntity<String> createDoctorReg(@RequestBody DoctorDto doctorDto){
        doctorService.createDoctorRegistration(doctorDto);
        return  new ResponseEntity<>("Doctor Registration Successfull", HttpStatus.CREATED);
    }

    //http://localhost:9090/api/hospitalManagementSystem/doctor/doctorId/1
    @GetMapping("doctorId/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorDetailsById(@PathVariable("doctorId") long doctorId){
        DoctorDto doctorDto = doctorService.getDoctorById(doctorId);
        return  new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

}
