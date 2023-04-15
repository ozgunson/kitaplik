package com.ozgun.kitaplik.repository;

import com.ozgun.kitaplik.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
