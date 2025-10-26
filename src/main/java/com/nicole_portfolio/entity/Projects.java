package com.nicole_portfolio.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROJECTS")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "CATEGORY_FK")
    private Long categoryFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_fk", insertable = false, updatable = false)
    private Category category;


    @Column(name = "ACTIVE", length = 1)
    private String active;

    // Projects.java
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Media> medias;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getcreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public Long getCategoryFk() {
        return categoryFk;
    }

    public String getActive() {
        return active;
    }

    @Transient
    public String getCategoryName() {
        return category != null ? category.getCategory() : null;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setCategoryFk(Long categoryFk) {
        this.categoryFk = categoryFk;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
        for (Media media : medias) {
            media.setProject(this);
        }
    }
}
