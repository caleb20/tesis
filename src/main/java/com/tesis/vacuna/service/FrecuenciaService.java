package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.entity.FrecuenciaEntity;

public interface FrecuenciaService {

	List<FrecuenciaEntity> findAll();

	FrecuenciaEntity findById(String id);

	FrecuenciaEntity addFrecuencia(FrecuenciaEntity frecuenciaEntity);
}
