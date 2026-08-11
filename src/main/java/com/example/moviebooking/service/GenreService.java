package com.example.moviebooking.service;

import com.example.moviebooking.entity.Genre;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    /**
     * Retrieves all genres.
     *
     * @return list of all genres
     */
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    /**
     * Retrieves a genre by its ID.
     *
     * @param id unique identifier of the genre
     * @return the genre matching the given ID
     * @throws ResourceNotFoundException if the genre does not exist
     */
    public Genre getById(Integer id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id));
    }

    /**
     * Creates a new genre.
     *
     * @param genre genre data to be persisted
     * @return the newly created genre
     */
    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    /**
     * Updates an existing genre.
     *
     * @param id unique identifier of the genre to update
     * @param updated updated genre data
     * @return the updated genre
     * @throws ResourceNotFoundException if the genre does not exist
     */
    public Genre update(Integer id, Genre updated) {
        Genre existing = getById(id);

        updated.setId(existing.getId());

        return genreRepository.save(updated);
    }

    /**
     * Deletes a genre by its ID.
     *
     * @param id unique identifier of the genre to delete
     * @throws ResourceNotFoundException if the genre does not exist
     */
    public void delete(Integer id) {
        Genre existing = getById(id);
        genreRepository.delete(existing);
    }
}

