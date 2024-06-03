package com.tienda.models.dtos;


import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NuevoArticuloDTO {
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String descripcion;
	
	@NotNull
	private BigDecimal precio;
	
	@NotEmpty
	private String imagen;
}
