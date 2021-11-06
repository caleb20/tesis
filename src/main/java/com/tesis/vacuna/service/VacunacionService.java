package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.dto.VacunacionDTO;
import com.tesis.vacuna.entity.VacunacionEntity;

public interface VacunacionService {

	List<VacunacionEntity> findAll();

	VacunacionDTO findVacunacionByDniHijo(String dniHijo);
	
	List<VacunacionEntity> findByDniHijo(String dniHijo);

	VacunacionEntity findByDniHijoAndIdVacuna(String dniHijo, Integer idVacuna);

}
