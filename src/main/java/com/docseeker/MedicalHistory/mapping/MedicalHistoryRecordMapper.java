package com.docseeker.MedicalHistory.mapping;

import com.docseeker.MedicalHistory.domain.model.entity.MedicalHistoryRecord;
import com.docseeker.MedicalHistory.resource.CreateMedicalHistoryRecordResource;
import com.docseeker.MedicalHistory.resource.MedicalHistoryRecordResource;
import com.docseeker.MedicalHistory.resource.UpdateMedicalHistoryRecordResource;
import com.docseeker.MedicalHistory.shared.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class MedicalHistoryRecordMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public MedicalHistoryRecord toModel(CreateMedicalHistoryRecordResource resource) {
        return this.mapper.map(resource, MedicalHistoryRecord.class);
    }
    public MedicalHistoryRecord toModel(UpdateMedicalHistoryRecordResource resource) {
        return this.mapper.map(resource, MedicalHistoryRecord.class);
    }
    public MedicalHistoryRecordResource toResource(MedicalHistoryRecord medicalHistoryRecord) {
        return this.mapper.map(medicalHistoryRecord, MedicalHistoryRecordResource.class);
    }
}
