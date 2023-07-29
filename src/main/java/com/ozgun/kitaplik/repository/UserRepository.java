package com.ozgun.kitaplik.repository;

import com.ozgun.kitaplik.model.Book;
import com.ozgun.kitaplik.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAllByBooksContaining(Book book);
}
