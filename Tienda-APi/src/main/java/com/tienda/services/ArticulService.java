package com.tienda.services;

import java.util.List;

import com.tienda.models.dtos.NuevoArticuloDTO;
import com.tienda.models.entities.Articulos;

public interface ArticulService {
	
	void crerArticulo(NuevoArticuloDTO info);
	
	List<Articulos> todos();
	
	Articulos obtenerUno(int id);

}
