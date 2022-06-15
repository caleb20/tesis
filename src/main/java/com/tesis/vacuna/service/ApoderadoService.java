package com.tesis.vacuna.service;

import java.sql.SQLException;
import java.util.List;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;

public interface ApoderadoService {

	List<ApoderadoDTO> listMedicos();

	ApoderadoEntity findById(String dni);
	
	List<ApoderadoDTO> findByHabilitado(Boolean habilitado);

	MessageDTO addApoderado(ApoderadoDTO apoderadoDTO) throws SQLException;
}
