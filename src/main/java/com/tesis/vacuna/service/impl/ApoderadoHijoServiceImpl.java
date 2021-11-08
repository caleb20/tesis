package com.tesis.vacuna.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.entity.ApoderadoHijoEntity;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.repository.ApoderadoHijoRepository;
import com.tesis.vacuna.repository.HijoRepository;
import com.tesis.vacuna.service.ApoderadoHijoService;

@Service
public class ApoderadoHijoServiceImpl implements ApoderadoHijoService {

	@Autowired
	ApoderadoHijoRepository apoderadoHijoRepository;

	@Autowired
	HijoRepository hijoRepository;

	@Override
	public List<ApoderadoHijoEntity> findAll() {

		return apoderadoHijoRepository.findAll();
	}

	@Override
	public List<HijoDTO> findByDniApoderado(String dniApoderado) {

		List<ApoderadoHijoEntity> apoderadosHijoEntities = apoderadoHijoRepository.findByDniApoderado(dniApoderado);

		List<HijoDTO> hijoDTOs = new ArrayList<>();

		for (ApoderadoHijoEntity apoderadoHijoEntity : apoderadosHijoEntities) {
			HijoDTO hijoDTO = new HijoDTO();

			Optional<HijoEntity> hijoEntity = hijoRepository.findById(apoderadoHijoEntity.getDniHijo());

			if (hijoEntity.isPresent()) {
				hijoDTO.setDniPadre(dniApoderado);

				hijoDTO.setDni(hijoEntity.get().getDni());
				hijoDTO.setNombres(hijoEntity.get().getNombres());
				hijoDTO.setApellidos(hijoEntity.get().getApellidos());
				hijoDTO.setFechaNacimiento(String.valueOf(hijoEntity.get().getFechaNacimiento().getTime() / 1000L));
				hijoDTOs.add(hijoDTO);

			}

		}

		return hijoDTOs;
	}

}
