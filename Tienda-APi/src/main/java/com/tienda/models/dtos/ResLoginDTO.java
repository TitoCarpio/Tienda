package com.tienda.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResLoginDTO {
	private String email;
	private int id;
}
