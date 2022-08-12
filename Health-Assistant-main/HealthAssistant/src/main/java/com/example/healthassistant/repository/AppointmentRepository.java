package com.example.healthassistant.repository;

import com.example.healthassistant.model.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentStatus, Long> {
    Optional<AppointmentStatus> findByUserId(Long id);

}
