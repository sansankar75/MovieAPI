package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Seat;
import com.example.moviebooking.service.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAll() {
        return seatService.getAll();
    }

    @GetMapping("/{id}")
    public Seat getById(@PathVariable Integer id) {
        return seatService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seat create(@Valid @RequestBody Seat seatServiceBody) {
        return seatService.create(seatServiceBody);
    }

    @PutMapping("/{id}")
    public Seat update(@PathVariable Integer id, @Valid @RequestBody Seat seatServiceBody) {
        return seatService.update(id, seatServiceBody);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        seatService.delete(id);
    }
}
