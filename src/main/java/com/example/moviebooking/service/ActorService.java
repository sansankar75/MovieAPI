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

    /**
     * Retrieves all actors.
     *
     * @return list of all actors
     */
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    /**
     * Retrieves an actor by its ID.
     *
     * @param id unique identifier of the actor
     * @return the actor matching the given ID
     * @throws ResourceNotFoundException if the actor does not exist
     */
    public Actor getById(Integer id) {
        return actorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Actor not found with id: " + id
                        ));
    }

    /**
     * Creates a new actor.
     *
     * @param actor actor data to be persisted
     * @return the newly created actor
     * @throws ActorAlreadyExistsException if an actor with the same name exists
     */
    public Actor create(Actor actor) {

        if (actorRepository.existsByName(actor.getName())) {
            throw new ActorAlreadyExistsException(
                    "Actor already exists with name: " + actor.getName()
            );
        }

        return actorRepository.save(actor);
    }

    /**
     * Updates an existing actor.
     *
     * @param id unique identifier of the actor to update
     * @param updated updated actor data
     * @return the updated actor
     * @throws ResourceNotFoundException if the actor does not exist
     */
    public Actor update(Integer id, Actor updated) {

        Actor existing = getById(id);

        updated.setId(existing.getId());

        return actorRepository.save(updated);
    }

    /**
     * Deletes an actor by its ID.
     *
     * @param id unique identifier of the actor to delete
     * @throws ResourceNotFoundException if the actor does not exist
     */
    public void delete(Integer id) {

        Actor existing = getById(id);

        actorRepository.delete(existing);
    }
}
