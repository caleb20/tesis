package com.tesis.vacuna.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoHijoEntity;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.repository.ApoderadoHijoRepository;
import com.tesis.vacuna.repository.HijoRepository;
import com.tesis.vacuna.security.entity.Rol;
import com.tesis.vacuna.security.entity.Usuario;
import com.tesis.vacuna.security.enums.RolNombre;
import com.tesis.vacuna.security.service.RolService;
import com.tesis.vacuna.security.service.UsuarioService;
import com.tesis.vacuna.service.HijoService;
import com.tesis.vacuna.utils.Util;

@Service
public class HijoServiceImpl implements HijoService {

	@Autowired
	HijoRepository hijoRepository;

	@Autowired
	ApoderadoHijoRepository apoderadoHijoRepository;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RolService rolService;

	@Override
	public List<HijoEntity> findAll() {

		return hijoRepository.findAll();
	}

	@Override
	public MessageDTO addHijo(HijoDTO hijoDTO) {

		if (hijoRepository.findById(hijoDTO.getDni()).isEmpty()) {

			HijoEntity hijoEntity = new HijoEntity();
			hijoEntity.setDni(hijoDTO.getDni());
			hijoEntity.setNombres(hijoDTO.getNombres());
			hijoEntity.setApellidos(hijoDTO.getApellidos());
			hijoEntity.setFechaNacimiento(Util.unixTimeToDate(hijoDTO.getFechaNacimiento()));

			hijoRepository.save(hijoEntity);

			ApoderadoHijoEntity apoderadoHijoEntity = new ApoderadoHijoEntity();
			apoderadoHijoEntity.setDniApoderado(hijoDTO.getDniPadre());
			apoderadoHijoEntity.setDniHijo(hijoDTO.getDni());

			apoderadoHijoRepository.save(apoderadoHijoEntity);

			MessageDTO messageDTO = new MessageDTO();
			messageDTO.setOk(true);
			messageDTO.setMensaje("agregado corectamente");

			Usuario usuario = new Usuario(hijoDTO.getNombres().concat(" ").concat(hijoDTO.getApellidos()),
					hijoDTO.getDni(), "", passwordEncoder.encode("abcd1234"));
			Set<Rol> roles = new HashSet<>();

			Optional<Rol> rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER);
			if (rolUser.isPresent())
				roles.add(rolUser.get());

			usuario.setRoles(roles);

			usuarioService.save(usuario);

			return messageDTO;
		}

		else {
			var messageDTO = new MessageDTO();
			messageDTO.setOk(false);
			messageDTO.setMensaje("Hijo ya registrado");
			return messageDTO;
		}
	}

	@Override
	public HijoEntity findById(String dniHijo) {

		return hijoRepository.findById(dniHijo).get();
	}

}
