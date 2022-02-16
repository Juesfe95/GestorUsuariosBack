package com.pruebaoctans.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pruebaoctans.model.UsuarioModel;

@Transactional
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	@Query("SELECT DISTINCT usuario FROM UsuarioModel usuario " +
			"WHERE UPPER(usuario.nombre) = UPPER(:nombreUsuario) and usuario.activo = 'true'")
	 UsuarioModel buscarPorNombre(@Param("nombreUsuario") String nombreUsuario);
	
}
