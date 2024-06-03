package com.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.models.entities.Compras;
import com.tienda.models.entities.Usuarios;

public interface ComprasRepository extends JpaRepository<Compras, Integer> {
	List<Compras> findByUsuario(Usuarios usuario);
}
