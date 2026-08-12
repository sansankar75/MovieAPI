package com.example.moviebooking.service;

import com.example.moviebooking.comman.EntityStatus;
import com.example.moviebooking.dao.Movie;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Retrieves all active movies.
     *
     * @return list of all active movies
     */
    public List<Movie> getAll() {

        List<Movie> movies = movieRepository.findAll();
        List<Movie> activeMovies = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getStatus().equals(EntityStatus.ACTIVE)) {
                activeMovies.add(movie);
            }
        }

        return activeMovies;
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id unique identifier of the movie
     * @return the movie matching the given ID
     * @throws ResourceNotFoundException if the movie does not exist
     */
    public Movie getById(Integer id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id: " + id
                        ));

        // Check if movie is inactive
        if (EntityStatus.INACTIVE.equals(movie.getStatus())) {
            throw new ResourceNotFoundException(
                    "Movie is inactive: " + id
            );
        }

        return movie;
    }

    /**
     * Creates a new movie.
     *
     * @param movie movie data to be persisted
     * @return the newly created movie
     */
    public Movie create(Movie movie) {

        movie.setStatus(EntityStatus.ACTIVE);

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
    public Movie update(Integer id, Movie updated) throws ResourceNotFoundException {

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

        existing.setStatus(EntityStatus.INACTIVE);

        movieRepository.save(existing);
    }
}