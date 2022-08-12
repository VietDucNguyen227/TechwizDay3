package com.example.healthassistant.service;

import com.example.healthassistant.model.Medicine;
import com.example.healthassistant.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImp implements MedicineService {
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
    }

    @Override
    public void saveMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    @Override
    public void deleteMedicine(long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public Optional<Medicine> findMedicineByID(long id) {
        return medicineRepository.findById(id);
    }

    @Override
    public Medicine getOne(long id) {
        return medicineRepository.findById(id).get();
    }

    @Override
    public Optional<Medicine> findByUserId(Long id) {
        return medicineRepository.findByUserId(id);
    }
}
