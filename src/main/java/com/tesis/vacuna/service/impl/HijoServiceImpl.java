package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoHijoEntity;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.repository.ApoderadoHijoRepository;
import com.tesis.vacuna.repository.HijoRepository;
import com.tesis.vacuna.service.HijoService;
import com.tesis.vacuna.utils.Util;

@Service
public class HijoServiceImpl implements HijoService {

	@Autowired
	HijoRepository hijoRepository;

	@Autowired
	ApoderadoHijoRepository apoderadoHijoRepository;

	@Override
	public List<HijoEntity> findAll() {

		return hijoRepository.findAll();
	}

	@Override
	public MessageDTO addHijo(HijoDTO hijoDTO) {

		HijoEntity hijoEntity = new HijoEntity();
		hijoEntity.setDni(hijoDTO.getDni());
		hijoEntity.setNombres(hijoDTO.getNombres());
		hijoEntity.setApellidos(hijoDTO.getApellidos());
		hijoEntity.setFechaNacimiento(Util.unixTimeToDate(hijoDTO.getFechaNacimiento()));

		hijoRepository.save(hijoEntity);

		ApoderadoHijoEntity apoderadoHijoEntity = new ApoderadoHijoEntity();
		apoderadoHijoEntity.setDniApoderado(hijoDTO.getDniPadre());
		apoderadoHijoEntity.setDniHijo(hijoDTO.getDni());

		apoderadoHijoRepository.save(apoderadoHijoEntity);

		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setOk(true);
		messageDTO.setMensaje("agregado corectamente");

		return messageDTO;
	}

//	@Override
//	public List<HijoEntity> findByDniPadre(String dniPadre) {
//
//		return hijoRepository.findByDniPadre(dniPadre);
//	}

	@Override
	public HijoEntity findById(String dniHijo) {

		return hijoRepository.findById(dniHijo).get();
	}

}
