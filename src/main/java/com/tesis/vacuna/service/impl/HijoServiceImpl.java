package com.tesis.vacuna.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.ApoderadoHijoDTO;
import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.entity.ApoderadoHijoEntity;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.repository.ApoderadoHijoRepository;
import com.tesis.vacuna.repository.HijoRepository;
import com.tesis.vacuna.security.entity.Rol;
import com.tesis.vacuna.security.entity.Usuario;
import com.tesis.vacuna.security.enums.RolNombre;
import com.tesis.vacuna.security.service.RolService;
import com.tesis.vacuna.security.service.UsuarioService;
import com.tesis.vacuna.service.ApoderadoHijoService;
import com.tesis.vacuna.service.ApoderadoService;
import com.tesis.vacuna.service.HijoService;
import com.tesis.vacuna.service.NivelRiesgoService;
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

	@Autowired
	ApoderadoHijoService apoderadoHijoService;

	@Autowired
	NivelRiesgoService nivelRiesgoService;

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
			hijoEntity.setSexo(hijoDTO.getSexo());

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

	@Override
	public List<ApoderadoEntity> findByHabilitado(Boolean habilitado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HijoDTO> findByNivelRiesgo(String nivelRiesgo) {

		List<HijoDTO> hijoDTOs = new ArrayList<>();

		List<HijoEntity> hijoEntities = hijoRepository.findAll();

		for (HijoEntity hijoEntity : hijoEntities) {
			HijoDTO hijoDTO = new HijoDTO();

			ApoderadoDTO apoderadoDTO = apoderadoHijoService.findByDniHijo(hijoEntity.getDni()).get(0);

			if (nivelRiesgo.equals(apoderadoDTO.getNivelRiesgo())) {

				hijoDTO.setDni(hijoEntity.getDni());
				hijoDTO.setNombres(hijoEntity.getNombres());
				hijoDTO.setApellidos(hijoEntity.getApellidos());
				hijoDTO.setFechaNacimiento(Util.dateToUnixTime(hijoEntity.getFechaNacimiento()));
				hijoDTO.setSexo(hijoDTO.getSexo());
				hijoDTO.setDniPadre(apoderadoDTO.getDni());
				hijoDTO.setNivelRiesgo(nivelRiesgoService.findById(apoderadoDTO.getNivelRiesgo()).getDescripcion());

				hijoDTOs.add(hijoDTO);
			}
		}

		return hijoDTOs;
	}

}
