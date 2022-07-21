package com.codeup.firstspring;

import com.codeup.firstspring.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
