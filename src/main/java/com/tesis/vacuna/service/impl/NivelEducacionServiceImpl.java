package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.NivelEducacionEntity;
import com.tesis.vacuna.repository.NivelEducacionRepository;
import com.tesis.vacuna.service.NivelEducacionService;

@Service
public class NivelEducacionServiceImpl implements NivelEducacionService {

	@Autowired
	NivelEducacionRepository nivelEducacionRepository;

	@Override
	public List<NivelEducacionEntity> findAll() {

		return nivelEducacionRepository.findAll();
	}

}
