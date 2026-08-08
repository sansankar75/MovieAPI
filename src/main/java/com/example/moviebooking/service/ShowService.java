package com.example.moviebooking.service;

import com.example.moviebooking.entity.Show;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    /**
     * Retrieves all shows.
     *
     * @return list of all shows
     */
    public List<Show> getAll() {
        return showRepository.findAll();
    }

    /**
     * Retrieves a show by its ID.
     *
     * @param id unique identifier of the show
     * @return the show matching the given ID
     * @throws ResourceNotFoundException if the show does not exist
     */
    public Show getById(Integer id) {
        return showRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Show not found with id: " + id
                        ));
    }

    /**
     * Creates a new show.
     *
     * @param show show data to be persisted
     * @return the newly created show
     */
    public Show create(Show show) {
        return showRepository.save(show);
    }

    /**
     * Updates an existing show.
     *
     * @param id unique identifier of the show to update
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

        showRepository.delete(existing);
    }
}

