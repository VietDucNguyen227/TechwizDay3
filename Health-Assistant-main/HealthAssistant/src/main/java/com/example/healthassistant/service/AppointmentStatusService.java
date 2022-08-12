package com.example.healthassistant.service;

import com.example.healthassistant.model.AppointmentStatus;

import java.util.List;
import java.util.Optional;

public interface AppointmentStatusService {
    List<AppointmentStatus> getAllAppointment();

    void saveAppointment(AppointmentStatus appointmentStatus);

    void deleteAppointment(long notificationId);

    Optional<AppointmentStatus> findAppointmentByID(long notificationId);

    AppointmentStatus getOne(long notificationId);

    Optional<AppointmentStatus> findbyUserId(Long id);
}
