package com.ozgun.kitaplik.service;

import com.ozgun.kitaplik.exception.BookNotFoundException;
import com.ozgun.kitaplik.model.Book;
import com.ozgun.kitaplik.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book book = getBookById(id);
        book.setName(updatedBook.getName());
        book.setAuthor(updatedBook.getAuthor());
        book.setPublishYear(updatedBook.getPublishYear());
        book.setReadingCount(updatedBook.getReadingCount());
        book.setPoint(updatedBook.getPoint());
        book.setTotalPages(updatedBook.getTotalPages());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getBooksByAuthor(String name) {
        return bookRepository.getBooksByAuthor(name);
    }

    public List<Book> findAllByOrderByPublishYearAsc() {
        return bookRepository.findAllByOrderByPublishYearAsc();
    }
}
