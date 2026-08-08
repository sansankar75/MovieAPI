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

    /**
     * Retrieves all movies.
     *
     * @return list of all movies
     */
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id unique identifier of the movie
     * @return the movie matching the given ID
     * @throws ResourceNotFoundException if the movie does not exist
     */
    public Movie getById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id: " + id
                        ));
    }

    /**
     * Creates a new movie.
     *
     * @param movie movie data to be persisted
     * @return the newly created movie
     */
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Updates an existing movie.
     *
     * @param id unique identifier of the movie to update
     * @param updated updated movie data
     * @return the updated movie
     * @throws ResourceNotFoundException if the movie does not exist
     */
    public Movie update(Integer id, Movie updated) {
        Movie existing = getById(id);

        updated.setId(existing.getId());

        return movieRepository.save(updated);
    }

    /**
     * Deletes a movie by its ID.
     *
     * @param id unique identifier of the movie to delete
     * @throws ResourceNotFoundException if the movie does not exist
     */
    public void delete(Integer id) {
        Movie existing = getById(id);

        movieRepository.delete(existing);
    }
}