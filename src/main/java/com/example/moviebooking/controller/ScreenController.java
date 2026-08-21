package com.example.moviebooking.controller;

import com.example.moviebooking.dao.Screen;
import com.example.moviebooking.service.ScreenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    /**
     * Retrieves all screens.
     *
     * @return list of all screens
     */
    @GetMapping
    public List<Screen> getAll() {
        return screenService.getAll();
    }

    /**
     * Retrieves a screen by its ID.
     *
     * @param id unique identifier of the screen
     * @return the screen matching the given ID
     */
    @GetMapping("/{id}")
    public Screen getById(@PathVariable Integer id) {
        return screenService.getById(id);
    }

    /**
     * Creates a new screen.
     *
     * @param screenRequest screen data received in the request body
     * @return the newly created screen
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Screen create(@Valid @RequestBody Screen screenRequest) {
        return screenService.create(screenRequest);
    }

    /**
     * Updates an existing screen.
     *
     * @param id unique identifier of the screen to update
     * @param screenRequest updated screen data received in the request body
     * @return the updated screen
     */
    @PatchMapping("/{id}")
    public Screen update(
            @PathVariable Integer id,
            @Valid @RequestBody Screen screenRequest) {

        return screenService.update(id, screenRequest);
    }


    /**
     * Deletes a screen by its ID.
     *
     * @param id unique identifier of the screen to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        screenService.delete(id);
    }
}

