package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movies.csv")
public class Movies {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tconst",nullable = false)
    private String tconst;
    @Column(name = "title_type",nullable = false)
    private String titleType;
    @Column(name = "primary_title",nullable = false)
    private String primaryTitle;
    @Column(name = "runtime_minutes",nullable = false)
    private String runtimeMinutes;
    @Column(name = "genres",nullable = false)
    private String genres;


    // constructors, getters, and setters
}

