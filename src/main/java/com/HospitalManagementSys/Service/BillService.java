package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Payload.BillDto;

public interface BillService {

    public void createInPatientBill(BillDto  billDto, long patientId);

    public void createOutPatientBill(BillDto  billDto, long patientId);

    public BillDto generateFinalBill(long billId);

}
