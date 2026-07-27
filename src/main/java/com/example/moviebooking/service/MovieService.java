package com.example.moviebooking.service;

import com.example.moviebooking.entity.Movie;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie update(Integer id, Movie updated) {
        Movie existing = getById(id);
        updated.setId(existing.getId());
        return movieRepository.save(updated);
    }

    public void delete(Integer id) {
        Movie existing = getById(id);
        movieRepository.delete(existing);
    }
}
