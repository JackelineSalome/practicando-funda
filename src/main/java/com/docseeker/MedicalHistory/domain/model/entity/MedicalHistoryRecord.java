package com.docseeker.MedicalHistory.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "medical_history_records")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicalHistoryRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "description", length = 100, nullable = false)
  private String description;

  @Column(name = "appointment_id")
  private Integer appointmentId;

  @Column(name = "patient_id")
  private Integer patientId;

}
