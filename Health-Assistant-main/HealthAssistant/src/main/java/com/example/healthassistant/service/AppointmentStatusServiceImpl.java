package com.example.healthassistant.service;

import com.example.healthassistant.model.AppointmentStatus;
import com.example.healthassistant.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentStatusServiceImpl implements AppointmentStatusService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentStatus> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    @Override
    public void saveAppointment(AppointmentStatus appointmentStatus) {
        appointmentRepository.save(appointmentStatus);
    }

    @Override
    public void deleteAppointment(long notificationId) {
        appointmentRepository.deleteById(notificationId);
    }

    @Override
    public Optional<AppointmentStatus> findAppointmentByID(long notificationId) {
        return appointmentRepository.findById(notificationId);
    }

    @Override
    public AppointmentStatus getOne(long notificationId) {
        return appointmentRepository.findById(notificationId).get();
    }

    @Override
    public Optional<AppointmentStatus> findbyUserId(Long id) {
        return appointmentRepository.findByUserId(id);
    }
}
