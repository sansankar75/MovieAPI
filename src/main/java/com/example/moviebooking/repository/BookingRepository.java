package com.example.moviebooking.repository;

import com.example.moviebooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository already gives you save(), findById(), findAll(), deleteById(), etc.
// for Booking -- no method bodies needed, Spring implements this interface at startup.
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
