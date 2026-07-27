package com.example.moviebooking.service;

import com.example.moviebooking.entity.Theater;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getAll() {
        return theaterRepository.findAll();
    }

    public Theater getById(Integer id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theater not found with id: " + id));
    }

    public Theater create(Theater theater) {
        return theaterRepository.save(theater);
    }

    public Theater update(Integer id, Theater updated) {
        Theater existing = getById(id);
        updated.setId(existing.getId());
        return theaterRepository.save(updated);
    }

    public void delete(Integer id) {
        Theater existing = getById(id);
        theaterRepository.delete(existing);
    }
}
