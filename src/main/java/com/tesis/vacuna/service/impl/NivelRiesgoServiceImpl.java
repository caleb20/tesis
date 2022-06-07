package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.NivelRiesgoEntity;
import com.tesis.vacuna.repository.NivelRiesgoRepository;
import com.tesis.vacuna.service.NivelRiesgoService;

@Service
public class NivelRiesgoServiceImpl implements NivelRiesgoService {

	@Autowired
	NivelRiesgoRepository nivelRiesgoRepository;

	@Override
	public List<NivelRiesgoEntity> findAll() {

		return nivelRiesgoRepository.findAll();
	}

	@Override
	public NivelRiesgoEntity findById(String id) {

		return nivelRiesgoRepository.findById(id).get();
	}

}
