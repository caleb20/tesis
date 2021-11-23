package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.MessageDTO;

public interface ApoderadoService {

	List<ApoderadoDTO> listMedicos();

	List<ApoderadoDTO> findByHabilitado(Boolean habilitado);

	MessageDTO addApoderado(ApoderadoDTO apoderadoDTO);
}
