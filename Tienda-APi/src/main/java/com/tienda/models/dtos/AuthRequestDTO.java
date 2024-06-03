package com.tienda.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthRequestDTO {

	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty(message = "La contrasena no puede ir vacia")
	private String contrasena;
}
