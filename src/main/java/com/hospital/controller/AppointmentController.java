package com.hospital.controller;

import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.AppointmentSummaryDTO;
import com.hospital.mapper.AppointmentMapper;
import com.hospital.model.Appointment;
import com.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @Autowired
    private AppointmentMapper mapper;

    @PostMapping
    public AppointmentDTO createAppointment(@RequestBody AppointmentDTO dto) {
        return service.addAppointment(dto);
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return service.getAllAppointments();
    }
    @GetMapping("/summary")
    public List<AppointmentSummaryDTO> getSummaryAppointments() {
        return service.getAllAppointmentsSummary();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO dto) {
        Appointment updated = service.updateAppointment(id, dto);
        AppointmentDTO updatedDTO = mapper.toDTO(updated);
        return ResponseEntity.ok("Appointment updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        service.deleteAppointment(id);
        return ResponseEntity.ok("Appointment deleted successfully");
    }
}
