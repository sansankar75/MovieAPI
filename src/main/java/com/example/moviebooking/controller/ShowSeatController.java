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

    /**
     * Retrieves all show seats.
     *
     * @return list of all show seats
     */
    @GetMapping
    public List<ShowSeat> getAll() {
        return showSeatService.getAll();
    }

    /**
     * Retrieves a show seat by its ID.
     *
     * @param id unique identifier of the show seat
     * @return the show seat matching the given ID
     */
    @GetMapping("/{id}")
    public ShowSeat getById(@PathVariable Integer id) {
        return showSeatService.getById(id);
    }
}

