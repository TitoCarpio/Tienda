package com.tienda.services;

import com.tienda.models.dtos.AuthRequestDTO;
import com.tienda.models.dtos.NuevoUsuarioDTO;
import com.tienda.models.dtos.ResLoginDTO;
import com.tienda.models.entities.Usuarios;

public interface UsuarioService {
	
	void crearUsuario(NuevoUsuarioDTO info);
	
	ResLoginDTO buscarPorCorreo(AuthRequestDTO info);
	
	Usuarios obtenerUno(int id);

}
