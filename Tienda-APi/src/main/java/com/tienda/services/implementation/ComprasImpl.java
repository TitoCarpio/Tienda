package com.tienda.services.implementation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.exception.SaldoInsuficienteException;
import com.tienda.models.dtos.NuevaCompraDTO;
import com.tienda.models.entities.Articulos;
import com.tienda.models.entities.Compras;
import com.tienda.models.entities.Usuarios;
import com.tienda.repositories.ComprasRepository;
import com.tienda.repositories.UsuarioRepository;
import com.tienda.services.ArticulService;
import com.tienda.services.CompraService;
import com.tienda.services.UsuarioService;

import jakarta.transaction.Transactional;

@Service
public class ComprasImpl implements CompraService {

	@Autowired
	private UsuarioService userServices;
	
	@Autowired
	private ArticulService articuloServices;
	
	@Autowired
	private ComprasRepository compraRepo;
	
	@Autowired
	private UsuarioRepository userRepo;
	
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void crearCompra(NuevaCompraDTO info) {
		
		//busco si el usuario existe
		Usuarios usuario = userServices.obtenerUno(info.getUsuario());
		
		//busco el articulo
		Articulos articulo = articuloServices.obtenerUno(info.getArticulo());
		
		BigDecimal total = articulo.getPrecio().multiply(BigDecimal.valueOf(info.getCantidad()));
		
		//verifico si el saldo del usuario alcanza para la compra
		if (usuario.getSaldo().compareTo(total) >= 0) {
			Compras compra = new Compras();
			
			compra.setFecha(new Date());
			compra.setCantidad(info.getCantidad());
			compra.setArticulo(articulo);
			compra.setUsuario(usuario);
			
			//actualizo el saldo del usuario
			usuario.setSaldo(usuario.getSaldo().subtract(total));
			userRepo.save(usuario);
			
			//guardo la compra
			compraRepo.save(compra);	
		}else {
			throw new SaldoInsuficienteException("El saldo es insuficiente para realizar la compra.");
		}
			
	}

	@Override
	public List<Compras> buscarPorUsuario(int id) {
		Usuarios usuario = userServices.obtenerUno(id);
		List<Compras> compras = compraRepo.findByUsuario(usuario);
		return compras;
	}

	
}
