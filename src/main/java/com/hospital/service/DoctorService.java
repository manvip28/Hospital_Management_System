package com.hospital.service;

import com.hospital.dto.DoctorDTO;
import com.hospital.mapper.DoctorMapper;
import com.hospital.model.Doctor;
import com.hospital.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private DoctorMapper mapper;

    public void addDoctor(DoctorDTO dto) {
        Doctor doctor = mapper.toEntity(dto);
        doctor.setCreatedAt(LocalDateTime.now());
        doctor.setUpdatedAt(LocalDateTime.now());
        repository.save(doctor);
    }

    public List<DoctorDTO> getAllDoctors() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Doctor updateDoctor(Long id, DoctorDTO dto) {
        Doctor existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + id));

        // Update fields from DTO
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setSpecialization(dto.getSpecialization());
        existing.setExperienceYears(dto.getExperienceYears());
        existing.setConsultationFee(dto.getConsultationFee());
        existing.setAvailabilityStatus(dto.getAvailabilityStatus());
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    public void deleteDoctor(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Doctor not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}
