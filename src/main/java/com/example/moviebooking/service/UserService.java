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

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Integer id, User updated) {
        User existing = getById(id);
        updated.setUserId(existing.getUserId());   // was setId/getId, entity field is now userId
        return userRepository.save(updated);
    }

    public void delete(Integer id) {
        User existing = getById(id);
        userRepository.delete(existing);
    }
}