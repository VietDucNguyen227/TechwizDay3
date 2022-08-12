package com.example.healthassistant.service;

import com.example.healthassistant.model.MedicineDosages;

import java.util.List;
import java.util.Optional;

public interface MedicineDosagesService {
    List<MedicineDosages> getAllMedicine();

    void saveMedicine(MedicineDosages medicineDosages);

    void deleteMedicine(long dosagesId);

    Optional<MedicineDosages> findMedicineByID(long dosagesId);

    MedicineDosages getOne(long dosagesId);

    Optional<MedicineDosages> findByUserId(Long id);
}
