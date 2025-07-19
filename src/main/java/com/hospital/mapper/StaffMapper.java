package com.hospital.mapper;

import com.hospital.dto.StaffDTO;
import com.hospital.model.Staff;
import org.springframework.stereotype.Component;

@Component
public class StaffMapper {

    public Staff toEntity(StaffDTO dto) {
        Staff staff = new Staff();
        staff.setFirstName(dto.getFirstName());
        staff.setLastName(dto.getLastName());
        staff.setEmail(dto.getEmail());
        staff.setPhone(dto.getPhone());
        staff.setRole(dto.getRole());
        staff.setEmploymentStatus(dto.getEmploymentStatus());
        staff.setDepartment(dto.getDepartment());
        staff.setSalary(dto.getSalary());
        staff.setHireDate(dto.getHireDate());
        return staff;
    }

    public StaffDTO toDTO(Staff staff) {
        StaffDTO dto = new StaffDTO();
        dto.setFirstName(staff.getFirstName());
        dto.setLastName(staff.getLastName());
        dto.setEmail(staff.getEmail());
        dto.setPhone(staff.getPhone());
        dto.setRole(staff.getRole());
        dto.setEmploymentStatus(staff.getEmploymentStatus());
        dto.setDepartment(staff.getDepartment());
        dto.setSalary(staff.getSalary());
        dto.setHireDate(staff.getHireDate());
        return dto;
    }
}