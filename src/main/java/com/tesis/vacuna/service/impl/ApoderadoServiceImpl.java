package com.tesis.vacuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.repository.ApoderadoRepository;
import com.tesis.vacuna.service.ApoderadoService;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {

	@Autowired
	ApoderadoRepository apoderadoRepository;

	@Override
	public List<ApoderadoEntity> listApoderados() {

		return apoderadoRepository.findAll();
	}

	@Override
	public MessageDTO addApoderado(ApoderadoEntity apoderadoEntity) {

		apoderadoRepository.save(apoderadoEntity);

		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setOk(true);
		messageDTO.setMensaje("agregado corectamente");

		return messageDTO;
	}

}
