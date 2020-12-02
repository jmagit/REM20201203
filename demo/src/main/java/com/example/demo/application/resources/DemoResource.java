package com.example.demo.application.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.application.proxies.CatalogoProxy;
import com.example.demo.domain.core.EntityBase;
import com.example.demo.domain.core.NIF;
import com.example.demo.domain.entities.Actor;
import com.example.demo.domain.entities.Persona;
import com.example.demo.domain.entities.dtos.FilmShortDTO;
import com.example.demo.domain.entities.dtos.PeliDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@Api(value = "Ejemplos del curso")
public class DemoResource {
	@GetMapping(path = "saluda")
	public String saluda() {
		return "Hola mundo";
	}
	@GetMapping(path = "despide")
	public String despide() {
		return "Adios mundo";
	}
	
	@GetMapping("/params/{id}")
	public String cotilla(
	        @PathVariable String id,
	        @RequestParam String nom,
	        @RequestHeader("Accept-Language") String language, 
	        @CookieValue(name = "XSRF-TOKEN", defaultValue = "sin valor") String cookie) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("id: " + id + "\n");
	    sb.append("nom: " + nom + "\n");
	    sb.append("language: " + language + "\n");
	    sb.append("cookie: " + cookie + "\n");
	    return sb.toString();
	}
	@GetMapping(path = "/params/{id}", produces = {"application/xml"})
	public String cotillaXML(
	        @PathVariable String id,
	        @RequestParam String nom,
	        @RequestHeader("Accept-Language") String language, 
	        @CookieValue(name = "XSRF-TOKEN", defaultValue = "sin valor") String cookie) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("Es xml id: " + id + "\n");
	    sb.append("nom: " + nom + "\n");
	    sb.append("language: " + language + "\n");
	    sb.append("cookie: " + cookie + "\n");
	    return sb.toString();
	}
	@GetMapping(path = "/datos", produces = {"application/xml"})
	public Actor datosXML() {
		return new Actor(666,"ddd","XML");
	}
	@GetMapping(path = "/datos", produces = {"application/json"})
	public Actor datosJSON() {
		return new Actor(666,"ddd","JSON");
	}
	@GetMapping(path = "/masdatos")
	public Actor datos() {
		return new Actor(666,"ddd","DDDD");
	}
	
	@GetMapping(path = "/persona")
	public Persona persona() {
		return new Persona(666,"ddd","NIF", "");
	}
	@ApiOperation(value = "Ejemplo de validaciones")
	@PostMapping(path = "/persona")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Datos que no pasan la validación")
	})
	public void persona(@Valid @RequestBody @ApiParam(value = "Datos de la persona") Persona item) {
	}
	
	@Autowired
	RestTemplate srvRest;
	
	@GetMapping(path = "pelis")
	public List<PeliDTO> getPelis() {
		ResponseEntity<List<PeliDTO>> response = srvRest.exchange(
				"http://localhost:8011/peliculas?mode=short", 
				HttpMethod.GET,
				HttpEntity.EMPTY, 
				new ParameterizedTypeReference<List<PeliDTO>>() {}
				);
		return response.getBody();
	}
	@GetMapping(path = "pelis/{id}")
	public PeliDTO getPelis(@PathVariable int id) {
		return srvRest.getForObject("http://localhost:8080/catalogo/peliculas/{id}?mode=short", PeliDTO.class, id);
	}
	
	@Autowired
	CatalogoProxy proxy;

	@GetMapping(path = "catalogo")
	public List<PeliDTO> getCatalogo() {
		return proxy.getPelis();
	}
	@GetMapping(path = "catalogo/{id}")
	public PeliDTO getCatalogo(@PathVariable int id) {
		return proxy.getPeli(id);
	}
	@GetMapping(path = "servicios")
	public String getServicios() {
		return proxy.getServices();
	}

	
}
