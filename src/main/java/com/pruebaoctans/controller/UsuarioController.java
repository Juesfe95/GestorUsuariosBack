package com.pruebaoctans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaoctans.constant.ApiConstant;
import com.pruebaoctans.model.UsuarioModel;
import com.pruebaoctans.service.UsuarioService;


@RestController
@RequestMapping(ApiConstant.USUARIO_CONTROLLER_API)
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	
	@PostMapping(value = ApiConstant.USUARIO_CONTROLLER_API_CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> crearUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.crearUsuario(usuario);
	}
	
	@PutMapping(value = ApiConstant.USUARIO_CONTROLLER_API_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actalizarUsuario(@RequestBody UsuarioModel usuarioActualizar) {
		return this.usuarioService.actalizarUsuario(usuarioActualizar);
	}
	
	//metodo para listar todos los usuarios
	@GetMapping(value = ApiConstant.USUARIO_CONTROLLER_API_GET_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllUsuarios(){
	return this.usuarioService.getAllUsuarios();
	}
	
	@GetMapping(value = ApiConstant.USUARIO_CONTROLLER_API_FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findById(@RequestParam Long id){
	return this.usuarioService.findById(id);
	}
	
	@DeleteMapping(value = ApiConstant.USUARIO_CONTROLLER_API_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminerUsuario(@RequestParam Long id){
	return this.usuarioService.eliminerUsuario(id);
	}
}
