package com.tienda.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.exception.ResourceNotFoundException;
import com.tienda.models.dtos.NuevoArticuloDTO;
import com.tienda.models.entities.Articulos;
import com.tienda.repositories.ArticulosRepository;
import com.tienda.services.ArticulService;

import jakarta.transaction.Transactional;

@Service
public class ArticuloImpl implements ArticulService {
	
	@Autowired
	private ArticulosRepository articuloRepo;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void crerArticulo(NuevoArticuloDTO info) {
		Articulos articulo = new Articulos();
		
		articulo.setNombre(info.getNombre());
		articulo.setDescripcion(info.getDescripcion());
		articulo.setPrecio(info.getPrecio());
		articulo.setImagen(info.getImagen());
		
		articuloRepo.save(articulo);
		
	}

	@Override
	public List<Articulos> todos() {
		List<Articulos> articulos = articuloRepo.findAll();
		return articulos;
	}

	@Override
	public Articulos obtenerUno(int id) {
		Articulos articulo = articuloRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Articulo no encontrado"));
		return articulo;
	}
	
	
	
	

}
