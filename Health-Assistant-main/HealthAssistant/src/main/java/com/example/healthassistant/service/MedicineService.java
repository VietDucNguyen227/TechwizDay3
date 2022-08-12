package com.example.healthassistant.service;

import com.example.healthassistant.model.Feedback;
import com.example.healthassistant.model.Medicine;

import java.util.List;
import java.util.Optional;

public interface MedicineService {
    List<Medicine> getAllMedicine();

    void saveMedicine(Medicine medicine);

    void deleteMedicine(long id);

    Optional<Medicine> findMedicineByID(long id);

    Medicine getOne(long id);

    Optional<Medicine> findByUserId(Long id);
}
