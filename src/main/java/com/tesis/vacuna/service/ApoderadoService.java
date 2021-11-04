package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;

public interface ApoderadoService {

	List<ApoderadoEntity> listApoderados();

	MessageDTO addApoderado(ApoderadoEntity apoderadoEntity);
}
