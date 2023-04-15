package com.ozgun.kitaplik.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    @Column(name = "membershipDate")
    private Date membershipDate;

    @PrePersist
    public void setMembershipDate() {
        this.membershipDate = new Date();
    }

}
