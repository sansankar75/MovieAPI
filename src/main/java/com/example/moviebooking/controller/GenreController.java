package com.example.moviebooking.controller;

import com.example.moviebooking.dao.Genre;
import com.example.moviebooking.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    /**
     * Retrieves all genres.
     *
     * @return list of all genres
     */
    @GetMapping
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    /**
     * Retrieves a genre by its ID.
     *
     * @param id unique identifier of the genre
     * @return the genre matching the given ID
     */
    @GetMapping("/{id}")
    public Genre getById(@PathVariable Integer id) {
        return genreService.getById(id);
    }

    /**
     * Creates a new genre.
     *
     * @param genreRequest genre data received in the request body
     * @return the newly created genre
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre create(@Valid @RequestBody Genre genreRequest) {
        return genreService.create(genreRequest);
    }

    /**
     * Updates an existing genre.
     *
     * @param id unique identifier of the genre to update
     * @param genreRequest updated genre data received in the request body
     * @return the updated genre
     */
    @PatchMapping("/{id}")
    public Genre update(
            @PathVariable Integer id,
            @Valid @RequestBody Genre genreRequest) {

        return genreService.update(id, genreRequest);
    }

}

