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

    /**
     * Retrieves all theaters.
     *
     * @return list of all theaters
     */
    public List<Theater> getAll() {
        return theaterRepository.findAll();
    }

    /**
     * Retrieves a theater by its ID.
     *
     * @param id unique identifier of the theater
     * @return the theater matching the given ID
     * @throws ResourceNotFoundException if the theater does not exist
     */
    public Theater getById(Integer id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Theater not found with id: " + id));
    }

    /**
     * Creates a new theater.
     *
     * @param theater theater data to be persisted
     * @return the newly created theater
     */
    public Theater create(Theater theater) {
        return theaterRepository.save(theater);
    }

    /**
     * Updates an existing theater.
     *
     * @param id unique identifier of the theater to update
     * @param updated updated theater data
     * @return the updated theater
     * @throws ResourceNotFoundException if the theater does not exist
     */
    public Theater update(Integer id, Theater updated) {
        Theater existing = getById(id);

        updated.setId(existing.getId());

        return theaterRepository.save(updated);
    }

    /**
     * Deletes a theater by its ID.
     *
     * @param id unique identifier of the theater to delete
     * @throws ResourceNotFoundException if the theater does not exist
     */
    public void delete(Integer id) {
        Theater existing = getById(id);

        theaterRepository.delete(existing);
    }
}

