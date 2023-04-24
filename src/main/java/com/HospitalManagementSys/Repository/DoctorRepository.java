package com.HospitalManagementSys.Repository;

import com.HospitalManagementSys.Entities.Doctor;
import com.HospitalManagementSys.Payload.DoctorDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
