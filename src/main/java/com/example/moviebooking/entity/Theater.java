package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "theaters")
@Getter
@Setter
public class Theater {

    /**
     * Unique identifier of the theater.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the theater.
     */
    private String name;

    /**
     * Physical address of the theater.
     */
    private String address;

    /**
     * City where the theater is located.
     */
    private String city;
}

