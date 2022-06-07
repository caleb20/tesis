package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.entity.ApoderadoHijoEntity;

public interface ApoderadoHijoService {

	List<ApoderadoHijoEntity> findAll();

	List<HijoDTO> findByDniApoderado(String dniApoderado);

	List<ApoderadoDTO> findByDniHijo(String dniHijo);

}
