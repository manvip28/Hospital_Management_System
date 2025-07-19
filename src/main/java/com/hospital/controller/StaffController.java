// StaffController.java
package com.hospital.controller;

import com.hospital.dto.StaffDTO;
import com.hospital.mapper.StaffMapper;
import com.hospital.model.Staff;
import com.hospital.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService service;

    @Autowired
    private StaffMapper mapper;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody StaffDTO staffDTO) {
        service.addStaff(staffDTO);
        return ResponseEntity.ok("Staff added successfully");
    }

    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAll() {
        return ResponseEntity.ok(service.getAllStaff());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStaff(@PathVariable Long id, @RequestBody Staff dto) {
        Staff updated = service.updateStaff(id, dto);
        StaffDTO updatedDTO = mapper.toDTO(updated);
        return ResponseEntity.ok("Staff updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        service.deleteStaff(id);
        return ResponseEntity.ok("Staff deleted successfully");
    }

}