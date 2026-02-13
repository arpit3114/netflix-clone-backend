package com.streamflix.netflix.controller;

import com.streamflix.netflix.entity.Movie;
import com.streamflix.netflix.service.MovieService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/search")
    public List<Movie> search(@RequestParam String title){
        return movieService.searchByTitle(title);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> byGenre(@PathVariable String genre){
        return movieService.getByGenre(genre);
    }

    @GetMapping("/sorted")
    public List<Movie> latestMovies(){
        return movieService.latest();
    }

    @GetMapping("/page")
    public Page<Movie> getMovies(
            @RequestParam int page,
            @RequestParam int size){
        return movieService.getMovies(page, size);
    }
}
