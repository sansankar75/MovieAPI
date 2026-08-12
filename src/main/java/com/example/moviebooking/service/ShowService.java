package com.example.moviebooking.service;

import com.example.moviebooking.comman.EntityStatus;
import com.example.moviebooking.dao.Show;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    /**
     * Retrieves all active shows.
     *
     * @return list of all active shows
     */
    public List<Show> getAll() {

        List<Show> shows = showRepository.findAll();
        List<Show> activeShows = new ArrayList<>();

        for (Show show : shows) {
            if (show.getStatus().equals(EntityStatus.ACTIVE)) {
                activeShows.add(show);
            }
        }

        return activeShows;
    }

    /**
     * Retrieves an active show by its ID.
     *
     * @param id unique identifier of the show
     * @return the show matching the given ID
     * @throws ResourceNotFoundException if the show does not exist
     */
    public Show getById(Integer id) {

        Show show = showRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Show not found with id: " + id
                        ));

        // Check if show is inactive
        if (EntityStatus.INACTIVE.equals(show.getStatus())) {
            throw new ResourceNotFoundException(
                    "Show is inactive: " + id
            );
        }

        return show;
    }

    /**
     * Creates a new show.
     *
     * @param show show data to be persisted
     * @return the newly created show
     */
    public Show create(Show show) {

        show.setStatus(EntityStatus.ACTIVE);

        return showRepository.save(show);
    }

    /**
     * Updates an existing show.
     *
     * @param id unique identifier of the show
     * @param updated updated show data
     * @return the updated show
     * @throws ResourceNotFoundException if the show does not exist
     */
    public Show update(Integer id, Show updated) {

        Show existing = getById(id);

        updated.setId(existing.getId());

        return showRepository.save(updated);
    }

    /**
     * Deletes a show by its ID.
     *
     * @param id unique identifier of the show to delete
     * @throws ResourceNotFoundException if the show does not exist
     */
    public void delete(Integer id) {

        Show existing = getById(id);

        existing.setStatus(EntityStatus.INACTIVE);

        showRepository.save(existing);
    }
}