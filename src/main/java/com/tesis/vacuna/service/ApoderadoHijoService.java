package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.entity.ApoderadoHijoEntity;

public interface ApoderadoHijoService {

	List<ApoderadoHijoEntity> findAll();

	List<ApoderadoHijoEntity> findByDniApoderado(String dniApoderado);
	
}
