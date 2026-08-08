package com.example.moviebooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "actors")
@Getter
@Setter
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the actor.
     */
    @NotBlank(message = "Name is required")
    @Size(
            min = 2,
            max = 50,
            message = "Name must be between 2 and 50 characters"
    )
    private String name;

    /**
     * URL of the actor's profile image.
     */
    @NotBlank(message = "Image URL is required")
    @Size(
            max = 255,
            message = "Image URL must not exceed 255 characters"
    )
    private String imageUrl;

    /**
     * Date of birth of the actor.
     */
    private LocalDate dateOfBirth;
}

