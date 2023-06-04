package com.example.demo.service.impl;



import com.example.demo.entities.Movies;
import com.example.demo.payload.MoviesDTO;
import com.example.demo.repositories.MoviesRepository;
import com.example.demo.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;
    public MoviesServiceImpl(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }





    @Override
    public MoviesDTO createMovies(MoviesDTO movieDTO) {
        Movies movies = mapToMovies(movieDTO);
        Movies save = moviesRepository.save(movies);

        return mapToMoviesDTO(save);
    }



        @Override
    public List<MoviesDTO> getLongestDurationMovies() {
        List<Movies> movies1 = moviesRepository.findTop10ByOrderByRuntimeMinutesDesc();
        List<MoviesDTO> moviesDTOS = new ArrayList<>();

        for (Movies movies : movies1) {
            moviesDTOS.add(mapToMoviesDTO(movies));
        }

        return moviesDTOS;
    }
    @Override
    public List<Object[]> getMoviesByGenreWithSubtotals() {
        return moviesRepository.findMoviesByGenreWithSubtotals();
    }

    @Override
    public void incrementRuntimeMinutes() {
        moviesRepository.incrementRuntimeMinutes();
    }




    private MoviesDTO mapToMoviesDTO(Movies movies) {
        MoviesDTO moviesDTO = new MoviesDTO();
        moviesDTO.setTconst(movies.getTconst());
        moviesDTO.setTitleType(movies.getTitleType());
        moviesDTO.setPrimaryTitle(movies.getPrimaryTitle());
        moviesDTO.setRuntimeMinutes(movies.getRuntimeMinutes());
        moviesDTO.setGenres(movies.getGenres());
        return moviesDTO;
    }

    private Movies mapToMovies(MoviesDTO moviesDTO) {
        Movies movies = new Movies();
        movies.setTconst(moviesDTO.getTconst());
        movies.setTitleType(moviesDTO.getTitleType());
        movies.setPrimaryTitle(moviesDTO.getPrimaryTitle());
        movies.setRuntimeMinutes(moviesDTO.getRuntimeMinutes());
        movies.setGenres(moviesDTO.getGenres());


        return movies;


    }
}



