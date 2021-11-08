package com.tesis.vacuna.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.GrupoVacunaDTO;
import com.tesis.vacuna.dto.VacunaDTO;
import com.tesis.vacuna.dto.VacunacionDTO;
import com.tesis.vacuna.entity.EdadAplicaEntity;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.entity.VacunaEntity;
import com.tesis.vacuna.entity.VacunacionEntity;
import com.tesis.vacuna.repository.VacunacionRepository;
import com.tesis.vacuna.service.EdadAplicaService;
import com.tesis.vacuna.service.HijoService;
import com.tesis.vacuna.service.VacunaService;
import com.tesis.vacuna.service.VacunacionService;

@Service
public class VacunacionServiceImpl implements VacunacionService {

	@Autowired
	VacunacionRepository vacunacionRepository;

	@Autowired
	VacunaService vacunaService;

	@Autowired
	HijoService hijoService;

	@Autowired
	EdadAplicaService edadAplicaService;

	@Override
	public List<VacunacionEntity> findAll() {

		return vacunacionRepository.findAll();
	}

	@Override
	public VacunacionDTO findVacunacionByDniHijo(String dniHijo) {

		HijoEntity hijoEntity = hijoService.findById(dniHijo);

		VacunacionDTO vacunacionDTO = new VacunacionDTO();
		vacunacionDTO.setDni(hijoEntity.getDni());
		vacunacionDTO.setNombres(hijoEntity.getNombres());
		vacunacionDTO.setApellidos(hijoEntity.getApellidos());

		List<GrupoVacunaDTO> grupoVacunaDTOs = new ArrayList<>();

		List<VacunaEntity> vacunaEntities = vacunaService.findAll();

		List<Integer> edadesAplicacion = new ArrayList<>();

		for (VacunaEntity vacunaEntity : vacunaEntities) {
			edadesAplicacion.add(vacunaEntity.getIdEdadAplica());
		}

		Set<Integer> set = new HashSet<>(edadesAplicacion);
		edadesAplicacion.clear();
		edadesAplicacion.addAll(set);

		for (Integer edadAplicacion : set) {
			GrupoVacunaDTO grupoVacunaDTO = new GrupoVacunaDTO();
			EdadAplicaEntity edadAplicaEntity = edadAplicaService.findById(edadAplicacion);
			grupoVacunaDTO.setId(edadAplicaEntity.getId());
			grupoVacunaDTO.setEdadAplica(edadAplicaEntity.getDescripcion());
			grupoVacunaDTOs.add(grupoVacunaDTO);
		}

		for (GrupoVacunaDTO grupoVacunaDTO : grupoVacunaDTOs) {

			List<VacunaEntity> vacunasEntities = vacunaService.findByIdEdadAplica(grupoVacunaDTO.getIdEdadAplica());
			List<VacunaDTO> vacunaDTOs = new ArrayList<>();

			for (VacunaEntity vacunaEntity : vacunasEntities) {
				VacunaDTO vacunaDTO = new VacunaDTO();

				vacunaDTO.setCategoria(vacunaEntity.getCategoria());
				vacunaDTO.setTipo(vacunaEntity.getTipo());
				vacunaDTO.setDescripcion(vacunaEntity.getDescripcion());

				VacunacionEntity vacunacionEntity = findByDniHijoAndIdVacuna(dniHijo, vacunaEntity.getIdVacuna());

				if (vacunacionEntity != null) {
					vacunaDTO.setAplicado(true);
				}

				vacunaDTOs.add(vacunaDTO);
			}
			grupoVacunaDTO.setVacunaDTO(vacunaDTOs);
		}

		vacunacionDTO.setGrupoVacunaDTO(grupoVacunaDTOs);

		return vacunacionDTO;
	}

	@Override
	public List<VacunacionEntity> findByDniHijo(String dniHijo) {
		return vacunacionRepository.findByDniHijo(dniHijo);
	}

	@Override
	public VacunacionEntity findByDniHijoAndIdVacuna(String dniHijo, Integer idVacuna) {
		return vacunacionRepository.findByDniHijoAndIdVacuna(dniHijo, idVacuna);
	}

}
