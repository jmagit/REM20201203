package com.example.catalogo.application.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface NamesOnly {
	int getActorId();

	@Value("#{target.firstName + ' ' + target.lastName}")
	String getFullName();
}
