package com.example.moviebooking.service;

import com.example.moviebooking.comman.EntityStatus;
import com.example.moviebooking.dao.User;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.UserRepository;
import com.example.moviebooking.comman.PasswordHashing;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all active users.
     *
     * @return list of all active users
     */
    public List<User> getAll() {

        List<User> users = userRepository.findAll();
        List<User> activeUsers = new ArrayList<>();

        for (User user : users) {
            if (user.getStatus().equals(EntityStatus.ACTIVE)) {
                activeUsers.add(user);
            }
        }

        return activeUsers;
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id unique identifier of the user
     * @return the user matching the given ID
     * @throws ResourceNotFoundException if the user does not exist
     */
    public User getById(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id
                        ));

        // Check if user is inactive
        if (EntityStatus.INACTIVE.equals(user.getStatus())) {
            throw new ResourceNotFoundException(
                    "User is inactive: " + id
            );
        }

        return user;
    }

    /**
     * Creates a new user.
     *
     * @param user user data to be persisted
     * @return the newly created user
     */
    public User create(User user) {

        user.setPassword(PasswordHashing.hash(user.getPassword()));  /* Hash password*/
        user.setStatus(EntityStatus.ACTIVE);

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

        existing.setStatus(EntityStatus.INACTIVE);

        userRepository.save(existing);
    }
}