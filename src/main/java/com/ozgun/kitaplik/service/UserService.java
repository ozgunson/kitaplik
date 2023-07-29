package com.ozgun.kitaplik.service;

import com.ozgun.kitaplik.exception.BookNotFoundException;
import com.ozgun.kitaplik.exception.UserNotFoundException;
import com.ozgun.kitaplik.model.Book;
import com.ozgun.kitaplik.model.User;
import com.ozgun.kitaplik.repository.BookRepository;
import com.ozgun.kitaplik.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.bookRepository = bookRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
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


    public void addBookToUser(Long userId, Long bookId) {
        User user = getUserById(userId);
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        user.getBooks().add(book);
        userRepository.save(user);
    }

    public void deleteBookFromUser(Long userId, Long bookId) {
        User user = getUserById(userId);
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        user.getBooks().remove(book);
        userRepository.save(user);
    }


    public List<User> findAllByBooksContaining(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return userRepository.findAllByBooksContaining(book);
    }

}
