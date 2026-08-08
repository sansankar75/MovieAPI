package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "booking_seats")
@Getter
@Setter
public class BookingSeat {

    /**
     * Unique identifier of the booking-seat record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Booking associated with this seat reservation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    /**
     * Show seat reserved as part of the booking.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_seat_id")
    private ShowSeat showSeat;

    /**
     * Price of the seat at the time of booking.
     */
    private BigDecimal price;
}
