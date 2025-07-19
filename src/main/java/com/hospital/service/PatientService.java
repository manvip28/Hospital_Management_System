package com.hospital.service;

import com.hospital.dto.PatientDTO;
import com.hospital.mapper.PatientMapper;
import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private PatientMapper mapper;

    public void addPatient(PatientDTO dto) {
        Patient patient = mapper.toEntity(dto);
        repository.save(patient);
    }

    public List<PatientDTO> getAllPatients() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Patient updatePatient(Long id, PatientDTO dto) {
        Optional<Patient> optionalPatient = repository.findById(id);
        if (optionalPatient.isEmpty()) {
            throw new RuntimeException("Patient not found with id: " + id);
        }

        Patient existing = optionalPatient.get();
        // Update fields from DTO
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setAddress(dto.getAddress());
        existing.setDateOfBirth(dto.getDateOfBirth());
        existing.setGender(dto.getGender());
        existing.setBloodGroup(dto.getBloodGroup());
        existing.setMedicalHistory(dto.getMedicalHistory());

        return repository.save(existing);
    }


    public void deletePatient(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
