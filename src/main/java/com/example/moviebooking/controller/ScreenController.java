package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Screen;
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

    @GetMapping
    public List<Screen> getAll() {
        return screenService.getAll();
    }

    @GetMapping("/{id}")
    public Screen getById(@PathVariable Integer id) {
        return screenService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Screen create(@Valid @RequestBody Screen screenServiceBody) {
        return screenService.create(screenServiceBody);
    }

    @PutMapping("/{id}")
    public Screen update(@PathVariable Integer id, @Valid @RequestBody Screen screenServiceBody) {
        return screenService.update(id, screenServiceBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        screenService.delete(id);
    }
}
