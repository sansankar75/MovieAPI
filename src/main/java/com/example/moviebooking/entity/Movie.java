package com.example.moviebooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {

    /**
     * Unique identifier of the movie.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Title of the movie.
     */
    @NotBlank(message = "Movie title is required")
    private String title;

    /**
     * Description or synopsis of the movie.
     */
    @Column(length = 1000)
    private String description;

    /**
     * Primary language of the movie.
     */
    private String language;

    /**
     * Date on which the movie was released.
     */
    private LocalDate releaseDate;

    /**
     * URL of the movie poster image.
     */
    private String posterUrl;

    /**
     * Current status of the movie.
     */
    private String status;
}
