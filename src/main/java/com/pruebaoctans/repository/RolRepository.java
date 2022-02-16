package com.pruebaoctans.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaoctans.model.RolModel;

@Transactional
public interface RolRepository extends JpaRepository<RolModel,Long> {

}
