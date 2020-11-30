package com.example.demo.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Category;

public interface CategoriaRepository extends JpaRepository<Category, Byte> {

}
