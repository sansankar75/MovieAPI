package com.example.moviebooking.controller;

import com.example.moviebooking.dao.Actor;
import com.example.moviebooking.service.ActorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    /**
     * Retrieves all actors.
     *
     * @return list of all actors
     */
    @GetMapping
    public List<Actor> getAll() {
        return actorService.getAll();
    }

    /**
     * Retrieves an actor by its ID.
     *
     * @param id unique identifier of the actor
     * @return the actor matching the given ID
     */
    @GetMapping("/{id}")
    public Actor getById(@PathVariable Integer id) {
        return actorService.getById(id);
    }

    /**
     * Creates a new actor.
     *
     * @param actorServiceBody actor data received in the request body
     * @return the newly created actor
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Actor create(@Valid @RequestBody Actor actorServiceBody) {
        return actorService.create(actorServiceBody);
    }

    /**
     * Updates an existing actor.
     *
     * @param id unique identifier of the actor to update
     * @param actorServiceBody updated actor data received in the request body
     * @return the updated actor
     */
    @PatchMapping("/{id}")
    public Actor update(
            @PathVariable Integer id,
            @Valid @RequestBody Actor actorServiceBody) {
        return actorService.update(id, actorServiceBody);
    }

    /**
     * Deletes an actor by its ID.
     *
     * @param id unique identifier of the actor to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        actorService.delete(id);
    }
}