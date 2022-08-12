package com.example.healthassistant.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PersonalHealthVitals {
    private long id;
    private Long userId;
    private String weight;
    private String height;
    private String bloodPressure;
    private String bloodGlucose;
    private String bloodOxygen;
    private String bodyTemperature;

    public PersonalHealthVitals() {
    }

    public PersonalHealthVitals(Long userId) {
        this.userId = userId;
    }

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
    @Column(name = "Weight")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "Height")
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Basic
    @Column(name = "BloodPressure")
    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    @Basic
    @Column(name = "BloodGlucose")
    public String getBloodGlucose() {
        return bloodGlucose;
    }

    public void setBloodGlucose(String bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    @Basic
    @Column(name = "BloodOxygen")
    public String getBloodOxygen() {
        return bloodOxygen;
    }

    public void setBloodOxygen(String bloodOxygen) {
        this.bloodOxygen = bloodOxygen;
    }

    @Basic
    @Column(name = "BodyTemperature")
    public String getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(String bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalHealthVitals that = (PersonalHealthVitals) o;
        return id == that.id && Objects.equals(userId, that.userId) && Objects.equals(weight, that.weight) && Objects.equals(height, that.height) && Objects.equals(bloodPressure, that.bloodPressure) && Objects.equals(bloodGlucose, that.bloodGlucose) && Objects.equals(bloodOxygen, that.bloodOxygen) && Objects.equals(bodyTemperature, that.bodyTemperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, weight, height, bloodPressure, bloodGlucose, bloodOxygen, bodyTemperature);
    }
}
