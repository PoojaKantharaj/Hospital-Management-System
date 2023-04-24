package com.HospitalManagementSys.Repository;

import com.HospitalManagementSys.Entities.OutPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutPatientRepository extends JpaRepository<OutPatient, Long> {
}
