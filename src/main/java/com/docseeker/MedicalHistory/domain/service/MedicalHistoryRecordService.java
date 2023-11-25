package com.docseeker.MedicalHistory.domain.service;

import com.docseeker.MedicalHistory.domain.model.entity.MedicalHistoryRecord;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface MedicalHistoryRecordService {
    List<MedicalHistoryRecord> getAll();
    Optional<MedicalHistoryRecord> getById(Integer id);
    MedicalHistoryRecord save(MedicalHistoryRecord medicalHistoryRecord);
    MedicalHistoryRecord update(MedicalHistoryRecord medicalHistoryRecord);
    boolean deleteById(Integer id);
    //List<Object[]> getAppointmentsByPatientId(@PathVariable int patientId);

    List<MedicalHistoryRecord> getAppointmentsByPatientId(@PathVariable int patientId);
}
