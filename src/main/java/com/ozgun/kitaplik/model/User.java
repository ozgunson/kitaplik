package com.ozgun.kitaplik.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;

    private String name;
    private String lastName;
    @Column(unique = true)
    private String mail;

    private String password;
    private Date membershipDate;

    @ManyToMany()
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    public User(Long id, String username, String name, String lastName, String mail, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    @PrePersist
    public void setMembershipDate() {
        this.membershipDate = new Date();
    }

}
