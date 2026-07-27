package com.example.moviebooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;
    private String email;
    private String password;
    private String language;
    private String location;
    private String role;                     // "ADMIN" / "CUSTOMER", as seen in your data
    private String gender;

    // Note: your table also has a separate "id" column (integer) alongside user_id.
    // If you actually need it, map it too -- otherwise leave it out and Hibernate
    // won't touch it.
}