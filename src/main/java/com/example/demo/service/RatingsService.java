package com.example.demo.service;


import com.example.demo.payload.RatingsDTO;

import java.util.List;

public interface RatingsService {
    RatingsDTO createRatings(RatingsDTO ratingsDTO);

  //  MoviesDTO createMovies(MoviesDTO movieDTO);

   // List<RatingsDTO> getTopRatedMovies();

    List<RatingsDTO> getTopRatedRating();

}
