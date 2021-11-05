package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.TipoPoblacionEntity;
import com.tesis.vacuna.repository.TipoPoblacionRepository;
import com.tesis.vacuna.service.TipoPoblacionService;

@Service
public class TipoPoblacionServiceImpl implements TipoPoblacionService {

	@Autowired
	TipoPoblacionRepository tipoPoblacionRepository;

	@Override
	public List<TipoPoblacionEntity> findAll() {

		return tipoPoblacionRepository.findAll();
	}

}
