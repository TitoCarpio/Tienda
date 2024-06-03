package com.tienda.models.entities;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = "compras")
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuarios {
	
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="nombre")
	private String nombre;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="contrasena")
	private String contrasena;
	
	@Column(name ="rol")
	private String rol;
	
	@Column(name ="saldo")
	private BigDecimal saldo;
	
	//llaver foraneas para fujo de datos en ambas direcciones
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Compras> compras;

	public Usuarios(String nombre, String email, String contrasena, String rol, BigDecimal saldo) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
		this.rol = rol;
		this.saldo = saldo;
	}
	
	
}
