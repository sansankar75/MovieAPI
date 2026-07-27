package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Show;
import com.example.moviebooking.service.ShowService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController = @Controller + @ResponseBody: every method return value
// is serialized straight to JSON by Jackson, no view template involved.
@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> getAll() {
        return showService.getAll();
    }

    @GetMapping("/{id}")
    public Show getById(@PathVariable Integer id) {
        return showService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Show create(@Valid @RequestBody Show showServiceBody) {
        return showService.create(showServiceBody);
    }

    @PutMapping("/{id}")
    public Show update(@PathVariable Integer id, @Valid @RequestBody Show showServiceBody) {
        return showService.update(id, showServiceBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        showService.delete(id);
    }
}
