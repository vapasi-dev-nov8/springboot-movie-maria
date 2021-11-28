package com.springBoot.repository.demo.service;

import com.springBoot.repository.demo.dto.MovieDto;
import com.springBoot.repository.demo.entity.MovieEntity;
import com.springBoot.repository.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    MovieRepository movieRepository;
    private String Iterable;

    @Autowired
    public MovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAllMovies() {
        List<MovieDto> movieDto = new ArrayList<>();

        for (MovieEntity movieEntity : movieRepository.findAll()) {
            movieDto.add(MovieDto.dtoFrom(movieEntity));
        }
        return movieDto;
    }

    public MovieDto saveMovie(MovieDto movieDto) {
        MovieEntity movieEntity = MovieEntity.entityFrom(movieDto);
        MovieEntity savedMovieEntity = movieRepository.save(movieEntity);
        return MovieDto.dtoFrom(savedMovieEntity);
    }

    public Optional<MovieDto> getMovie(Integer Id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById((Id));
        return movieEntity.map(MovieDto::dtoFrom);
    }

    public List<MovieDto> getMovieActorName(String actorName) {

        List<MovieDto> movieDtoByActorName = new ArrayList<>();

        for (MovieEntity movieEntity : movieRepository.findByActorName(actorName)) {
            movieDtoByActorName.add(MovieDto.dtoFrom(movieEntity));
        }
        return movieDtoByActorName;
    }

    public MovieDto updateMovie(Integer Id, MovieDto movie) {
        MovieEntity requestMovieEntity = MovieEntity.entityFrom(movie);

        Optional<MovieEntity> movieEntity = movieRepository.findById(Id);
        if(movieEntity.isPresent())
        {
            MovieEntity savedMovieEntity = movieEntity.get();
            savedMovieEntity.setName(requestMovieEntity.getName());
            savedMovieEntity.setActorName(requestMovieEntity.getActorName());
            savedMovieEntity.setDirectorName(requestMovieEntity.getDirectorName());
            movieRepository.save(savedMovieEntity);
            MovieDto updateMovie = MovieDto.dtoFrom(savedMovieEntity);
            return updateMovie;
        }
        return null;
    }
}
