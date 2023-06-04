package com.example.demo.repositories;


import com.example.demo.entities.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingsRepository extends JpaRepository<Ratings,Long> {
    @Query(value = "SELECT m.tconst, m.primary_title, m.genres, r.average_rating,r.num_votes FROM assignment.movies_csv AS m JOIN assignment.ratings_csv AS r ON m.tconst = r.tconst WHERE r.average_rating > 6.0 ORDER BY r.average_rating DESC", nativeQuery = true)
    List<Ratings> findTopRatedMovies();
}
