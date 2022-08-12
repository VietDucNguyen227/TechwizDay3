package com.example.healthassistant.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class AppointmentStatus {
    private long notificationId;
    private Long userId;
    private Date date;
    private String time;
    private String location;
    private String description;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NotificationId")
    public long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }

    @Basic
    @Column(name = "UserId")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentStatus that = (AppointmentStatus) o;
        return notificationId == that.notificationId && Objects.equals(userId, that.userId) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(location, that.location) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationId, userId, date, time, location, description);
    }
}
