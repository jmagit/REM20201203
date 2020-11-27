package com.example.demo.application.resources;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.contracts.ActorService;
import com.example.demo.domain.entities.Actor;
import com.example.demo.domain.entities.dtos.ActorEditDTO;
import com.example.demo.domain.entities.dtos.ActorNamesDTO;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.InvalidDataException;
import com.example.demo.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/actores")
public class ActorResource {
	@Autowired
	ActorService srv;
	
	@GetMapping
	public Page<ActorNamesDTO> getAll(Pageable page) {
		return srv.getAllIn(ActorNamesDTO.class, page);
	}

	@GetMapping(path = "/{id}")
	public ActorEditDTO getOne(@PathVariable int id) throws NotFoundException {
		Optional<Actor> item = srv.getOne(id);
		if(item.isPresent())
			return ActorEditDTO.from(item.get());
		else {
			throw new NotFoundException();
		}
	}
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody ActorEditDTO item) throws BadRequestException, InvalidDataException {
		Actor actor = ActorEditDTO.from(item);
		if(actor.isInvalid()) {
			throw new BadRequestException("Datos invalidos");
		}
		actor = srv.add(actor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(actor.getActorId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@PathVariable int id, @Valid @RequestBody ActorEditDTO item) throws BadRequestException, NotFoundException, InvalidDataException {
		if(id != item.getActorId())
			throw new BadRequestException("No coinciden los identificadores");
		srv.modify(ActorEditDTO.from(item));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) throws NotFoundException {
		srv.deleteById(id);
	}

}
