package com.example.moviebooking.service;

import com.example.moviebooking.entity.Seat;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAll() {
        return seatRepository.findAll();
    }

    public Seat getById(Integer id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seat not found with id: " + id));
    }

    public Seat create(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat update(Integer id, Seat updated) {
        Seat existing = getById(id);
        updated.setId(existing.getId());
        return seatRepository.save(updated);
    }

    public void delete(Integer id) {
        Seat existing = getById(id);
        seatRepository.delete(existing);
    }
}
