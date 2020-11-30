package com.example.demo.domain.entities.dtos;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.domain.entities.Film;

import lombok.Data;

@Projection(name = "corto", types = Film.class)
public interface FilmShortDTO {
	int getFilmId();
	String getTitle();
}
