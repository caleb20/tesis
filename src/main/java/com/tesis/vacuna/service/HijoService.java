package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.HijoEntity;

public interface HijoService {

	List<HijoEntity> findAll();

	MessageDTO addHijo(HijoEntity hijoEntity);

}
