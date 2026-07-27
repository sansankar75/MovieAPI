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

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre getById(Integer id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found with id: " + id));
    }

    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre update(Integer id, Genre updated) {
        Genre existing = getById(id);
        updated.setId(existing.getId());
        return genreRepository.save(updated);
    }

    public void delete(Integer id) {
        Genre existing = getById(id);
        genreRepository.delete(existing);
    }
}
