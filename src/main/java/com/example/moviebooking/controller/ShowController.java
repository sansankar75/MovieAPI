package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Show;
import com.example.moviebooking.service.ShowService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    /**
     * Retrieves all shows.
     *
     * @return list of all shows
     */
    @GetMapping
    public List<Show> getAll() {
        return showService.getAll();
    }

    /**
     * Retrieves a show by its ID.
     *
     * @param id unique identifier of the show
     * @return the show matching the given ID
     */
    @GetMapping("/{id}")
    public Show getById(@PathVariable Integer id) {
        return showService.getById(id);
    }

    /**
     * Creates a new show.
     *
     * @param showRequest show data received in the request body
     * @return the newly created show
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Show create(@Valid @RequestBody Show showRequest) {
        return showService.create(showRequest);
    }

    /**
     * Updates an existing show.
     *
     * @param id unique identifier of the show to update
     * @param showRequest updated show data received in the request body
     * @return the updated show
     */
    @PutMapping("/{id}")
    public Show update(
            @PathVariable Integer id,
            @Valid @RequestBody Show showRequest) {

        return showService.update(id, showRequest);
    }

    /**
     * Deletes a show by its ID.
     *
     * @param id unique identifier of the show to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        showService.delete(id);
    }
}
