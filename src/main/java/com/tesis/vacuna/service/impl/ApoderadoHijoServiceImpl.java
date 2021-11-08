package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.ApoderadoHijoEntity;
import com.tesis.vacuna.repository.ApoderadoHijoRepository;
import com.tesis.vacuna.service.ApoderadoHijoService;

@Service
public class ApoderadoHijoServiceImpl implements ApoderadoHijoService {

	@Autowired
	ApoderadoHijoRepository apoderadoHijoRepository;

	@Override
	public List<ApoderadoHijoEntity> findAll() {

		return apoderadoHijoRepository.findAll();
	}

	@Override
	public List<ApoderadoHijoEntity> findByDniApoderado(String dniApoderado) {

		return apoderadoHijoRepository.findByDniApoderado(dniApoderado);
	}

}
