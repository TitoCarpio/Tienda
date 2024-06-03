package com.tienda.models.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "compras")
public class Compras {
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="cantidad")
	private int cantidad;
	
	@Column(name ="fecha")
	private Date fecha;
	
	//laves foraneas de la entidad
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuarios usuario; 
	
	@ManyToOne
	@JoinColumn(name = "articulo_id", nullable = false)
	private Articulos articulo;

	public Compras(int cantidad, Date fecha, Usuarios usuario, Articulos articulo) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.usuario = usuario;
		this.articulo = articulo;
	} 
	

}
