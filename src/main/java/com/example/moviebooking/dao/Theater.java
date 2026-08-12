package com.example.moviebooking.dao;

import com.example.moviebooking.comman.EntityStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    /**
     * Physical address of the theater.
     */
    private String address;

    /**
     * City where the theater is located.
     */
    private String city;

    /**
     * Status of Theater.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntityStatus status = EntityStatus.ACTIVE;
}

