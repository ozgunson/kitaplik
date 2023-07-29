package com.ozgun.kitaplik.repository;

import com.ozgun.kitaplik.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> getBooksByAuthor(String name);

    public List<Book> findAllByOrderByPublishYearAsc();
}
