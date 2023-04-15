package com.ozgun.kitaplik.repository;

import com.ozgun.kitaplik.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
