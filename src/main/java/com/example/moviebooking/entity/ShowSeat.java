package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// This is the table that makes "don't double-book a seat" actually enforceable:
// a physical Seat is reused across many shows, so availability has to be tracked
// per (show, seat) pair here -- not on Seat itself.
@Entity
@Table(
    name = "show_seats",
    uniqueConstraints = @UniqueConstraint(columnNames = {"show_id", "seat_id"})
)
@Getter
@Setter
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    private String status = "AVAILABLE"; // AVAILABLE or BOOKED
}
