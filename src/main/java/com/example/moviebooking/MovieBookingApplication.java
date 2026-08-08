package com.example.moviebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Movie Booking application.
 *
 * <p>{@link SpringBootApplication} enables component scanning,
 * autoconfiguration, and Spring Boot configuration for the application.</p>
 */
@SpringBootApplication
public class MovieBookingApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(MovieBookingApplication.class, args);
    }
}

