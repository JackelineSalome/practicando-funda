package com.docseeker.MedicalHistory.service;

import com.docseeker.MedicalHistory.domain.model.entity.MedicalHistoryRecord;
import com.docseeker.MedicalHistory.domain.persistence.MedicalHistoryRecordRepository;
import com.docseeker.MedicalHistory.domain.service.MedicalHistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalHistoryRecordServiceImpl implements MedicalHistoryRecordService {

    @Autowired
    private MedicalHistoryRecordRepository medicalHistoryRecordRepository;

    @Transactional(readOnly = true)
    @Override
    public List<MedicalHistoryRecord> getAll() {
        return medicalHistoryRecordRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<MedicalHistoryRecord> getById(Integer id) {
        return medicalHistoryRecordRepository.findById(id);
    }

    @Override
    public MedicalHistoryRecord save(MedicalHistoryRecord medicalHistoryRecord) {
        return medicalHistoryRecordRepository.save(medicalHistoryRecord);
    }

    @Transactional
    @Override
    public MedicalHistoryRecord update(MedicalHistoryRecord medicalHistoryRecord) {
        return medicalHistoryRecordRepository.save(medicalHistoryRecord);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (medicalHistoryRecordRepository.existsById(id)) {
            medicalHistoryRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /*@Override
    public List<Object[]> getAppointmentsByPatientId(@PathVariable int patientId) {
      return medicalHistoryRecordRepository.getAppointmentsByPatientId(patientId);
    }*/

    @Override
    public List<MedicalHistoryRecord> getAppointmentsByPatientId(@PathVariable int patientId) {
        return medicalHistoryRecordRepository.getAppointmentsByPatientId(patientId);
    }
}
