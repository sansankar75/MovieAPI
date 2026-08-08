package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@Getter
@Setter
public class Show {

    /**
     * Unique identifier of the show.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Screen where the movie will be shown.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    /**
     * Movie scheduled for this show.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    /**
     * Date on which the show is scheduled.
     */
    private LocalDate date;

    /**
     * Scheduled start time of the show.
     */
    private LocalTime startTime;

    /**
     * Scheduled end time of the show.
     */
    private LocalTime endTime;
}

