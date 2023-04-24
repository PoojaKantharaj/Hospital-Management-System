package com.HospitalManagementSys.Payload;

import lombok.Data;

@Data
public class PatientDto {

    private long id;
    private String name;
    private int age;
    private String email;
    private String mobile;
    private String gender;
    private String address;
    private String disease;
    private DoctorDto doctor;

}
