package com.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.models.dtos.NuevoArticuloDTO;
import com.tienda.models.entities.Articulos;
import com.tienda.services.ArticulService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/API/v1/tienda")
public class ArticuloController {
	
	@Autowired
	private ArticulService articuloServices;
	
	@PostMapping(value = "/articulo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> nuevoArticulo(@RequestBody @Valid NuevoArticuloDTO info){
		articuloServices.crerArticulo(info);
		return new ResponseEntity<>("Articulo creado con exito!", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/articulos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> todosArticulos(){
		List<Articulos> articulos = articuloServices.todos();
		return new ResponseEntity<>(articulos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/articulo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obtenerUno(@PathVariable("id") String id){
		//parseando de string a int
		int idArticulo =Integer.parseInt(id);
		Articulos articulo = articuloServices.obtenerUno(idArticulo);
		return new ResponseEntity<>(articulo, HttpStatus.OK);
	}


}
