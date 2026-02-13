package com.streamflix.netflix.service;

import com.streamflix.netflix.entity.Movie;
import com.streamflix.netflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> searchByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getByGenre(String genre){
        return movieRepository.findByGenreIgnoreCase(genre);
    }

    public List<Movie> latest(){
        return movieRepository.findAllByOrderByReleaseYearDesc();
    }

    public Page<Movie> getMovies(int page, int size){
        return movieRepository.findAll(PageRequest.of(page, size));
    }

}
