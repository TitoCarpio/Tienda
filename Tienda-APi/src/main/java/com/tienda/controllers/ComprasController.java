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

import com.tienda.models.dtos.NuevaCompraDTO;
import com.tienda.models.entities.Compras;
import com.tienda.services.CompraService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/API/v1/tienda")
public class ComprasController {
	
	@Autowired
	private CompraService compraServices;
	
	@PostMapping(value = "/compra", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> nuevaCompra(@RequestBody @Valid NuevaCompraDTO info){
		compraServices.crearCompra(info);
		return new ResponseEntity<>("Compra realizada con exito!", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/compras/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> comprasUsuario(@PathVariable("id") int id){
		List<Compras> compras = compraServices.buscarPorUsuario(id);
		return new ResponseEntity<>(compras, HttpStatus.OK);
	}

}
