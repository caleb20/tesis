package com.tesis.vacuna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.EdadAplicaEntity;
import com.tesis.vacuna.repository.EdadAplicaRepository;
import com.tesis.vacuna.service.EdadAplicaService;

@Service
public class EdadAplicaServiceImpl implements EdadAplicaService {

	@Autowired
	EdadAplicaRepository edadAplicaRepository;

	@Override
	public EdadAplicaEntity findById(Integer idEdadAplica) {

		return edadAplicaRepository.findById(idEdadAplica).get();
	}

}
