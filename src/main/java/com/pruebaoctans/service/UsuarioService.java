package com.pruebaoctans.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.pruebaoctans.dto.ResponseDto;
import com.pruebaoctans.model.RolModel;
import com.pruebaoctans.model.UsuarioModel;
import com.pruebaoctans.repository.RolRepository;
import com.pruebaoctans.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RolRepository rolRepository;
	
	
	/**
	 * Esta funcion se encarga de la creacion de un usuario
	 * @param nuevoUsuaurio objeto que contiene los campos necesarios para crear el usuario
    */
	public ResponseEntity<Object> crearUsuario(@Valid @RequestBody UsuarioModel nuevoUsuaurio) {
		try {
			if(!this.existeNombre(nuevoUsuaurio.getNombre()))
			{
				Long rolId = nuevoUsuaurio.getCargoId().getId();
				RolModel rol = this.rolRepository.findById(rolId).get();
				nuevoUsuaurio.setCargoId(rol);
				return ResponseEntity.ok(this.usuarioRepository.save(nuevoUsuaurio));
				
			}else
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre ingresado ya se encuentra registrado en la base de datos");
			}
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creando el usuario");
		}

	}
	
	/**
	 * Esta funcion se encarga de la actualizacion de un usuario 
	 * @param usuarioActualizar objeto que contiene los campos necesarios para actualizar el usuario
    */
	public ResponseEntity<Object> actalizarUsuario(@Valid @RequestBody UsuarioModel usuarioActualizar) {
		
		UsuarioModel usuario = this.usuarioRepository.findById(usuarioActualizar.getId()).get();
		
		try 
		{
			if(!this.existeNombre(usuarioActualizar.getNombre()) || usuario.getNombre().equalsIgnoreCase(usuarioActualizar.getNombre()))
			{
				usuario.setNombre(usuarioActualizar.getNombre());
				usuario.setCargoId(usuarioActualizar.getCargoId());
				usuario.setActivo(usuarioActualizar.getActivo());
		
				usuario = this.usuarioRepository.findById(usuarioActualizar.getId()).get();
				return ResponseEntity.ok(usuario);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre ingresado ya se encuentra registrado en la base de datos");
			}
		} 
		catch (Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error actualizando el usuario");
		}
		
	}
	
	
	/**
	 * Esta funcion se encarga de listar todos los usuarios registrados en la base de datos
    */
	public ResponseEntity<Object> getAllUsuarios() {
	
		try {
			return ResponseEntity.ok(this.usuarioRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error listando los usuarios");
		}
	}
	
	/**
	 * Esta funcion se encarga de buscar un empleado
    */
	public ResponseEntity<Object> findById(@RequestParam Long id) {
	
		try {
			return ResponseEntity.ok(this.usuarioRepository.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error buscando el usuario");
		}
	}
	
	
	/**
	 * Esta funcion se encarga de eliminar un usuario de la base de datos
	 * @param idUsuario id del usuario a eliminar
    */
	public ResponseEntity<Object> eliminerUsuario(@RequestParam Long idUsuario) {
		ResponseEntity<Object> response = ResponseEntity.ok(HttpStatus.OK);
		ResponseDto responseDto = null;
		
		try {
			UsuarioModel usuarioEliminar = this.usuarioRepository.findById(idUsuario).get();
			this.usuarioRepository.deleteById(idUsuario);
			responseDto = new ResponseDto(HttpStatus.OK, "Exito eliminando el usuario");
			responseDto.setObjetoRespuesta(usuarioEliminar);
			response = new ResponseEntity<>(responseDto, HttpStatus.OK);
		} catch (Exception e) {
			responseDto = new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "Error eliminando el usuario " + e);
			response = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	
	/**
	 * Esta funcion se encarga de verificar si el nombre de usuario ya existe en la BD
	 * @param nombre el nombre de usuario a validar
    */
	public boolean existeNombre(String nombre) {
		
		boolean bandera = false;
		
		if(this.usuarioRepository.buscarPorNombre(nombre) != null) {
			bandera = true;
		}
		return bandera;
	}
	
	
	
	
}
