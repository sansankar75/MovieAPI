package com.example.moviebooking.dao;

import com.example.moviebooking.comman.EntityStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seats")
@Getter
@Setter
public class Seat {

    /**
     * Unique identifier of the seat.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Screen to which this seat belongs.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    /**
     * Row identifier of the seat, such as A, B, or C.
     */
    private String rowName;

    /**
     * Seat number within the row.
     */
    private Integer number;

    /**
     * Type of the seat, such as REGULAR or PREMIUM.
     */
    private String type;

    /**
     * Status of seat.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntityStatus status = EntityStatus.ACTIVE;
}

