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
@Table(name = "ratings.csv")
public class Ratings {
    @Id
    private String tconst;
    @Column(name = "average_rating")
    private Double averageRating;
    @Column(name = "num_votes")

    private String numVotes;

    // constructors, getters, and setters
}



