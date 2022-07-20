package com.codeup.firstspring;

import com.codeup.firstspring.Models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {

}
