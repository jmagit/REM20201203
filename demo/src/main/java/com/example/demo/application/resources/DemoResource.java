package com.example.demo.application.resources;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.core.EntityBase;
import com.example.demo.domain.core.NIF;
import com.example.demo.domain.entities.Actor;
import com.example.demo.domain.entities.Persona;

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
	
}
