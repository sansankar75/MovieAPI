package com.example.moviebooking.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

    /**
     * Unique identifier of the payment.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Booking associated with this payment.
     * Each booking can have at most one payment.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", unique = true)
    private Booking booking;

    /**
     * Amount paid for the booking.
     */
    private BigDecimal amount;

    /**
     * Payment method used for the transaction.
     */
    private String paymentMethod;

    /**
     * Current status of the payment.
     * Possible values: PENDING, SUCCESS, FAILED.
     */
    private String paymentStatus;

    /**
     * Unique transaction identifier provided by the payment system.
     */
    private String transactionId;

    /**
     * Date and time when the payment was created.
     */
    private LocalDateTime paymentDate = LocalDateTime.now();
}

