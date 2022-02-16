package com.pruebaoctans.dto;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;

public class ResponseDto {

	private String categoria;
	private String codigo;
	private String descripcion;
	private int estado;
	private String tiempoRespuesta;
	
	private Object objetoRespuesta;
	
	public ResponseDto(HttpStatus status, String message) {
		super();
		this.tiempoRespuesta = OffsetDateTime.now().toString();
		this.estado = status.value();
		this.codigo = status.name();
		this.descripcion = message;
		this.categoria = "DEFAULT_CATEGORY";
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTiempoRespuesta() {
		return tiempoRespuesta;
	}

	public void setTiempoRespuesta(String tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}

	public Object getObjetoRespuesta() {
		return objetoRespuesta;
	}

	public void setObjetoRespuesta(Object objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}

	public ResponseDto(String categoria, String codigo, String descripcion, int estado, String tiempoRespuesta,
			Object objetoRespuesta) {
		super();
		this.categoria = categoria;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tiempoRespuesta = tiempoRespuesta;
		this.objetoRespuesta = objetoRespuesta;
	}

	public ResponseDto() {
		super();
	}
}
