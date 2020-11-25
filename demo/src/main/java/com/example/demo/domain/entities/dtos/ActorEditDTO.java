package com.example.demo.domain.entities.dtos;

import com.example.demo.domain.entities.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ActorEditDTO {
	@JsonProperty(value = "id")
	private int actorId;
	@JsonProperty(value = "nombre")
	private String firstName;
	@JsonProperty(value = "apellidos")
	private String lastName;
	
	public static Actor from(ActorEditDTO source) {
		return new Actor(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
	public static ActorEditDTO from(Actor source) {
		return new ActorEditDTO(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
}
