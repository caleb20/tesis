package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.EstadoCivilEntity;
import com.tesis.vacuna.repository.EstadoCivilRepository;
import com.tesis.vacuna.service.EstadoCivilService;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {

	@Autowired
	EstadoCivilRepository estadoCivilRepository;

	@Override
	public List<EstadoCivilEntity> findAll() {

		return estadoCivilRepository.findAll();
	}

}
