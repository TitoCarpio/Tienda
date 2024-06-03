package com.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.models.entities.Articulos;

public interface ArticulosRepository extends JpaRepository<Articulos, Integer> {

}
