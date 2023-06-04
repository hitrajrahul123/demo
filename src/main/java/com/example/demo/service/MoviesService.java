package com.example.demo.service;




import com.example.demo.payload.MoviesDTO;

import java.util.List;

public interface MoviesService {
    MoviesDTO createMovies(MoviesDTO movieDTO);

    List<MoviesDTO> getLongestDurationMovies();

   List<Object[]> getMoviesByGenreWithSubtotals();


    void incrementRuntimeMinutes();}
