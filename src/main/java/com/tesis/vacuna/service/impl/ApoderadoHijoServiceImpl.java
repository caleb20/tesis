package com.tesis.vacuna.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.ApoderadoHijoDTO;
import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.entity.ApoderadoHijoEntity;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.repository.ApoderadoHijoRepository;
import com.tesis.vacuna.repository.ApoderadoRepository;
import com.tesis.vacuna.repository.HijoRepository;
import com.tesis.vacuna.security.entity.Rol;
import com.tesis.vacuna.security.entity.Usuario;
import com.tesis.vacuna.security.service.UsuarioService;
import com.tesis.vacuna.service.ApoderadoHijoService;
import com.tesis.vacuna.utils.Util;

@Service
public class ApoderadoHijoServiceImpl implements ApoderadoHijoService {

	@Autowired
	ApoderadoHijoRepository apoderadoHijoRepository;

	@Autowired
	HijoRepository hijoRepository;

	@Autowired
	ApoderadoRepository apoderadoRepository;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ApoderadoHijoService apoderadoHijoService;

	@Override
	public List<ApoderadoHijoEntity> findAll() {

		return apoderadoHijoRepository.findAll();
	}

	@Override
	public List<HijoDTO> findByDniApoderado(String dniApoderado) {

		List<ApoderadoHijoEntity> apoderadosHijoEntities = apoderadoHijoRepository.findByDniApoderado(dniApoderado);

		List<HijoDTO> hijoDTOs = new ArrayList<>();

		for (ApoderadoHijoEntity apoderadoHijoEntity : apoderadosHijoEntities) {
			HijoDTO hijoDTO = new HijoDTO();

			Optional<HijoEntity> hijoEntity = hijoRepository.findById(apoderadoHijoEntity.getDniHijo());

			if (hijoEntity.isPresent()) {
				hijoDTO.setDniPadre(dniApoderado);

				hijoDTO.setDni(hijoEntity.get().getDni());
				hijoDTO.setNombres(hijoEntity.get().getNombres());
				hijoDTO.setApellidos(hijoEntity.get().getApellidos());
				hijoDTO.setFechaNacimiento(Util.dateToUnixTime(hijoEntity.get().getFechaNacimiento()));
				hijoDTOs.add(hijoDTO);

			}

		}

		return hijoDTOs;
	}

	@Override
	public List<ApoderadoDTO> findByDniHijo(String dniHijo) {

		List<ApoderadoHijoEntity> apoderadosHijoEntities = apoderadoHijoRepository.findByDniHijo(dniHijo);

		List<ApoderadoDTO> apoderadoDTOs = new ArrayList<>();

		for (ApoderadoHijoEntity apoderadoHijoEntity : apoderadosHijoEntities) {
			ApoderadoDTO apoderadoDTO = new ApoderadoDTO();

			Optional<ApoderadoEntity> apoderadoEntity = apoderadoRepository
					.findById(apoderadoHijoEntity.getDniApoderado());

			if (apoderadoEntity.isPresent()) {

				List<String> rolesString = validateRoles(apoderadoEntity.get());

				apoderadoDTO.setDni(apoderadoEntity.get().getDni());
				apoderadoDTO.setNombres(apoderadoEntity.get().getNombres());
				apoderadoDTO.setApellidos(apoderadoEntity.get().getApellidos());
				apoderadoDTO.setFechaNacimiento(Util.dateToUnixTime(apoderadoEntity.get().getFechaNacimiento()));
				apoderadoDTO.setCelular(apoderadoEntity.get().getCelular());
				apoderadoDTO.setCorreo(apoderadoEntity.get().getCorreo());
				apoderadoDTO.setSexo(apoderadoEntity.get().getSexo());
				apoderadoDTO.setEstadoCivil(apoderadoEntity.get().getEstadoCivil());
				apoderadoDTO.setNivelEducacion(apoderadoEntity.get().getNivelEducacion());
				apoderadoDTO.setTipoTrabajo(apoderadoEntity.get().getTipoTrabajo());
				apoderadoDTO.setNivelSocioeconomico(apoderadoEntity.get().getNivelSocioeconomico());
				apoderadoDTO.setTipoPoblacion(apoderadoEntity.get().getTipoPoblacion());
				apoderadoDTO.setHabilitado(apoderadoEntity.get().getHabilitado());
				apoderadoDTO.setRoles(rolesString);
				apoderadoDTO.setBaja(apoderadoEntity.get().getBaja());
				apoderadoDTO
						.setNumeroHijos(apoderadoHijoService.findByDniApoderado(apoderadoEntity.get().getDni()).size());
				apoderadoDTO.setNivelRiesgo(apoderadoEntity.get().getNivelRiesgo());
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

}
