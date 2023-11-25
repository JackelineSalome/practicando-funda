package com.docseeker.MedicalHistory.testing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.docseeker.MedicalHistory.domain.model.entity.MedicalHistoryRecord;
import com.docseeker.MedicalHistory.domain.persistence.MedicalHistoryRecordRepository;
import com.docseeker.MedicalHistory.service.MedicalHistoryRecordServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MedicalHistoryTest {
  @InjectMocks
  private MedicalHistoryRecordServiceImpl medicalHistoryRecordService;

  @Mock
  private MedicalHistoryRecordRepository medicalHistoryRecordRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetAll() {
    List<MedicalHistoryRecord> medicalHistoryRecords = new ArrayList<>();
    medicalHistoryRecords.add(new MedicalHistoryRecord(1, "Description 1",1,1));
    medicalHistoryRecords.add(new MedicalHistoryRecord(2, "Description 2",2,1));

    when(medicalHistoryRecordRepository.findAll()).thenReturn(medicalHistoryRecords);

    List<MedicalHistoryRecord> fetchedMedicalHistoryRecords = medicalHistoryRecordService.getAll();
    assertEquals(medicalHistoryRecords.size(), fetchedMedicalHistoryRecords.size());
    assertEquals(medicalHistoryRecords, fetchedMedicalHistoryRecords);
  }

  @Test
  public void testGetById() {
    MedicalHistoryRecord medicalHistoryRecord = new MedicalHistoryRecord(1, "Description 1",1,1);

    when(medicalHistoryRecordRepository.findById(1)).thenReturn(Optional.of(medicalHistoryRecord));

    Optional<MedicalHistoryRecord> fetchedMedicalHistoryRecord = medicalHistoryRecordService.getById(1);
    assertTrue(fetchedMedicalHistoryRecord.isPresent());
    assertEquals(medicalHistoryRecord, fetchedMedicalHistoryRecord.get());
  }

  @Test
  public void testSave() {
    MedicalHistoryRecord medicalHistoryRecord = new MedicalHistoryRecord(1, "Description 1",1,1);

    when(medicalHistoryRecordRepository.save(medicalHistoryRecord)).thenReturn(medicalHistoryRecord);

    MedicalHistoryRecord savedMedicalHistoryRecord = medicalHistoryRecordService.save(medicalHistoryRecord);
    assertEquals(medicalHistoryRecord, savedMedicalHistoryRecord);
  }

  @Test
  public void testUpdate() {
    MedicalHistoryRecord medicalHistoryRecord = new MedicalHistoryRecord(1, "Description 1",1,1);

    when(medicalHistoryRecordRepository.save(medicalHistoryRecord)).thenReturn(medicalHistoryRecord);

    MedicalHistoryRecord updatedMedicalHistoryRecord = medicalHistoryRecordService.update(medicalHistoryRecord);
    assertEquals(medicalHistoryRecord, updatedMedicalHistoryRecord);
  }

  @Test
  public void testDeleteById() {
    when(medicalHistoryRecordRepository.existsById(1)).thenReturn(true);

    boolean result = medicalHistoryRecordService.deleteById(1);
    assertTrue(result);
  }

  @Test
  public void testDeleteById_MedicalHistoryRecordNotFound() {
    when(medicalHistoryRecordRepository.existsById(2)).thenReturn(false);

    boolean result = medicalHistoryRecordService.deleteById(2);
    assertFalse(result);
  }

  @Test
  public void testGetAppointmentsByPatientId() {
    int patientId = 1;

    List<MedicalHistoryRecord> expectedAppointments = new ArrayList<>();
    when(medicalHistoryRecordRepository.getAppointmentsByPatientId(patientId)).thenReturn(expectedAppointments);

    List<MedicalHistoryRecord> actualAppointments = medicalHistoryRecordService.getAppointmentsByPatientId(patientId);

    assertEquals(expectedAppointments.size(), actualAppointments.size());
  }
}