package com.example.moviebooking.service;

import com.example.moviebooking.dto.BookingRequest;
import com.example.moviebooking.entity.*;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingSeatRepository bookingSeatRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    public BookingService(BookingRepository bookingRepository,
                           BookingSeatRepository bookingSeatRepository,
                           ShowSeatRepository showSeatRepository,
                           UserRepository userRepository,
                           ShowRepository showRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingSeatRepository = bookingSeatRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public Booking getById(Integer id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    // The one method that matters most in this whole project: creating a booking
    // must check every seat is still AVAILABLE and flip it to BOOKED, all inside
    // one transaction, so two people can never both succeed for the same seat.
    @Transactional
    public Booking createBooking(BookingRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));

        Show show = showRepository.findById(request.getShowId())
                .orElseThrow(() -> new ResourceNotFoundException("Show not found with id: " + request.getShowId()));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setStatus("PENDING");
        booking = bookingRepository.save(booking);

        BigDecimal total = BigDecimal.ZERO;

        for (Integer showSeatId : request.getShowSeatIds()) {
            ShowSeat showSeat = showSeatRepository.findById(showSeatId)
                    .orElseThrow(() -> new ResourceNotFoundException("ShowSeat not found with id: " + showSeatId));

            if (!"AVAILABLE".equals(showSeat.getStatus())) {
                // Basic MVP-level protection: reject the whole booking if any seat
                // is already taken, instead of silently double-booking it.
                throw new IllegalStateException("Seat " + showSeatId + " is no longer available");
            }

            showSeat.setStatus("BOOKED");
            showSeatRepository.save(showSeat);

            BigDecimal price = BigDecimal.valueOf(200); // placeholder flat price for MVP

            BookingSeat bookingSeat = new BookingSeat();
            bookingSeat.setBooking(booking);
            bookingSeat.setShowSeat(showSeat);
            bookingSeat.setPrice(price);
            bookingSeatRepository.save(bookingSeat);

            total = total.add(price);
        }

        booking.setTotalAmount(total);
        booking.setStatus("CONFIRMED");
        return bookingRepository.save(booking);
    }

    public void delete(Integer id) {
        Booking existing = getById(id);
        bookingRepository.delete(existing);
    }
}
