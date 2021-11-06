package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.repository.HijoRepository;
import com.tesis.vacuna.service.HijoService;

@Service
public class HijoServiceImpl implements HijoService {

	@Autowired
	HijoRepository hijoRepository;

	@Override
	public List<HijoEntity> findAll() {

		return hijoRepository.findAll();
	}

	@Override
	public MessageDTO addHijo(HijoEntity hijoEntity) {

		hijoRepository.save(hijoEntity);

		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setOk(true);
		messageDTO.setMensaje("agregado corectamente");

		return messageDTO;
	}

	@Override
	public List<HijoEntity> findByDniPadre(String dniPadre) {

		return hijoRepository.findByDniPadre(dniPadre);
	}

	@Override
	public HijoEntity findById(String dniHijo) {

		return hijoRepository.findById(dniHijo).get();
	}

}
