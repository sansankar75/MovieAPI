package com.example.moviebooking.service;

import com.example.moviebooking.entity.User;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users.
     *
     * @return list of all users
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id unique identifier of the user
     * @return the user matching the given ID
     * @throws ResourceNotFoundException if the user does not exist
     */
    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id
                        ));
    }

    /**
     * Creates a new user.
     *
     * @param user user data to be persisted
     * @return the newly created user
     */
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates an existing user.
     *
     * @param id unique identifier of the user to update
     * @param updated updated user data
     * @return the updated user
     * @throws ResourceNotFoundException if the user does not exist
     */
    public User update(Integer id, User updated) {
        User existing = getById(id);

        updated.setId(existing.getId());

        return userRepository.save(updated);
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id unique identifier of the user to delete
     * @throws ResourceNotFoundException if the user does not exist
     */
    public void delete(Integer id) {
        User existing = getById(id);

        userRepository.delete(existing);
    }
}
