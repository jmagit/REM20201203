package com.example.demo.domain.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

import com.example.demo.domain.core.EntityBase;
import com.example.demo.domain.core.NIF;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@ApiModel(value = "Datos de la persona")
public class Persona {
	@ApiModelProperty(name = "Identificador de persona", notes = "Tiene que ser un ...", required = true )
	int id;
	@NotBlank
	String nombre;
	@NIF
	String nif;
	@ISBN
	String cuenta;
}
