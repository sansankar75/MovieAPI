package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Genre;
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

    @GetMapping
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public Genre getById(@PathVariable Integer id) {
        return genreService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre create(@Valid @RequestBody Genre genreServiceBody) {
        return genreService.create(genreServiceBody);
    }

    @PutMapping("/{id}")
    public Genre update(@PathVariable Integer id, @Valid @RequestBody Genre genreServiceBody) {
        return genreService.update(id, genreServiceBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        genreService.delete(id);
    }
}
