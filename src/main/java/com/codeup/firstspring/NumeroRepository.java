package com.codeup.firstspring;

import com.codeup.firstspring.Models.Numero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumeroRepository extends JpaRepository<Numero, Long> {

}
