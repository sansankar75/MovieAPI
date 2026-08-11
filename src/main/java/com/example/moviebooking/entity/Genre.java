package com.example.moviebooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;
}


