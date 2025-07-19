package com.hospital.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.hospital.model.Appointment;

public class AppointmentSummaryDTO {

    private String doctorName;
    private String patientName;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Appointment.Status status;
    private String reason;
    private String notes;

    // Getters and Setters

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Appointment.Status getStatus() {
        return status;
    }

    public void setStatus(Appointment.Status status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
