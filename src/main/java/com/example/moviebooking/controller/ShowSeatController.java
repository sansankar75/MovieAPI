package com.example.moviebooking.controller;

import com.example.moviebooking.entity.ShowSeat;
import com.example.moviebooking.service.ShowSeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/show-seats")
public class ShowSeatController {

    private final ShowSeatService showSeatService;

    public ShowSeatController(ShowSeatService showSeatService) {
        this.showSeatService = showSeatService;
    }

    @GetMapping
    public List<ShowSeat> getAll() {
        return showSeatService.getAll();
    }

    @GetMapping("/{id}")
    public ShowSeat getById(@PathVariable Integer id) {
        return showSeatService.getById(id);
    }
}
