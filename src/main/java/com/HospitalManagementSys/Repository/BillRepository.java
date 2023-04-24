package com.HospitalManagementSys.Repository;

import com.HospitalManagementSys.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Bill findByPatientType(String patientType);
}
