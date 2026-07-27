package com.example.moviebooking.repository;

import com.example.moviebooking.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository already gives you save(), findById(), findAll(), deleteById(), etc.
// for Show -- no method bodies needed, Spring implements this interface at startup.
@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
