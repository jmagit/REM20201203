package com.example.demo.domain.entities.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface ActorNamesDTO {
	int getActorId();
	@Value("#{target.LastName + ', ' + target.FirstName}")
	String getNombreCompleto();
}
