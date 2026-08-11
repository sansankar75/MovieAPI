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

    /**
     * Retrieves all seats.
     *
     * @return list of all seats
     */
    @GetMapping
    public List<Seat> getAll() {
        return seatService.getAll();
    }

    /**
     * Retrieves a seat by its ID.
     *
     * @param id unique identifier of the seat
     * @return the seat matching the given ID
     */
    @GetMapping("/{id}")
    public Seat getById(@PathVariable Integer id) {
        return seatService.getById(id);
    }

    /**
     * Creates a new seat.
     *
     * @param seatRequest seat data received in the request body
     * @return the newly created seat
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seat create(@Valid @RequestBody Seat seatRequest) {
        return seatService.create(seatRequest);
    }

    /**
     * Updates an existing seat.
     *
     * @param id unique identifier of the seat to update
     * @param seatRequest updated seat data received in the request body
     * @return the updated seat
     */
    @PatchMapping("/{id}")
    public Seat update(
            @PathVariable Integer id,
            @Valid @RequestBody Seat seatRequest) {

        return seatService.update(id, seatRequest);
    }

    /**
     * Deletes a seat by its ID.
     *
     * @param id unique identifier of the seat to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        seatService.delete(id);
    }
}