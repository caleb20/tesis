package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.NivelSocioEconomicoEntity;
import com.tesis.vacuna.repository.NivelSocioEconomicoRepository;
import com.tesis.vacuna.service.NivelSocioEconomicoService;

@Service
public class NivelSocioEconomicoServiceImpl implements NivelSocioEconomicoService {

	@Autowired
	NivelSocioEconomicoRepository nivelSocioEconomicoRepository;

	@Override
	public List<NivelSocioEconomicoEntity> findAll() {

		return nivelSocioEconomicoRepository.findAll();
	}

}
