package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class Genre {

    /**
     * Unique identifier of the genre.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the genre.
     */
    private String name;
}


