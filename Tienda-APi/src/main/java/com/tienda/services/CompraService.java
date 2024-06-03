package com.tienda.services;

import java.util.List;

import com.tienda.models.dtos.NuevaCompraDTO;
import com.tienda.models.entities.Compras;

public interface CompraService {
	
	void crearCompra(NuevaCompraDTO info);
	
	List<Compras> buscarPorUsuario(int id);

}
