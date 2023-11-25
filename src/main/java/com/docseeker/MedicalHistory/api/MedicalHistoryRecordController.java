package com.docseeker.MedicalHistory.api;

import com.docseeker.MedicalHistory.domain.model.entity.MedicalHistoryRecord;
import com.docseeker.MedicalHistory.domain.service.MedicalHistoryRecordService;
import com.docseeker.MedicalHistory.mapping.MedicalHistoryRecordMapper;
import com.docseeker.MedicalHistory.resource.CreateMedicalHistoryRecordResource;
import com.docseeker.MedicalHistory.resource.MedicalHistoryRecordResource;
import com.docseeker.MedicalHistory.resource.UpdateMedicalHistoryRecordResource;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/medical-histories")
@AllArgsConstructor
public class MedicalHistoryRecordController {
    private MedicalHistoryRecordService medicalHistoryRecordService;
    private MedicalHistoryRecordMapper mapper;

    @Operation(summary = "Get all")
    @GetMapping
    public List<MedicalHistoryRecord> fetchAll() {
        return medicalHistoryRecordService.getAll();
    }

    @PostConstruct
    private void init() {
      MedicalHistoryRecord medicalHistoryRecord = new MedicalHistoryRecord();
      medicalHistoryRecord.setAppointmentId(1);
      medicalHistoryRecord.setDescription("Patient has a cold");
      medicalHistoryRecordService.save(medicalHistoryRecord);
    }

    @PostMapping
    public MedicalHistoryRecordResource save(@RequestBody CreateMedicalHistoryRecordResource resource) {
        return mapper.toResource(medicalHistoryRecordService.save(mapper.toModel(resource)));
    }

    @GetMapping("{id}")
    public MedicalHistoryRecordResource fetchId(@PathVariable Integer id) {
        //return studentService.fetchById(id).get();
        return this.mapper.toResource(medicalHistoryRecordService.getById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<MedicalHistoryRecordResource> update(@PathVariable Integer id,
                                                               @RequestBody UpdateMedicalHistoryRecordResource resource){
        if (id.equals(resource.getId())) {
            MedicalHistoryRecordResource studentResource = mapper.toResource(
                    medicalHistoryRecordService.update( mapper.toModel(resource) ) );
            return new ResponseEntity<>(studentResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete by Id")
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if(medicalHistoryRecordService.deleteById(id)){
            return ResponseEntity.ok().build(); //Devolver de forma directa - lambda
            //return new ResponseEntity<>(HttpStatus.OK); //Devoluicon con instanciación
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping("/patient/{patientId}")
    public List<Object[]> getAppointmentsByPatientId(@PathVariable Integer patientId) {
      return medicalHistoryRecordService.getAppointmentsByPatientId(patientId);
    }*/

    @GetMapping("/patient/{patientId}")
    public List<MedicalHistoryRecord> getAppointmentsByPatientId(@PathVariable Integer patientId) {
        return medicalHistoryRecordService.getAppointmentsByPatientId(patientId);
    }

}
