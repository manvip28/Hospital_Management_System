// StaffService.java
package com.hospital.service;
import com.hospital.dto.StaffDTO;
import com.hospital.mapper.StaffMapper;
import com.hospital.model.Staff;
import com.hospital.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    @Autowired
    private StaffMapper mapper;

    public void addStaff(StaffDTO dto) {
        Staff staff = mapper.toEntity(dto);
        repository.save(staff);
    }

    public List<StaffDTO> getAllStaff() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Staff updateStaff(Long id, Staff dto) {
        Optional<Staff> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Staff not found with ID: " + id);
        }
        Staff existing = optional.get();
        // update fields manually from DTO
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setRole(dto.getRole());
        existing.setEmploymentStatus(dto.getEmploymentStatus());
        existing.setDepartment(dto.getDepartment());
        existing.setSalary(dto.getSalary());
        existing.setHireDate(dto.getHireDate());

        return repository.save(existing);
    }

    public void deleteStaff(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Staff not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}
