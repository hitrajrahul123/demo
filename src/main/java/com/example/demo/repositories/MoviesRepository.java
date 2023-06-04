package com.example.demo.repositories;


import com.example.demo.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {



        @Query(value = "SELECT tconst,primary_title,title_type, runtime_minutes, genres  FROM assignment.movies_csv ORDER BY runtime_minutes DESC limit 10", nativeQuery = true)
    List<Movies> findTop10ByOrderByRuntimeMinutesDesc();

    @Query(value = "SELECT m.genres, m.primary_title, SUM(r.num_votes) AS total_votes FROM movies_csv m JOIN ratings_csv r ON m.tconst = r.tconst GROUP BY m.genres, m.primary_title WITH ROLLUP", nativeQuery = true)

    List<Object[]> findMoviesByGenreWithSubtotals();
    @Query(value = "UPDATE movies_csv SET runtime_minutes =  CASE WHEN genres = 'Documentary' THEN runtime_minutes + 15 WHEN genres = 'Animation' THEN runtime_minutes  + 30 END WHERE genres IN ('Documentary', 'Animation')"
          , nativeQuery = true)

    void incrementRuntimeMinutes();

}


