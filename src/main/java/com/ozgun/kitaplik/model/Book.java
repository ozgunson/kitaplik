package com.ozgun.kitaplik.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String author;

    private int totalPages;

    private int publishYear;

    private double point;

    private int readingCount;

    @ManyToMany(mappedBy = "books")
    private List<User> users;

    public Book(Long id, String name, String author, int totalPages, int publishYear, double point, int readingCount) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.totalPages = totalPages;
        this.publishYear = publishYear;
        this.point = point;
        this.readingCount = readingCount;
    }

}
