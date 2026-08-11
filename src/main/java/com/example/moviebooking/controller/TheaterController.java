package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Theater;
import com.example.moviebooking.service.TheaterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    /**
     * Retrieves all theaters.
     *
     * @return list of all theaters
     */
    @GetMapping
    public List<Theater> getAll() {
        return theaterService.getAll();
    }

    /**
     * Retrieves a theater by its ID.
     *
     * @param id unique identifier of the theater
     * @return the theater matching the given ID
     */
    @GetMapping("/{id}")
    public Theater getById(@PathVariable Integer id) {
        return theaterService.getById(id);
    }

    /**
     * Creates a new theater.
     *
     * @param theaterRequest theater data received in the request body
     * @return the newly created theater
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Theater create(@Valid @RequestBody Theater theaterRequest) {
        return theaterService.create(theaterRequest);
    }

    /**
     * Updates an existing theater.
     *
     * @param id unique identifier of the theater to update
     * @param theaterRequest updated theater data received in the request body
     * @return the updated theater
     */
    @PatchMapping("/{id}")
    public Theater update(
            @PathVariable Integer id,
            @Valid @RequestBody Theater theaterRequest) {

        return theaterService.update(id, theaterRequest);
    }

    /**
     * Deletes a theater by its ID.
     *
     * @param id unique identifier of the theater to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        theaterService.delete(id);
    }
}
