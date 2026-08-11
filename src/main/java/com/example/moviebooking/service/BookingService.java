package com.example.moviebooking.service;

import com.example.moviebooking.entity.Booking;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Retrieves all bookings.
     *
     * @return list of all bookings
     */
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    /**
     * Retrieves a booking by its ID.
     *
     * @param id unique identifier of the booking
     * @return the booking matching the given ID
     * @throws ResourceNotFoundException if the booking does not exist
     */
    public Booking getById(Integer id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    /**
     * Deletes a booking by its ID.
     *
     * @param id unique identifier of the booking to delete
     * @throws ResourceNotFoundException if the booking does not exist
     */
    public void delete(Integer id) {
        Booking existing = getById(id);
        bookingRepository.delete(existing);
    }
}
