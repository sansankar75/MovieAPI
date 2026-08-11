package com.example.moviebooking.service;

import com.example.moviebooking.entity.ShowSeat;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowSeatService {

    private final ShowSeatRepository showSeatRepository;

    public ShowSeatService(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    /**
     * Retrieves all show seats.
     *
     * @return list of all show seats
     */
    public List<ShowSeat> getAll() {
        return showSeatRepository.findAll();
    }

    /**
     * Retrieves a show seat by its ID.
     *
     * @param id unique identifier of the show seat
     * @return the show seat matching the given ID
     * @throws ResourceNotFoundException if the show seat does not exist
     */
    public ShowSeat getById(Integer id) {
        return showSeatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Show seat not found with id: " + id));
    }
}

