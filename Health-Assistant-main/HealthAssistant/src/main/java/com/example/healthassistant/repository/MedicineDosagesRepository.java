package com.example.healthassistant.repository;

import com.example.healthassistant.model.MedicineDosages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MedicineDosagesRepository extends JpaRepository<MedicineDosages, Long> {
    Optional<MedicineDosages> findByUserId(Long id);
}
