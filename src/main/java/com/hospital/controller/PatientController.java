package com.hospital.controller;

import com.hospital.dto.PatientDTO;
import com.hospital.mapper.PatientMapper;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.hospital.model.Patient;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @Autowired
    private PatientMapper mapper;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody PatientDTO dto) {
        service.addPatient(dto);
        return ResponseEntity.ok("Patient added successfully");
    }


    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAll() {
        List<PatientDTO> list = service.getAllPatients();
        return ResponseEntity.ok(list);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody PatientDTO dto) {
        Patient updated = service.updatePatient(id, dto);
        PatientDTO updatedDTO = mapper.toDTO(updated);
        return ResponseEntity.ok("Patient updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
