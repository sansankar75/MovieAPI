package com.example.moviebooking.service;

import com.example.moviebooking.entity.Actor;
import com.example.moviebooking.exception.ActorAlreadyExistsException;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    public Actor getById(Integer id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not found with id: " + id));
    }

    public Actor create(Actor actor) {
        if(actorRepository.existsByName(actor.getName())){
            throw new ActorAlreadyExistsException("Given Actor Already Exists");
        }
        return actorRepository.save(actor);
    }

    public Actor update(Integer id, Actor updated) {
        Actor existing = getById(id);
        updated.setId(existing.getId());
        return actorRepository.save(updated);
    }

    public void delete(Integer id) {
        Actor existing = getById(id);
        actorRepository.delete(existing);
    }
}
