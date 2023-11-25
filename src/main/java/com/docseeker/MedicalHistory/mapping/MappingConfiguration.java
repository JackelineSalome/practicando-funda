package com.docseeker.MedicalHistory.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("medicalHistoryRecordMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public MedicalHistoryRecordMapper medicalHistoryRecordMapper() {
        return new MedicalHistoryRecordMapper();
    }
}
