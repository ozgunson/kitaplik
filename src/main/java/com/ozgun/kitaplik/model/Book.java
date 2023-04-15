package com.ozgun.kitaplik.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private int totalPages;
    private double point;
    private int readingCount;
}
