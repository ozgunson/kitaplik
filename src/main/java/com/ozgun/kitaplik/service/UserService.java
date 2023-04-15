package com.ozgun.kitaplik.service;

import com.ozgun.kitaplik.exception.UserNotFoundException;
import com.ozgun.kitaplik.model.User;
import com.ozgun.kitaplik.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setMail(updatedUser.getMail());
        user.setName(updatedUser.getName());
        user.setLastName(updatedUser.getLastName());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
