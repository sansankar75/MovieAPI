package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Booking;
import com.example.moviebooking.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Retrieves all bookings.
     *
     * @return list of all bookings
     */
    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    /**
     * Retrieves a booking by its ID.
     *
     * @param id unique identifier of the booking
     * @return the booking matching the given ID
     */
    @GetMapping("/{id}")
    public Booking getById(@PathVariable Integer id) {
        return bookingService.getById(id);
    }

    /**
     * Deletes a booking by its ID.
     *
     * @param id unique identifier of the booking to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        bookingService.delete(id);
    }
}

