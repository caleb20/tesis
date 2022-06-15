package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.entity.HijoEntity;

public interface HijoService {

	List<HijoEntity> findAll();

	MessageDTO addHijo(HijoDTO hijoDTO);

//	List<HijoEntity> findByDniPadre(String dniPadre);

	HijoEntity findById(String dniHijo);

	List<ApoderadoEntity> findByHabilitado(Boolean habilitado);

	List<HijoDTO> findByNivelRiesgo(String nivelRiesgo);

}
