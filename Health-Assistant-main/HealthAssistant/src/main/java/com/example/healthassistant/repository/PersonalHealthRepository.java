package com.example.healthassistant.repository;

import com.example.healthassistant.model.PersonalHealthVitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalHealthRepository extends JpaRepository<PersonalHealthVitals, Long> {

    Optional<PersonalHealthVitals> findByUserId(Long id);
}
