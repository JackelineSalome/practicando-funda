package com.docseeker.MedicalHistory.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistoryRecordResource {
    private Integer id;

    private String description;

    private Integer appointmentId;

    private Integer patientId;
}
