package com.tesis.vacuna.service;

import java.util.List;

import com.tesis.vacuna.dto.ResponseDTO;
import com.tesis.vacuna.entity.UsuarioEntity;

public interface UsuarioService {

	List<UsuarioEntity> listUsuarios();

	ResponseDTO login(UsuarioEntity usuario);

}
