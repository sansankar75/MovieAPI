package com.example.moviebooking.service;

import com.example.moviebooking.entity.Seat;
import com.example.moviebooking.entity.Show;
import com.example.moviebooking.entity.ShowSeat;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShowSeatService {

    private final ShowSeatRepository showSeatRepository;

    public ShowSeatService(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    public List<ShowSeat> getAll() {
        return showSeatRepository.findAll();
    }

    public ShowSeat getById(Integer id) {
        return showSeatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShowSeat not found with id: " + id));
    }
}
