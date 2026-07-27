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

    public List<Show> getAll() {
        return showRepository.findAll();
    }

    public Show getById(Integer id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Show not found with id: " + id));
    }

    public Show create(Show show) {
        return showRepository.save(show);
    }

    public Show update(Integer id, Show updated) {
        Show existing = getById(id);
        updated.setId(existing.getId());
        return showRepository.save(updated);
    }

    public void delete(Integer id) {
        Show existing = getById(id);
        showRepository.delete(existing);
    }
}
