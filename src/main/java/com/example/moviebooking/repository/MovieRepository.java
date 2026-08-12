package com.example.moviebooking.repository;

import com.example.moviebooking.dao.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository already gives you save(), findById(), findAll(), deleteById(), etc.
// for Movie -- no method bodies needed, Spring implements this interface at startup.
// Movie = Entity type
// Integer = PK type
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
