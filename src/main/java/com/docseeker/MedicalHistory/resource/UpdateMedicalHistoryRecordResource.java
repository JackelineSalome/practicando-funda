package com.docseeker.MedicalHistory.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.Getter;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMedicalHistoryRecordResource {

    private Integer id;

    private String description;

    private Integer appointmentId;

  private Integer patientId;

    public Integer getId() {
        return id;
    }
}
