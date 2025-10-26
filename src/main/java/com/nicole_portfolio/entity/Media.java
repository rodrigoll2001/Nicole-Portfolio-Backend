package com.nicole_portfolio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "MEDIA")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "PROJECT_FK")
//    private Long projectFk;

    // Media.java
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_FK")
    @JsonBackReference
    private Projects project;
    ;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "URL")
    private String url;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ACTIVE", length = 1)
    private String active;

    public Long getId() {
        return id;
    }

//    public Long getProjectFk(){
//        return projectFk;
//    }

    public String getType(){
        return type;
    }

    public String getUrl(){
        return url;
    }

    public String getDescription(){
        return description;
    }

    public String getActive(){
        return active;
    }

//    public void setProjectFk(Long projectFk){
//        this.projectFk = projectFk;
//    }

    public void setType(String type){
        this.type = type;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setActive(String active){
        this.active = active;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

}
