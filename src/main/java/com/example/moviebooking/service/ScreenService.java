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

    public List<Screen> getAll() {
        return screenRepository.findAll();
    }

    public Screen getById(Integer id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Screen not found with id: " + id));
    }

    public Screen create(Screen screen) {
        return screenRepository.save(screen);
    }

    public Screen update(Integer id, Screen updated) {
        Screen existing = getById(id);
        updated.setId(existing.getId());
        return screenRepository.save(updated);
    }

    public void delete(Integer id) {
        Screen existing = getById(id);
        screenRepository.delete(existing);
    }
}
