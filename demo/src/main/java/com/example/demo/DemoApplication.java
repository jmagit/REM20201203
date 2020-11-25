package com.example.demo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.contracts.ActorService;
import com.example.demo.domain.entities.Actor;
import com.example.demo.domain.entities.dtos.ActorEditDTO;
import com.example.demo.domain.entities.dtos.ActorNamesDTO;
import com.example.demo.infraestructure.repositories.ActorRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Autowired
//	ActorRepository dao;
//
//	@Autowired
//	ActorService srv;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		Optional<Actor> item = dao.findById(1);
//		if (item.isPresent())
//			System.out.println(item.get());
//		else {
//			System.out.println("No encontrado");
//		}
//		Actor actor = item.get();
//		actor.setFirstName(actor.getFirstName().toUpperCase());
//		dao.save(actor);
//		Actor actor = dao.findById(2).get();
//		actor.getFilmActors().stream().forEach(o -> System.out.println(o.getFilm()));
//		dao.findByFirstNameStartingWithOrderByLastNameDesc("pen").stream().forEach(o -> System.out.println(ActorEditDTO.from(o)));
		//dao.findByActorIdNotNull(ActorNamesDTO.class).stream().forEach(o -> System.out.println(o.getNombreCompleto()));
//		Actor actor = new Actor(666,"ddd","DDDD");
//		if(actor.isInvalid()) {
//			actor.getErrors().stream().forEach(err -> System.out.println(err.getPropertyPath() + ": " + err.getMessage()));
//		}
////		dao.save(new Actor(0,"","kk"));
//		Optional<Actor> item = dao.findById(1);
//		srv.modify(actor);
	}

}
