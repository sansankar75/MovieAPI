package com.example.moviebooking.controller;

import com.example.moviebooking.dto.BookingRequest;
import com.example.moviebooking.entity.Booking;
import com.example.moviebooking.service.BookingService;
import jakarta.validation.Valid;
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

    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public Booking getById(@PathVariable Integer id) {
        return bookingService.getById(id);
    }

    // POST /api/bookings  body: { "userId": 1, "showId": 2, "showSeatIds": [10, 11] }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking create(@Valid @RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        bookingService.delete(id);
    }
}
