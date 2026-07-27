package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "screens")
@Getter
@Setter
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Many screens belong to one theater. FetchType.LAZY avoids pulling the
    // whole Theater row every time you just need a screen's id.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    private String name;
    private Integer totalSeats;
}
