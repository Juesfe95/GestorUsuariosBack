package com.pruebaoctans.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaoctans.constant.ApiConstant;
import com.pruebaoctans.service.RolService;

@RestController
@RequestMapping(ApiConstant.ROL_CONTROLLER_API)
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@GetMapping(value = ApiConstant.ROL_CONTROLLER_API_GET_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllRoles(){
	return this.rolService.getAllRoles();
	}

}
