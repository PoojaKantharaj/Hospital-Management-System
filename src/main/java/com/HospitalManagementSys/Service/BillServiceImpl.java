package com.HospitalManagementSys.Service;


import com.HospitalManagementSys.Entities.*;
import com.HospitalManagementSys.Payload.*;
import com.HospitalManagementSys.Repository.BillRepository;
import com.HospitalManagementSys.Repository.InPatientRepository;
import com.HospitalManagementSys.Repository.OutPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private InPatientRepository inPatientRepository;

    @Autowired
    private OutPatientRepository outPatientRepository;

    @Override
    public void createInPatientBill(BillDto billDto, long patientId) {
        Bill bill = mapToEntity(billDto);
        InPatient inPatient = inPatientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("patient not found with id " + patientId));
        bill.setInPatient(inPatient);
        billRepository.save(bill);
    }

    @Override
    public void createOutPatientBill(BillDto billDto, long patientId) {
        Bill bill = mapToEntity(billDto);
        OutPatient outPatient = outPatientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("patient not found with id " + patientId));
        bill.setOutPatient(outPatient);
        billRepository.save(bill);
    }

    @Override
    public BillDto generateFinalBill(long billId) {
        Bill bill = billRepository.findById(billId).orElseThrow(() -> new RuntimeException("patient not found with id " + billId));
        String patientType = bill.getPatientType();
        if (patientType.equals("InPatient")) {
            InPatient inPatient = new InPatient();
            long pId = bill.getInPatient().getPId();
            InPatient byId = inPatientRepository.findById(pId).orElseThrow(() -> new RuntimeException("patient not found with id " + pId));
                BillDto billDto = mapToDtoInPatient(bill);
                return billDto;
            } else {
            OutPatient outPatient = new OutPatient();
            long pId = bill.getOutPatient().getPId();
            OutPatient byId = outPatientRepository.findById(pId).orElseThrow(() -> new RuntimeException("patient not found with id " + pId));
            BillDto billDto = mapToDtoOutPatient(bill);
            return billDto;
            }
    }

    public Bill mapToEntity(BillDto billDto){
        Bill bill = new Bill();
        bill.setBillCharges(billDto.getBillCharges());
        bill.setLabcharges(billDto.getLabcharges());
        bill.setHealthCard(billDto.getHealthCard());
        bill.setNoOfDays(billDto.getNoOfDays());
        bill.setMedicineCharges(billDto.getMedicineCharges());
        bill.setRoomCharges(billDto.getRoomCharges());
        bill.setPatientType(billDto.getPatientType());
        bill.setOperationCharges(billDto.getOperationCharges());
        return bill;
    }

    public BillDto mapToDtoInPatient(Bill bill){
        BillDto billDto = new BillDto();
        billDto.setBillId(bill.getBillId());
        billDto.setBillCharges(bill.getBillCharges());
        billDto.setLabcharges(bill.getLabcharges());
        billDto.setHealthCard(bill.getHealthCard());
        billDto.setNoOfDays(bill.getNoOfDays());
        billDto.setMedicineCharges(bill.getMedicineCharges());
        billDto.setRoomCharges(bill.getRoomCharges());
        billDto.setPatientType(bill.getPatientType());
        billDto.setOperationCharges(bill.getOperationCharges());
        billDto.setInPatient(mapToDto(bill.getInPatient()));
        return billDto;
    }

    public BillDto mapToDtoOutPatient(Bill bill){
        BillDto billDto = new BillDto();
        billDto.setBillId(bill.getBillId());
        billDto.setBillCharges(bill.getBillCharges());
        billDto.setLabcharges(bill.getLabcharges());
        billDto.setHealthCard(bill.getHealthCard());
        billDto.setNoOfDays(bill.getNoOfDays());
        billDto.setMedicineCharges(bill.getMedicineCharges());
        billDto.setRoomCharges(bill.getRoomCharges());
        billDto.setPatientType(bill.getPatientType());
        billDto.setOperationCharges(bill.getOperationCharges());
        billDto.setOutPatient(mapToDto(bill.getOutPatient()));
        return billDto;
    }

    public OutPatientDto mapToDto(OutPatient outPatient) {
        OutPatientDto outPatientDto = new OutPatientDto();
        outPatientDto.setPId(outPatient.getPId());
        outPatientDto.setDateOfTreatment(outPatient.getDateOfTreatment());
        return outPatientDto;
    }

    public InPatientDto mapToDto(InPatient inPatient) {
        InPatientDto inPatientDto = new InPatientDto();
        inPatientDto.setPId(inPatient.getPId());
        inPatientDto.setRoomNo(inPatient.getRoomNo());
        inPatientDto.setDateOfAdmission(inPatient.getDateOfAdmission());
        inPatientDto.setDateOfDischarge(inPatient.getDateOfDischarge());
        inPatientDto.setAdmissionFee(inPatient.getAdmissionFee());
        return inPatientDto;

    }


}
