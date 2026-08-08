package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Actor;
import com.example.moviebooking.service.ActorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAll() {
        return actorService.getAll();
    }

    @GetMapping("/{id}")
    public Actor getById(@PathVariable Integer id) {
        return actorService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Actor create(@Valid @RequestBody Actor actorServiceBody) {
        return actorService.create(actorServiceBody);
    }


    @PutMapping("/{id}")
    public Actor update(@PathVariable Integer id, @Valid @RequestBody Actor actorServiceBody) {
        return actorService.update(id, actorServiceBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        actorService.delete(id);
    }
}
