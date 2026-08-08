package com.example.moviebooking.service;

import com.example.moviebooking.entity.Screen;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenService(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    /**
     * Retrieves all screens.
     *
     * @return list of all screens
     */
    public List<Screen> getAll() {
        return screenRepository.findAll();
    }

    /**
     * Retrieves a screen by its ID.
     *
     * @param id unique identifier of the screen
     * @return the screen matching the given ID
     * @throws ResourceNotFoundException if the screen does not exist
     */
    public Screen getById(Integer id) {
        return screenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found with id: " + id
                        ));
    }

    /**
     * Creates a new screen.
     *
     * @param screen screen data to be persisted
     * @return the newly created screen
     */
    public Screen create(Screen screen) {
        return screenRepository.save(screen);
    }

    /**
     * Updates an existing screen.
     *
     * @param id unique identifier of the screen to update
     * @param updated updated screen data
     * @return the updated screen
     * @throws ResourceNotFoundException if the screen does not exist
     */
    public Screen update(Integer id, Screen updated) {
        Screen existing = getById(id);

        updated.setId(existing.getId());

        return screenRepository.save(updated);
    }

    /**
     * Deletes a screen by its ID.
     *
     * @param id unique identifier of the screen to delete
     * @throws ResourceNotFoundException if the screen does not exist
     */
    public void delete(Integer id) {
        Screen existing = getById(id);

        screenRepository.delete(existing);
    }
}
