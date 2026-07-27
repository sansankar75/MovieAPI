package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Theater;
import com.example.moviebooking.service.TheaterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController = @Controller + @ResponseBody: every method return value
// is serialized straight to JSON by Jackson, no view template involved.
@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<Theater> getAll() {
        return theaterService.getAll();
    }

    @GetMapping("/{id}")
    public Theater getById(@PathVariable Integer id) {
        return theaterService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Theater create(@Valid @RequestBody Theater theaterServiceBody) {
        return theaterService.create(theaterServiceBody);
    }

    @PutMapping("/{id}")
    public Theater update(@PathVariable Integer id, @Valid @RequestBody Theater theaterServiceBody) {
        return theaterService.update(id, theaterServiceBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        theaterService.delete(id);
    }
}
