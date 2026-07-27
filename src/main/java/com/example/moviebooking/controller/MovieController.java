package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Movie;
import com.example.moviebooking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController = @Controller + @ResponseBody: every method return value
// is serialized straight to JSON by Jackson, no view template involved.
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable Integer id) {
        return movieService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@Valid @RequestBody Movie movieServiceBody) {
        return movieService.create(movieServiceBody);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Integer id, @Valid @RequestBody Movie movieServiceBody) {
        return movieService.update(id, movieServiceBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        movieService.delete(id);
    }
}
