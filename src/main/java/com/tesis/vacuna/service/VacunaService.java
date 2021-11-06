package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.entity.VacunaEntity;

public interface VacunaService {

	List<VacunaEntity> findAll();

	List<VacunaEntity> findByEdadAplica(String edadAplica);

	VacunaEntity findById(Integer idVacunacion);
	
	List<VacunaEntity> findByIdEdadAplica(Integer idVacunacion);


}
