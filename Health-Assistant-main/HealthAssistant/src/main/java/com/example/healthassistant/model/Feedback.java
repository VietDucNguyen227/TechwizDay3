package com.example.healthassistant.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Feedback {
    private long id;
    private Long userId;
    private String feedback;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "User_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback1 = (Feedback) o;
        return id == feedback1.id && Objects.equals(userId, feedback1.userId) && Objects.equals(feedback, feedback1.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, feedback);
    }
}
