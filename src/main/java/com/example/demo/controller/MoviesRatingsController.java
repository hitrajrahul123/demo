package com.example.demo.controller;




import com.example.demo.payload.MoviesDTO;
import com.example.demo.payload.RatingsDTO;
import com.example.demo.service.MoviesService;
import com.example.demo.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Controller
@RequestMapping("/api/v1")
public class MoviesRatingsController {

    @Autowired
    private MoviesService moviesService;
    @Autowired
    private RatingsService ratingsService;


    public MoviesRatingsController(MoviesService moviesService, RatingsService ratingsService) {
        this.moviesService = moviesService;
        this.ratingsService = ratingsService;

    }


 //http://localhost:2020/api/v1/new-movie
    @PostMapping("/new-movie")
    public ResponseEntity<MoviesDTO> createNewMovie(@RequestBody MoviesDTO movieDTO) {
        MoviesDTO movies = moviesService.createMovies(movieDTO);
        return new ResponseEntity<>(movies, HttpStatus.OK);


    }
    //http://localhost:2020/api/v1/new-rating
@PostMapping("/new-rating")
    public ResponseEntity<RatingsDTO> createRatings(@RequestBody RatingsDTO ratingsDTO) {
        RatingsDTO ratingsDTO1 = ratingsService.createRatings(ratingsDTO);
        return new ResponseEntity<>(ratingsDTO1, HttpStatus.OK);
    }

    // http://localhost:2020/api/v1/longest-duration-movies
     @GetMapping("/longest-duration-movies")
     public ResponseEntity<List<MoviesDTO>> getLongestDurationMovies() {
         List<MoviesDTO> longestDurationMovies = moviesService.getLongestDurationMovies();
         return ResponseEntity.ok(longestDurationMovies);
     }
    //http://localhost:2020/api/v1/top-rated-movies
    @GetMapping("/top-rated-movies")
    public ResponseEntity<List<RatingsDTO>> getTopRatedRating() {
        List<RatingsDTO> topRatedMovies = ratingsService.getTopRatedRating();
        return ResponseEntity.ok(topRatedMovies);
    }
    //http://localhost:2020/api/v1/genre-movies-with-subtotals
    @GetMapping("/genre-movies-with-subtotals")
    public ResponseEntity<List<Object[]>> getMoviesByGenreWithSubtotals() {
        List<Object[]> genreMoviesWithSubtotals = moviesService.getMoviesByGenreWithSubtotals();
        return ResponseEntity.ok(genreMoviesWithSubtotals);
    }
    @PutMapping("/update-runtime-minutes")
    public ResponseEntity<String> updateRuntimeMinutes() {
        moviesService.incrementRuntimeMinutes();
        return ResponseEntity.ok("Runtime minutes updated successfully.");
    }




}
