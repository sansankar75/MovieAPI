package com.example.moviebooking.controller;

import com.example.moviebooking.entity.User;
import com.example.moviebooking.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     *
     * @return list of all users
     */
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     * Retrieves a user by its ID.
     *
     * @param id unique identifier of the user
     * @return the user matching the given ID
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    /**
     * Creates a new user.
     *
     * @param userRequest user data received in the request body
     * @return the newly created user
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User userRequest) {
        return userService.create(userRequest);
    }

    /**
     * Updates an existing user.
     *
     * @param id unique identifier of the user to update
     * @param userRequest updated user data received in the request body
     * @return the updated user
     */
    @PatchMapping("/{id}")
    public User update(
            @PathVariable Integer id,
            @Valid @RequestBody User userRequest) {

        return userService.update(id, userRequest);
    }

    /**
     * Deletes a user by its ID.
     *
     * @param id unique identifier of the user to delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
