package com.example.healthassistant.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Medicine {
    private long id;
    private String medicineName;

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
    @Column(name = "MedicineName")
    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id && Objects.equals(medicineName, medicine.medicineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medicineName);
    }
}
