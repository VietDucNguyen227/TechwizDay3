package com.example.healthassistant.service;

import com.example.healthassistant.model.Feedback;
import java.util.List;
import java.util.Optional;

public interface FeedBackService {
    List<Feedback> getAllFeedback();

    void saveFeedback(Feedback feedback);

    void deleteFeedback(long id);

    Optional<Feedback> findFeedBackByID(long id);

    Feedback getOne(long id);

    Optional<Feedback> findByUserId(Long id);
}
