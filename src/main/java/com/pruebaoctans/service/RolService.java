package com.pruebaoctans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pruebaoctans.repository.RolRepository;

@Service
public class RolService {
	
	@Autowired
	RolRepository rolRepository;
	
	
	/**
	 * Esta funcion se encarga de listar todos los roles registrados en la base de datos
    */
	public ResponseEntity<Object> getAllRoles() {

		try {
				return ResponseEntity.ok(rolRepository.findAll());
		} catch (Exception e) {
			    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error listando los roles");
		}

	}
	
	
}
