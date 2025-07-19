package com.hospital.controller;

import com.hospital.dto.DoctorDTO;
import com.hospital.model.Doctor;
import com.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hospital.mapper.DoctorMapper;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @Autowired
    private DoctorMapper mapper;

    @PostMapping
    public String addDoctor(@RequestBody DoctorDTO dto) {
        service.addDoctor(dto);
        return "Doctor added successfully";
    }

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return service.getAllDoctors();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO dto) {
        Doctor updated = service.updateDoctor(id, dto);
        DoctorDTO updatedDTO = mapper.toDTO(updated);
        return ResponseEntity.ok("Doctor updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        service.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }
}
