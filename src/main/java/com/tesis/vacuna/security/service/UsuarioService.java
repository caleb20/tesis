package com.tesis.vacuna.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.vacuna.security.entity.Usuario;
import com.tesis.vacuna.security.repository.UsuarioRepository;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Optional<Usuario> getByDni(String dni) {
		return usuarioRepository.findByDni(dni);
	}

	public boolean existsByDni(String dni) {
		return usuarioRepository.existsByDni(dni);
	}

	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}