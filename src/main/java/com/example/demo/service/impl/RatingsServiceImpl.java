package com.example.demo.service.impl;


import com.example.demo.entities.Ratings;
import com.example.demo.payload.RatingsDTO;
import com.example.demo.repositories.RatingsRepository;
import com.example.demo.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingsServiceImpl implements RatingsService {
    @Autowired
    private RatingsRepository ratingsRepository;

    public RatingsServiceImpl(RatingsRepository ratingsRepository) {
        this.ratingsRepository = ratingsRepository;
    }

    @Override
    public RatingsDTO createRatings(RatingsDTO ratingsDTO) {
        Ratings ratings = mapToRatings(ratingsDTO);
        ratings = ratingsRepository.save(ratings);
        return mapToRatingsDTO(ratings);
    }




    @Override
    public List<RatingsDTO> getTopRatedRating() {
        List<Ratings> ratings = ratingsRepository.findTopRatedMovies();
        List<RatingsDTO> ratingsDTOS = new ArrayList<>();

        for (Ratings ratings1 : ratings) {
            ratingsDTOS.add(mapToRatingsDTO(ratings1));
       }
        return ratingsDTOS;

        //    @Override
//    public List<MoviesDTO> getTopRatedMovies() {
//        List<Movies> movies = moviesRepository.findTopRatedMovies();
//        List<MoviesDTO> moviesDTOs = new ArrayList<>();
//
//        for (Movies movie : movies) {
//
//            moviesDTOs.add(mapToMoviesDTO(movie));
//        }
//
//        return moviesDTOs;
   }



    private RatingsDTO mapToRatingsDTO(Ratings ratings) {
        RatingsDTO ratingsDTO = new RatingsDTO();
        ratingsDTO.setTconst(ratings.getTconst());
        ratingsDTO.setAverageRating(ratings.getAverageRating());
        ratingsDTO.setNumVotes(ratings.getNumVotes());
        return ratingsDTO;
    }

    private Ratings mapToRatings(RatingsDTO ratingsDTO) {
        Ratings ratings = new Ratings();
        ratings.setTconst(ratingsDTO.getTconst());
        ratings.setAverageRating(ratingsDTO.getAverageRating());
        ratings.setNumVotes(ratingsDTO.getNumVotes());
        return ratings;


    }


}

