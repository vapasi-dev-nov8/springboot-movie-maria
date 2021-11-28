package com.springBoot.repository.demo.controller;

import com.springBoot.repository.demo.dto.MovieDto;
import com.springBoot.repository.demo.repository.MovieRepository;
import com.springBoot.repository.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

        MovieService movieService;
        MovieRepository movieRepository;

        @Autowired
        public MovieController(MovieService movieService) {
            this.movieService = movieService;
        }

        @GetMapping("/")
        public ResponseEntity<List<MovieDto>> getMovies() {
            List<MovieDto> allMovieDto = movieService.getAllMovies();
            return ResponseEntity.ok().body(allMovieDto);
        }

        @PostMapping("/")
        public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto) {
            MovieDto movieDtoWithId = movieService.saveMovie(movieDto);
            return new ResponseEntity<>(movieDtoWithId, HttpStatus.CREATED);
        }

        @GetMapping("/{Id}")
        public ResponseEntity<MovieDto> getMovieId(@PathVariable Integer Id)
        {
            Optional<MovieDto> movie = movieService.getMovie(Id);
            if(movie.isPresent())
                return ResponseEntity.ok().body(movie.get());
            return ResponseEntity.notFound().build();
        }

        @GetMapping("/actor/{actorName}")
        public ResponseEntity<List<MovieDto>> getMovieByActorName(@PathVariable String actorName)
        {
            List<MovieDto> movie = movieService.getMovieActorName(actorName);
            if(movie.size()>0)
            {
                //List<MovieDto> allMovieDto = movieService.getAllMovies();
                return ResponseEntity.ok().body(movie);
            }
            return ResponseEntity.notFound().build();
        }

    @PutMapping("/updateMovie/{Id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable Integer Id, @RequestBody MovieDto movie) {

            MovieDto updateMovie = movieService.updateMovie(Id,movie);

        return new ResponseEntity<MovieDto>(updateMovie, HttpStatus.OK);
    }
}
