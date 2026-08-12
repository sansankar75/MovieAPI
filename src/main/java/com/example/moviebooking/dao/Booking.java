package com.example.moviebooking.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class Booking {

    /**
     * Unique identifier of the booking.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * User who made the booking.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Show for which the booking was created.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;

    /**
     * Date and time when the booking was created.
     */
    private LocalDateTime bookingDate = LocalDateTime.now();

    /**
     * Total amount charged for the booking.
     */
    private BigDecimal totalAmount;

    /**
     * Current status of the booking.
     */
    private String status = "PENDING";
}

