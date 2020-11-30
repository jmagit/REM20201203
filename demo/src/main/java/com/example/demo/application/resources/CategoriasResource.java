package com.example.demo.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entities.Category;
import com.example.demo.infraestructure.repositories.CategoriaRepository;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriasResource {
	@Autowired
	CategoriaRepository dao;
	
	@GetMapping
	public List<Category> getAll() {
		return dao.findAll();
	}
}
