package com.example.demo.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Film;


public interface FilmRepository extends JpaRepository<Film, Integer> {
}
