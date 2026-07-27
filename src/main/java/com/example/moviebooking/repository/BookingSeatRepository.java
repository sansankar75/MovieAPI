package com.example.moviebooking.repository;

import com.example.moviebooking.entity.BookingSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository already gives you save(), findById(), findAll(), deleteById(), etc.
// for BookingSeat -- no method bodies needed, Spring implements this interface at startup.
@Repository
public interface BookingSeatRepository extends JpaRepository<BookingSeat, Integer> {
}
