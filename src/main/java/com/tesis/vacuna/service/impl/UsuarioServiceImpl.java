package com.tesis.vacuna.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.ResponseDTO;
import com.tesis.vacuna.entity.UsuarioEntity;
import com.tesis.vacuna.repository.UsuarioRepository;
import com.tesis.vacuna.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioEntity> listUsuarios() {

		return usuarioRepository.findAll();
	}

	@Override
	public ResponseDTO login(UsuarioEntity usuario) {

		boolean acceso = false;

		Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findById(usuario.getDni());

		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setTipo(null);
		responseDTO.setAcceso(acceso);

		if (usuarioEntity.isPresent()) {
			if (usuario.getClave().equals(usuarioEntity.get().getClave())) {
				responseDTO.setAcceso(true);
				responseDTO.setTipo(usuarioEntity.get().getTipo());
			}
		} else {
			return responseDTO;
		}

		return responseDTO;
	}

}
