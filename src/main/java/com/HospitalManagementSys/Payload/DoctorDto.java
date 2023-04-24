package com.HospitalManagementSys.Payload;

import lombok.Data;

import java.util.List;


@Data
public class DoctorDto {

    private long Id;

    private String name;

    private String email;

    private String mobile;

    private String department;

    private String address;

    private String empType;

    /*private List<PatientDto> patient;*/

}
