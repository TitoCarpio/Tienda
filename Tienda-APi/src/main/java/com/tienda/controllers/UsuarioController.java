package com.tienda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.models.dtos.AuthRequestDTO;
import com.tienda.models.dtos.NuevoUsuarioDTO;
import com.tienda.models.dtos.ResLoginDTO;
import com.tienda.services.UsuarioService;

import jakarta.validation.Valid;



@RestController
@CrossOrigin("*")
@RequestMapping("/API/v1/tienda")
public class UsuarioController {
	
	@Autowired
	private UsuarioService userServices;
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> crearUsuario(@RequestBody @Valid NuevoUsuarioDTO info){
		userServices.crearUsuario(info);
		return new ResponseEntity<>("Usuario creado con exito!", HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchBankByName(@RequestBody @Valid AuthRequestDTO requestDTO) {
        ResLoginDTO usuario = userServices.buscarPorCorreo(requestDTO);
        
        if (usuario == null) {
			return new ResponseEntity<>("Correo o contasena incorrecta", HttpStatus.UNAUTHORIZED);
		}
        
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
