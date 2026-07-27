package com.example.moviebooking.repository;

import com.example.moviebooking.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository already gives you save(), findById(), findAll(), deleteById(), etc.
// for Actor -- no method bodies needed, Spring implements this interface at startup.
@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
