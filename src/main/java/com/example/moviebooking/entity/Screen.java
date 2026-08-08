package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "screens")
@Getter
@Setter
public class Screen {

    /**
     * Unique identifier of the screen.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Theater in which this screen is located.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    /**
     * Name or identifier of the screen.
     */
    private String name;

    /**
     * Total number of seats available in the screen.
     */
    private Integer totalSeats;
}

