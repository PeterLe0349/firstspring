package com.codeup.firstspring;

import com.codeup.firstspring.Models.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepository extends JpaRepository<Ads, Integer> {
}
