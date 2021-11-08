package com.tesis.vacuna.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.security.entity.Usuario;
import com.tesis.vacuna.security.entity.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByDni(dni).get();
		return UsuarioPrincipal.build(usuario);
	}
}