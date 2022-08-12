package com.example.healthassistant.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class IssuePersonal {
    private long id;
    private Long categoryId;
    private String name;
    private String description;
    private String symptom;
    private String prevention;
    private String thumbnail;
    private Byte status;
    private String slug;
    private Integer highlight;

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
    @Column(name = "CategoryId")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Symptom")
    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Basic
    @Column(name = "Prevention")
    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    @Basic
    @Column(name = "Thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Basic
    @Column(name = "Status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Slug")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Basic
    @Column(name = "Highlight")
    public Integer getHighlight() {
        return highlight;
    }

    public void setHighlight(Integer highlight) {
        this.highlight = highlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuePersonal that = (IssuePersonal) o;
        return id == that.id && Objects.equals(categoryId, that.categoryId) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(symptom, that.symptom) && Objects.equals(prevention, that.prevention) && Objects.equals(thumbnail, that.thumbnail) && Objects.equals(status, that.status) && Objects.equals(slug, that.slug) && Objects.equals(highlight, that.highlight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, name, description, symptom, prevention, thumbnail, status, slug, highlight);
    }
}
