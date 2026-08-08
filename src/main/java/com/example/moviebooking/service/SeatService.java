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

    /**
     * Retrieves all seats.
     *
     * @return list of all seats
     */
    public List<Seat> getAll() {
        return seatRepository.findAll();
    }

    /**
     * Retrieves a seat by its ID.
     *
     * @param id unique identifier of the seat
     * @return the seat matching the given ID
     * @throws ResourceNotFoundException if the seat does not exist
     */
    public Seat getById(Integer id) {
        return seatRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Seat not found with id: " + id
                        ));
    }

    /**
     * Creates a new seat.
     *
     * @param seat seat data to be persisted
     * @return the newly created seat
     */
    public Seat create(Seat seat) {
        return seatRepository.save(seat);
    }

    /**
     * Updates an existing seat.
     *
     * @param id unique identifier of the seat to update
     * @param updated updated seat data
     * @return the updated seat
     * @throws ResourceNotFoundException if the seat does not exist
     */
    public Seat update(Integer id, Seat updated) {
        Seat existing = getById(id);

        updated.setId(existing.getId());

        return seatRepository.save(updated);
    }

    /**
     * Deletes a seat by its ID.
     *
     * @param id unique identifier of the seat to delete
     * @throws ResourceNotFoundException if the seat does not exist
     */
    public void delete(Integer id) {
        Seat existing = getById(id);

        seatRepository.delete(existing);
    }
}
