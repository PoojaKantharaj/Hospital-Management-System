package com.HospitalManagementSys.Repository;

import com.HospitalManagementSys.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
