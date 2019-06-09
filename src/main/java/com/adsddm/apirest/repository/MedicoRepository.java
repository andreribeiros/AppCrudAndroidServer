package com.adsddm.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adsddm.apirest.models.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
	
	Medico findById(long id);

}
