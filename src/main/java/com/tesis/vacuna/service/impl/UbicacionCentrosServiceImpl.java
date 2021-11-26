package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.UbicacionCentrosEntity;
import com.tesis.vacuna.repository.UbicacionCentrosRepository;
import com.tesis.vacuna.service.UbicacionCentrosService;

@Service
public class UbicacionCentrosServiceImpl implements UbicacionCentrosService {

	@Autowired
	UbicacionCentrosRepository ubicacionCentrosRepository;

	@Override
	public List<UbicacionCentrosEntity> findAll() {
		return ubicacionCentrosRepository.findAll();
	}

}
