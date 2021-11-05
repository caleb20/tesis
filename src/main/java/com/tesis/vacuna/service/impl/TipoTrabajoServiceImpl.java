package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.TipoTrabajoEntity;
import com.tesis.vacuna.repository.TipoTrabajoRepository;
import com.tesis.vacuna.service.TipoTrabajoService;

@Service
public class TipoTrabajoServiceImpl implements TipoTrabajoService {

	@Autowired
	TipoTrabajoRepository tipoTrabajoRepository;

	@Override
	public List<TipoTrabajoEntity> findAll() {

		return tipoTrabajoRepository.findAll();
	}

}
