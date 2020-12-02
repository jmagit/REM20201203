package com.example.demo.application.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.entities.dtos.PeliDTO;

@FeignClient(name = "CATALOGO-SERVICE")
public interface CatalogoProxy {
	@GetMapping(path = "/peliculas?mode=short")
	List<PeliDTO> getPelis();
	@GetMapping(path = "/peliculas/{id}?mode=short")
	PeliDTO getPeli(@PathVariable int id);
	@GetMapping
	String getServices();
}
