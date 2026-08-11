package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Movie;
import com.example.moviebooking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Retrieves all movies.
     *
     * @return list of all movies
     */
    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id unique identifier of the movie
     * @return the movie matching the given ID
     */
    @GetMapping("/{id}")
    public Movie getById(@PathVariable Integer id) {
        return movieService.getById(id);
    }

    /**
     * Creates a new movie.
     *
     * @param movieRequest movie data received in the request body
     * @return the newly created movie
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@Valid @RequestBody Movie movieRequest) {
        return movieService.create(movieRequest);
    }

    /**
     * Updates an existing movie.
     *
     * @param id unique identifier of the movie to update
     * @param movieRequest updated movie data received in the request body
     * @return the updated movie
     */
    @PatchMapping("/{id}")
    public Movie update(
            @PathVariable Integer id,
            @Valid @RequestBody Movie movieRequest) {

        return movieService.update(id, movieRequest);
    }

    /**
     * Deletes a movie by its ID.
     *
     * @param id unique identifier of the movie to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        movieService.delete(id);
    }
}
