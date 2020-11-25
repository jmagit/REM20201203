package com.example.demo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.entities.Actor;
import com.example.demo.infraestructure.repositories.ActorRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ActorRepository dao;

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
		Actor actor = dao.findById(2).get();
		actor.getFilmActors().stream().forEach(o -> System.out.println(o.getFilm()));
	}

}
