package com.example.demo.domain.entities.dtos;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ActorNamesDTO {
	@JsonProperty("id")
	int getActorId();
	@JsonProperty("nombre")
	@Value("#{target.LastName + ', ' + target.FirstName}")
	String getNombreCompleto();
}
