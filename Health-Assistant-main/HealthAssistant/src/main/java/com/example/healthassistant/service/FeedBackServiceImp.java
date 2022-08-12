package com.example.healthassistant.service;

import com.example.healthassistant.model.Feedback;
import com.example.healthassistant.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedBackServiceImp implements FeedBackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public Optional<Feedback> findFeedBackByID(long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public Feedback getOne(long id) {
        return feedbackRepository.findById(id).get();
    }

    @Override
    public Optional<Feedback> findByUserId(Long id) {
        return feedbackRepository.findByUserId(id);
    }

}
