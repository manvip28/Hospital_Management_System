package com.hospital.service;

import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.AppointmentSummaryDTO;
import com.hospital.mapper.AppointmentMapper;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private AppointmentMapper mapper;

    public AppointmentDTO addAppointment(AppointmentDTO dto) {
        Patient patient = patientRepo.findById(dto.getPatientId()).orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepo.findById(dto.getDoctorId()).orElseThrow(() -> new RuntimeException("Doctor not found"));
        Appointment appointment = mapper.toEntity(dto, patient, doctor);
        return mapper.toDTO(appointmentRepo.save(appointment));
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<AppointmentSummaryDTO> getAllAppointmentsSummary() {
        return appointmentRepo.findAll()
                .stream()
                .map(mapper::toSummaryDTO)
                .collect(Collectors.toList());
    }

    public Appointment updateAppointment(Long id, AppointmentDTO dto) {
        Appointment existing = appointmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with ID: " + id));

        Patient patient = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepo.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Update fields
        existing.setPatient(patient);
        existing.setDoctor(doctor);
        existing.setAppointmentDate(dto.getAppointmentDate());
        existing.setAppointmentTime(dto.getAppointmentTime());
        existing.setStatus(Appointment.Status.valueOf(dto.getStatus()));
        existing.setReason(dto.getReason());
        existing.setNotes(dto.getNotes());
        existing.setUpdatedAt(LocalDateTime.now());

        return appointmentRepo.save(existing);
    }

    public void deleteAppointment(Long id) {
        if (!appointmentRepo.existsById(id)) {
            throw new RuntimeException("Appointment not found with ID: " + id);
        }
        appointmentRepo.deleteById(id);
    }

}
