package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.entity.VacunaEntity;
import com.tesis.vacuna.repository.VacunaRepository;
import com.tesis.vacuna.service.VacunaService;

@Service
public class VacunaServiceImpl implements VacunaService {

	@Autowired
	VacunaRepository vacunaRepository;

	@Override
	public List<VacunaEntity> findAll() {
		return vacunaRepository.findAll();
	}

//	@Override
//	public List<VacunaEntity> findByEdadAplica(String edadAplica) {
//		return vacunaRepository.findByEdadAplica(edadAplica);
//	}

	@Override
	public VacunaEntity findById(Integer idVacunacion) {
		return vacunaRepository.findById(idVacunacion).get();
	}

	@Override
	public List<VacunaEntity> findByIdEdadAplica(Integer idVacunacion) {
		return vacunaRepository.findByIdEdadAplica(idVacunacion);
	}

}
