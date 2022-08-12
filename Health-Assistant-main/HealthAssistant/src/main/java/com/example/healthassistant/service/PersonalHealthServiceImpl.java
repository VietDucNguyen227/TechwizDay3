package com.example.healthassistant.service;

import com.example.healthassistant.model.PersonalHealthVitals;
import com.example.healthassistant.repository.PersonalHealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalHealthServiceImpl implements PersonalHealthService{

    @Autowired
    PersonalHealthRepository personalHealthRepository;

    @Override
    public List<PersonalHealthVitals> getAllPersonalHealth() {
        return personalHealthRepository.findAll();
    }

    @Override
    public void savePersonalHealth(PersonalHealthVitals personalHealthVitals) {
        personalHealthRepository.save(personalHealthVitals);
    }

    @Override
    public void deletePersonalHealth(long id) {
        personalHealthRepository.deleteById(id);
    }

    @Override
    public Optional<PersonalHealthVitals> findPersonalHealthByID(long id) {
        return personalHealthRepository.findById(id);
    }

    @Override
    public PersonalHealthVitals getOne(long id) {
        return personalHealthRepository.findById(id).get();
    }

    @Override
    public Optional<PersonalHealthVitals> findByUserId(Long id) {
        return personalHealthRepository.findByUserId(id);
    }
}
