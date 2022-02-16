package com.pruebaoctans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "rol")
public class RolModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rol_id")
	private Long id;
	
	@NotBlank(message = "el nombre no puede estar vacio")
	@Column(name = "nombre", length = 120)
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public RolModel(Long id, @NotBlank(message = "el nombre no puede estar vacio") String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public RolModel() {
		super();
	}
	
	

}
