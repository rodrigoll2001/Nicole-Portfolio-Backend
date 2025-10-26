package com.nicole_portfolio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "ACTIVE", length = 1)
    private String active;

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getActive() {
        return active;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setActive(String active){
        this.active = active;
    }
}
