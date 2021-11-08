package com.tesis.vacuna.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.tesis.vacuna.dto.Mensaje;
import com.tesis.vacuna.security.dto.JwtDto;
import com.tesis.vacuna.security.dto.LoginUsuario;
import com.tesis.vacuna.security.dto.NuevoUsuario;
import com.tesis.vacuna.security.entity.Rol;
import com.tesis.vacuna.security.entity.Usuario;
import com.tesis.vacuna.security.enums.RolNombre;
import com.tesis.vacuna.security.jwt.JwtProvider;
import com.tesis.vacuna.security.service.RolService;
import com.tesis.vacuna.security.service.UsuarioService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existsByDni(nuevoUsuario.getDni()))
			return new ResponseEntity(new Mensaje("ese dni ya existe"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
		Usuario usuario = new Usuario(nuevoUsuario.getNombresApellidos(), nuevoUsuario.getDni(),
				nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
		Set<Rol> roles = new HashSet<>();
		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		if (nuevoUsuario.getRoles().contains("medico"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_MEDICO).get());
		if (nuevoUsuario.getRoles().contains("user"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		usuario.setRoles(roles);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getDni(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),
				usuarioService.getByDni(loginUsuario.getDni()).get().getNombresApellidos(),
				userDetails.getAuthorities());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
	
	
}