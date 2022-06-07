package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.FrecuenciaEntity;
import com.tesis.vacuna.repository.FrecuenciaRepository;
import com.tesis.vacuna.service.FrecuenciaService;

@Service
public class FrecuenciaServiceImpl implements FrecuenciaService {

	@Autowired
	FrecuenciaRepository frecuenciaRepository;

	@Override
	public List<FrecuenciaEntity> findAll() {
		return frecuenciaRepository.findAll();
	}

	@Override
	public FrecuenciaEntity addFrecuencia(FrecuenciaEntity frecuenciaEntity) {
		return frecuenciaRepository.save(frecuenciaEntity);
	}

	@Override
	public FrecuenciaEntity findById(String id) {

		return frecuenciaRepository.findById(id).get();
	}

}
