package com.pruebaoctans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Long id;
	
	@NotBlank(message = "el nombre no puede estar vacio")
	@Column(name = "nombre", length = 120, unique= true)
	private String nombre;
	
	@Column(name = "activo")
	private Boolean activo;
	
	@NotNull(message = "el rol no puede estar vacio")
	@ManyToOne
	@JoinColumn(name = "rol_id")
	private RolModel cargoId;

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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public RolModel getCargoId() {
		return cargoId;
	}

	public void setCargoId(RolModel cargoId) {
		this.cargoId = cargoId;
	}

	public UsuarioModel(Long id, @NotBlank(message = "el nombre no puede estar vacio") String nombre, Boolean activo,
			@NotNull(message = "el rol no puede estar vacio") RolModel cargoId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.cargoId = cargoId;
	}

	public UsuarioModel() {
		super();
	}
	
}
