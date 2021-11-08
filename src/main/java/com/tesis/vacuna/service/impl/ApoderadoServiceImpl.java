package com.tesis.vacuna.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.repository.ApoderadoRepository;
import com.tesis.vacuna.service.ApoderadoHijoService;
import com.tesis.vacuna.service.ApoderadoService;
import com.tesis.vacuna.utils.Util;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {

	@Autowired
	ApoderadoRepository apoderadoRepository;

	@Autowired
	ApoderadoHijoService apoderadoHijoService;

	@Override
	public List<ApoderadoDTO> listApoderados() {

		List<ApoderadoEntity> apoderadoEntities = apoderadoRepository.findAll();

		List<ApoderadoDTO> apoderadoDTOs = new ArrayList<>();

		if (!apoderadoEntities.isEmpty()) {

			for (ApoderadoEntity apoderadoEntity : apoderadoEntities) {
				var apoderadoDTO = new ApoderadoDTO();
				apoderadoDTO.setDni(apoderadoEntity.getDni());
				apoderadoDTO.setNombres(apoderadoEntity.getNombres());
				apoderadoDTO.setApellidos(apoderadoEntity.getApellidos());
				apoderadoDTO.setFechaNacimiento(String.valueOf(apoderadoEntity.getFechaNacimiento().getTime() / 1000L));
				apoderadoDTO.setCelular(apoderadoEntity.getCelular());
				apoderadoDTO.setCorreo(apoderadoEntity.getCorreo());
				apoderadoDTO.setSexo(apoderadoEntity.getSexo());
				apoderadoDTO.setEstadoCivil(apoderadoEntity.getEstadoCivil());
				apoderadoDTO.setNivelEducacion(apoderadoEntity.getNivelEducacion());
				apoderadoDTO.setTipoTrabajo(apoderadoEntity.getTipoTrabajo());
				apoderadoDTO.setNivelSocioeconomico(apoderadoEntity.getNivelSocioeconomico());
				apoderadoDTO.setTipoPoblacion(apoderadoEntity.getTipoPoblacion());
				apoderadoDTO.setNumeroHijos(apoderadoHijoService.findByDniApoderado(apoderadoEntity.getDni()).size());
				apoderadoDTOs.add(apoderadoDTO);
			}

		}

		return apoderadoDTOs;
	}

	@Override
	public MessageDTO addApoderado(ApoderadoDTO apoderadoDTO) {

		var apoderadoEntity = new ApoderadoEntity();
		apoderadoEntity.setDni(apoderadoDTO.getDni());
		apoderadoEntity.setNombres(apoderadoDTO.getNombres());
		apoderadoEntity.setApellidos(apoderadoDTO.getApellidos());
		apoderadoEntity.setFechaNacimiento(Util.unixTimeToDate(apoderadoDTO.getFechaNacimiento()));
		apoderadoEntity.setCelular(apoderadoDTO.getCelular());
		apoderadoEntity.setCorreo(apoderadoDTO.getCorreo());
		apoderadoEntity.setSexo(apoderadoDTO.getSexo());
		apoderadoEntity.setEstadoCivil(apoderadoDTO.getEstadoCivil());
		apoderadoEntity.setNivelEducacion(apoderadoDTO.getNivelEducacion());
		apoderadoEntity.setTipoTrabajo(apoderadoDTO.getTipoTrabajo());
		apoderadoEntity.setNivelSocioeconomico(apoderadoDTO.getNivelSocioeconomico());
		apoderadoEntity.setTipoPoblacion(apoderadoDTO.getTipoPoblacion());

		apoderadoRepository.save(apoderadoEntity);

		var messageDTO = new MessageDTO();
		messageDTO.setOk(true);
		messageDTO.setMensaje("agregado corectamente");

		return messageDTO;
	}

}
