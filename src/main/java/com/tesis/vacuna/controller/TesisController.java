package com.tesis.vacuna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.dto.ResponseDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.entity.UsuarioEntity;
import com.tesis.vacuna.service.ApoderadoService;
import com.tesis.vacuna.service.UsuarioService;

@RestController
@RequestMapping("/vacunas")
public class TesisController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ApoderadoService apoderadoService;

	@PostMapping("/login")
	public ResponseDTO login(@RequestBody UsuarioEntity usuario) {

		return usuarioService.login(usuario);
	}

	@GetMapping("/usuarios")
	public List<UsuarioEntity> getUsuarios() {

		List<UsuarioEntity> usuarios = usuarioService.listUsuarios();
		return usuarios;

	}

	@PostMapping("/apoderado")
	public MessageDTO addApoderado(@RequestBody ApoderadoEntity apoderado) {

		return apoderadoService.addApoderado(apoderado);
	}

	@GetMapping("/apoderados")
	public List<ApoderadoEntity> getApoderados() {

		List<ApoderadoEntity> apoderados = apoderadoService.listApoderados();

		return apoderados;

	}
}
