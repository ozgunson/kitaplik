package com.ozgun.kitaplik.controller;

import com.ozgun.kitaplik.model.Book;
import com.ozgun.kitaplik.model.User;
import com.ozgun.kitaplik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser) {
        return ResponseEntity.ok(userService.updateUser(id, updatedUser));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{userId}/addbook/{bookId}")
    public void addBookToUser(@PathVariable Long userId, @PathVariable Long bookId) {
        userService.addBookToUser(userId, bookId);
    }

    @PutMapping("/{userId}/deletebook/{bookId}")
    public void deleteBookFromUser(@PathVariable Long userId, @PathVariable Long bookId) {
        userService.deleteBookFromUser(userId, bookId);
    }

    @GetMapping("/userbybook/{bookId}")
    public ResponseEntity<List<User>> findAllByBooksContaining(@PathVariable Long bookId) {
        return ResponseEntity.ok(userService.findAllByBooksContaining(bookId));
    }

}
