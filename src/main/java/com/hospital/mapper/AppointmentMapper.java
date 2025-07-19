package com.hospital.mapper;

import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.AppointmentSummaryDTO;
import com.hospital.model.Appointment;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDTO toDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setPatientId(appointment.getPatient().getId());
        dto.setDoctorId(appointment.getDoctor().getId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        dto.setStatus(appointment.getStatus().name());
        dto.setReason(appointment.getReason());
        dto.setNotes(appointment.getNotes());
        return dto;
    }

    public Appointment toEntity(AppointmentDTO dto, Patient patient, Doctor doctor) {
        Appointment appointment = new Appointment();
        appointment.setId(dto.getId());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setAppointmentTime(dto.getAppointmentTime());
        if (dto.getStatus() != null) {
            appointment.setStatus(Appointment.Status.valueOf(dto.getStatus()));
        }
        appointment.setReason(dto.getReason());
        appointment.setNotes(dto.getNotes());
        return appointment;
    }

    public AppointmentSummaryDTO toSummaryDTO(Appointment appointment) {
        AppointmentSummaryDTO dto = new AppointmentSummaryDTO();

        // Format doctor name as "Dr. FirstName LastName"
        String doctorName = "Dr. " + appointment.getDoctor().getFirstName() + " " + appointment.getDoctor().getLastName();
        dto.setDoctorName(doctorName);

        // Format patient name as "FirstName LastName"
        String patientName = appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName();
        dto.setPatientName(patientName);

        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        dto.setStatus(appointment.getStatus());
        dto.setReason(appointment.getReason());
        dto.setNotes(appointment.getNotes());

        return dto;
    }
}