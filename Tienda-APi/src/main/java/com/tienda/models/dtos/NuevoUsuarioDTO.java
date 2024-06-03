package com.tienda.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NuevoUsuarioDTO {
	
	@NotEmpty(message = "El nombre es necesario")
	private String nombre;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty(message = "La contrasena es necesaria")
	private String contrasena;
	
	
}
