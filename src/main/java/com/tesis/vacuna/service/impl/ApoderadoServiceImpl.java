package com.tesis.vacuna.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.jdbc.repository.RolJdbcRepository;
import com.tesis.vacuna.repository.ApoderadoRepository;
import com.tesis.vacuna.security.entity.Rol;
import com.tesis.vacuna.security.entity.Usuario;
import com.tesis.vacuna.security.enums.RolNombre;
import com.tesis.vacuna.security.service.RolService;
import com.tesis.vacuna.security.service.UsuarioService;
import com.tesis.vacuna.service.ApoderadoHijoService;
import com.tesis.vacuna.service.ApoderadoService;
import com.tesis.vacuna.utils.Util;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {

	@Autowired
	ApoderadoRepository apoderadoRepository;

	@Autowired
	ApoderadoHijoService apoderadoHijoService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RolService rolService;

	@Autowired
	RolJdbcRepository rolJdbcRepository;

	@Override
	public List<ApoderadoDTO> findByHabilitado(Boolean habilitado) {

		List<ApoderadoEntity> apoderadoEntities = apoderadoRepository.findByHabilitado(habilitado);

		List<Usuario> rolApoderadoEntities = usuarioService.findByRol(RolNombre.ROLE_USER);

		List<ApoderadoEntity> usuariosEntities = new ArrayList<ApoderadoEntity>();

		for (ApoderadoEntity apoderadoEntity : apoderadoEntities) {
			for (Usuario usuario : rolApoderadoEntities) {
				if (apoderadoEntity.getDni().equals(usuario.getDni())) {
					usuariosEntities.add(apoderadoEntity);
				}

			}
		}

		List<ApoderadoDTO> apoderadoDTOs = new ArrayList<>();

		if (!usuariosEntities.isEmpty()) {

			for (ApoderadoEntity apoderadoEntity : usuariosEntities) {

				List<String> rolesString = validateRoles(apoderadoEntity);

				var apoderadoDTO = new ApoderadoDTO();
				apoderadoDTO.setDni(apoderadoEntity.getDni());
				apoderadoDTO.setNombres(apoderadoEntity.getNombres());
				apoderadoDTO.setApellidos(apoderadoEntity.getApellidos());
				apoderadoDTO.setFechaNacimiento(Util.dateToUnixTime(apoderadoEntity.getFechaNacimiento()));
				apoderadoDTO.setCelular(apoderadoEntity.getCelular());
				apoderadoDTO.setCorreo(apoderadoEntity.getCorreo());
				apoderadoDTO.setSexo(apoderadoEntity.getSexo());
				apoderadoDTO.setEstadoCivil(apoderadoEntity.getEstadoCivil());
				apoderadoDTO.setNivelEducacion(apoderadoEntity.getNivelEducacion());
				apoderadoDTO.setTipoTrabajo(apoderadoEntity.getTipoTrabajo());
				apoderadoDTO.setNivelSocioeconomico(apoderadoEntity.getNivelSocioeconomico());
				apoderadoDTO.setTipoPoblacion(apoderadoEntity.getTipoPoblacion());
				apoderadoDTO.setHabilitado(apoderadoEntity.getHabilitado());
				apoderadoDTO.setRoles(rolesString);
				apoderadoDTO.setBaja(apoderadoEntity.getBaja());
				apoderadoDTO.setNumeroHijos(apoderadoHijoService.findByDniApoderado(apoderadoEntity.getDni()).size());
				apoderadoDTO.setNivelRiesgo(apoderadoEntity.getNivelRiesgo());
				apoderadoDTOs.add(apoderadoDTO);
			}

		}

		return apoderadoDTOs;
	}

	@Override
	public MessageDTO addApoderado(ApoderadoDTO apoderadoDTO) throws SQLException {

		setUsuario(apoderadoDTO);

		var apoderadoEntity = new ApoderadoEntity();

		apoderadoEntity.setDni(apoderadoDTO.getDni());
		apoderadoEntity.setNombres(apoderadoDTO.getNombres());
		apoderadoEntity.setApellidos(apoderadoDTO.getApellidos());
		apoderadoEntity.setFechaNacimiento(Util.unixTimeToDate(apoderadoDTO.getFechaNacimiento()));
		apoderadoEntity.setCelular(apoderadoDTO.getCelular());
		apoderadoEntity.setCorreo(apoderadoDTO.getCorreo());
		apoderadoEntity.setSexo(apoderadoDTO.getSexo());
		apoderadoEntity.setEstadoCivil(apoderadoDTO.getEstadoCivil());
		apoderadoEntity.setNivelEducacion(apoderadoDTO.getNivelEducacion());
		apoderadoEntity.setTipoTrabajo(apoderadoDTO.getTipoTrabajo());
		apoderadoEntity.setNivelSocioeconomico(apoderadoDTO.getNivelSocioeconomico());
		apoderadoEntity.setTipoPoblacion(apoderadoDTO.getTipoPoblacion());
		apoderadoEntity.setHabilitado(apoderadoDTO.getHabilitado());
		apoderadoEntity.setBaja(apoderadoDTO.getBaja());
		apoderadoEntity.setNivelRiesgo(apoderadoDTO.getNivelRiesgo());

		apoderadoRepository.save(apoderadoEntity);

		var messageDTO = new MessageDTO();
		messageDTO.setOk(true);
		messageDTO.setMensaje("agregado corectamente");

		return messageDTO;

	}

	@Override
	public List<ApoderadoDTO> listMedicos() {

		List<ApoderadoEntity> apoderadoEntities = apoderadoRepository.findAll();

		List<Usuario> rolMedicoEntities = usuarioService.findByRol(RolNombre.ROLE_MEDICO);

		List<ApoderadoEntity> medicosEntities = new ArrayList<>();

		for (ApoderadoEntity apoderadoEntity : apoderadoEntities) {

			for (Usuario usuario : rolMedicoEntities) {
				if (apoderadoEntity.getDni().equals(usuario.getDni())) {
					medicosEntities.add(apoderadoEntity);
				}
			}

		}

		List<ApoderadoDTO> apoderadoDTOs = new ArrayList<>();

		if (!medicosEntities.isEmpty()) {

			for (ApoderadoEntity apoderadoEntity : medicosEntities) {

				List<String> rolesString = validateRoles(apoderadoEntity);

				var apoderadoDTO = new ApoderadoDTO();
				apoderadoDTO.setDni(apoderadoEntity.getDni());
				apoderadoDTO.setNombres(apoderadoEntity.getNombres());
				apoderadoDTO.setApellidos(apoderadoEntity.getApellidos());
				apoderadoDTO.setFechaNacimiento(Util.dateToUnixTime(apoderadoEntity.getFechaNacimiento()));
				apoderadoDTO.setCelular(apoderadoEntity.getCelular());
				apoderadoDTO.setCorreo(apoderadoEntity.getCorreo());
				apoderadoDTO.setSexo(apoderadoEntity.getSexo());
				apoderadoDTO.setEstadoCivil(apoderadoEntity.getEstadoCivil());
				apoderadoDTO.setNivelEducacion(apoderadoEntity.getNivelEducacion());
				apoderadoDTO.setTipoTrabajo(apoderadoEntity.getTipoTrabajo());
				apoderadoDTO.setNivelSocioeconomico(apoderadoEntity.getNivelSocioeconomico());
				apoderadoDTO.setTipoPoblacion(apoderadoEntity.getTipoPoblacion());
				apoderadoDTO.setHabilitado(apoderadoEntity.getHabilitado());
				apoderadoDTO.setRoles(rolesString);
				apoderadoDTO.setBaja(apoderadoEntity.getBaja());
				apoderadoDTO.setNumeroHijos(apoderadoHijoService.findByDniApoderado(apoderadoEntity.getDni()).size());
				apoderadoDTO.setNivelRiesgo(apoderadoEntity.getNivelRiesgo());
				apoderadoDTOs.add(apoderadoDTO);
			}

		}

		return apoderadoDTOs;
	}

	private List<String> validateRoles(ApoderadoEntity apoderadoEntity) {
		List<String> rolesString = new ArrayList<>();

		Optional<Usuario> apoderadoValidate = usuarioService.getByDni(apoderadoEntity.getDni());

		if (apoderadoValidate.isPresent()) {
			Set<Rol> roles = apoderadoValidate.get().getRoles();
			rolesString = setRoles(roles);
		}
		return rolesString;
	}

	private List<String> setRoles(Set<Rol> roles) {
		List<String> rolesString = new ArrayList<>();

		for (Rol rol : roles) {

			String rolNombre = "";

			switch (rol.getRolNombre()) {
			case ROLE_ADMIN:
				rolNombre = "admin";
				break;
			case ROLE_MEDICO:
				rolNombre = "medico";
				break;
			case ROLE_HIJO:
				rolNombre = "hijo";
				break;
			case ROLE_USER:
				rolNombre = "user";
				break;
			}
			rolesString.add(rolNombre);
		}
		return rolesString;
	}

	private void setUsuario(ApoderadoDTO apoderadoDTO) throws SQLException {

		Optional<Usuario> usuarioValidate = usuarioService.getByDni(apoderadoDTO.getDni());

		Set<Rol> roles = new HashSet<>();

		Usuario usuario = new Usuario(apoderadoDTO.getNombres().concat(" ").concat(apoderadoDTO.getApellidos()),
				apoderadoDTO.getDni(), apoderadoDTO.getCorreo());

		if (apoderadoDTO.getRoles().contains("user")) {
			Optional<Rol> rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER);
			if (rolUser.isPresent()) {
				usuario.setFechaNacimiento(passwordEncoder.encode(apoderadoDTO.getFechaNacimiento()));
				roles.add(rolUser.get());
			}
		}

		if (apoderadoDTO.getRoles().contains("admin")) {
			Optional<Rol> rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN);
			if (rolAdmin.isPresent()) {
				usuario.setPassword(passwordEncoder.encode("abcd1234"));
				roles.add(rolAdmin.get());
			}
		}
		if (apoderadoDTO.getRoles().contains("medico")) {
			Optional<Rol> rolMedico = rolService.getByRolNombre(RolNombre.ROLE_MEDICO);
			if (rolMedico.isPresent()) {
				usuario.setPassword(passwordEncoder.encode("abcd1234"));
				roles.add(rolMedico.get());
			}
		}

		if (usuarioValidate.isPresent()) {
//			rolJdbcRepository.deleteRolByUsuario(usuarioValidate.get().getId());
			usuario.setId(usuarioValidate.get().getId());
		}

		usuario.setRoles(roles);

		usuarioService.save(usuario);
	}

}
