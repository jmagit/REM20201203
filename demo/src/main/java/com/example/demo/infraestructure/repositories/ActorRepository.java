package com.example.demo.infraestructure.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	List<Actor> findByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
	<T> List<T> findByActorIdNotNull(Class<T> type);
	<T> Page<T> findByActorIdNotNull(Class<T> type, Pageable pageable);
	<T> List<T> findByActorIdNotNull(Class<T> type, Sort sort);
}
