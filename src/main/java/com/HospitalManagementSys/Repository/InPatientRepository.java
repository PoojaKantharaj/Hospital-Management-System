package com.HospitalManagementSys.Repository;

import com.HospitalManagementSys.Entities.InPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InPatientRepository extends JpaRepository<InPatient,Long> {

}
