package com.docseeker.MedicalHistory.domain.persistence;

import com.docseeker.MedicalHistory.domain.model.entity.MedicalHistoryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalHistoryRecordRepository /*extends ListCrudRepository<MedicalHistoryRecord, Integer>*/extends JpaRepository<MedicalHistoryRecord, Integer> {
    //List<Object[]> getAppointmentsByPatientId(int patientId);
    List<MedicalHistoryRecord> getAppointmentsByPatientId(int patientId);

  /*@Query("SELECT a, m, p, d FROM Appointment a LEFT JOIN MedicalHistoryRecord m ON a.id = m.appointmentId LEFT JOIN Patient p ON a.patientId = p.id LEFT JOIN Doctor d ON d.id =a.doctorId WHERE p.id = :patientId")
  List<Object[]> getAppointmentsByPatientId(@Param("patientId") int patientId);*/
}
