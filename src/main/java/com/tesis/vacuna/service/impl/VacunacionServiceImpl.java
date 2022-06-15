package com.tesis.vacuna.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesis.vacuna.dto.EstadoVacunacionDTO;
import com.tesis.vacuna.dto.GrupoVacunaDTO;
import com.tesis.vacuna.dto.MessageDTO;
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
import com.tesis.vacuna.utils.Util;

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
	public EstadoVacunacionDTO findVacunacionByDniHijo(String dniHijo) {

		HijoEntity hijoEntity = hijoService.findById(dniHijo);

		EstadoVacunacionDTO vacunacionDTO = new EstadoVacunacionDTO();
		vacunacionDTO.setDni(hijoEntity.getDni());
		vacunacionDTO.setNombres(hijoEntity.getNombres());
		vacunacionDTO.setApellidos(hijoEntity.getApellidos());
		vacunacionDTO.setFechaNacimiento(Util.dateToUnixTime(hijoEntity.getFechaNacimiento()));

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

			List<VacunaEntity> vacunasEntities = vacunaService.findByIdEdadAplica(grupoVacunaDTO.getId());
			List<VacunaDTO> vacunaDTOs = new ArrayList<>();

			for (VacunaEntity vacunaEntity : vacunasEntities) {
				VacunaDTO vacunaDTO = new VacunaDTO();

				vacunaDTO.setIdVacuna(vacunaEntity.getId());
				vacunaDTO.setNombreVacuna(vacunaEntity.getNombreVacuna());
				vacunaDTO.setEnfermedadesPreviene(vacunaEntity.getEnfermedadesPreviene());
				vacunaDTO.setDescripcion(vacunaEntity.getDescripcion());

				VacunacionEntity vacunacionEntity = findByDniHijoAndIdVacuna(dniHijo, vacunaEntity.getId());

				if (vacunacionEntity != null) {
					vacunaDTO.setIdVacunacion(vacunacionEntity.getId());
					vacunaDTO.setFechaCita(Util.dateToUnixTime(vacunacionEntity.getFechaCita()));
					vacunaDTO.setFechaVacunacion(Util.dateToUnixTime(vacunacionEntity.getFecha()));
					vacunaDTO.setIdUbicacion(vacunacionEntity.getIdUbicacion());
					vacunaDTO.setDniVacunador(vacunacionEntity.getDniVacunador());
					vacunaDTO.setReaccion(vacunacionEntity.getReaccion());

					if (StringUtils.isEmpty(Util.dateToUnixTime(vacunacionEntity.getFecha()))) {
						vacunaDTO.setAplicado(false);

					} else {
						vacunaDTO.setAplicado(true);

					}
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

	@Override
	public MessageDTO save(VacunacionDTO vacunacionDTO) {

		var vacunacionEntity = new VacunacionEntity();

		if (vacunacionDTO.getIdVacunacion() != null) {
			vacunacionEntity = vacunacionRepository.findById(vacunacionDTO.getIdVacunacion()).get();
			vacunacionEntity.setId(vacunacionDTO.getIdVacunacion());
		}

		vacunacionEntity.setLote(vacunacionDTO.getLote());
		vacunacionEntity.setDniHijo(vacunacionDTO.getDni());
		vacunacionEntity.setIdVacuna(Integer.valueOf(vacunacionDTO.getIdVacuna()));
		if (vacunacionDTO.getIdVacuna().equals(1)) {
			vacunacionEntity.setFechaCita(new Date());
		} else {
			vacunacionEntity.setFechaCita(vacunacionEntity.getFechaCita());
		}
		vacunacionEntity.setFecha(new Date());
		vacunacionEntity.setIdUbicacion(vacunacionDTO.getIdUbicacion());
		vacunacionEntity.setDniVacunador(vacunacionDTO.getDniVacunador());
		vacunacionEntity.setReaccion(vacunacionDTO.getReaccion());
		vacunacionEntity.setEstado("1");

		vacunacionRepository.save(vacunacionEntity);

		var messageDTO = new MessageDTO();
		messageDTO.setOk(true);
		messageDTO.setMensaje("agregado corectamente");

		VacunacionEntity vacunacionEntitySiguiente = new VacunacionEntity();
		vacunacionEntitySiguiente.setDniHijo(vacunacionDTO.getDni());
		vacunacionEntitySiguiente.setIdVacuna(Integer.valueOf(vacunacionDTO.getIdVacuna()) + 1);
		vacunacionEntitySiguiente.setFechaCita(Util.unixTimeToDate(vacunacionDTO.getFechaCita()));
		vacunacionEntitySiguiente.setEstado("2");

		vacunacionRepository.save(vacunacionEntitySiguiente);

		return messageDTO;
	}

	@Override
	public List<VacunacionDTO> findByFechaCitaBetweenAndIdVacunaAndEstado(String fechaIni, String fechaFin,
			Integer idVacuna, String estado, Integer idUbicacion) {

		List<VacunacionEntity> vacunacionesEntities = new ArrayList<>();

		if (idUbicacion.equals(0)) {
			vacunacionesEntities = vacunacionRepository.findByFechaCitaBetweenAndIdVacunaAndEstado(
					Util.unixTimeToDate(fechaIni), Util.unixTimeToDate(fechaFin), idVacuna, estado);
		} else {
			vacunacionesEntities = vacunacionRepository.findByFechaCitaBetweenAndIdVacunaAndEstadoAndIdUbicacion(
					Util.unixTimeToDate(fechaIni), Util.unixTimeToDate(fechaFin), idVacuna, estado, idUbicacion);
		}

		List<VacunacionDTO> vacunacionDTOs = setVacunasDTO(vacunacionesEntities);

		return vacunacionDTOs;
	}

	@Override
	public List<VacunacionDTO> findByFechaCitaBetweenAndEstado(String fechaIni, String fechaFin, String estado,
			Integer idUbicacion) {

		List<VacunacionEntity> vacunacionesEntities = new ArrayList<>();

		if (idUbicacion.equals(0)) {
			vacunacionesEntities = vacunacionRepository.findByFechaCitaBetweenAndEstado(Util.unixTimeToDate(fechaIni),
					Util.unixTimeToDate(fechaFin), estado);
		} else {
			vacunacionesEntities = vacunacionRepository.findByFechaCitaBetweenAndEstadoAndIdUbicacion(
					Util.unixTimeToDate(fechaIni), Util.unixTimeToDate(fechaFin), estado, idUbicacion);
		}

		List<VacunacionDTO> vacunacionDTOs = setVacunasDTO(vacunacionesEntities);

		return vacunacionDTOs;
	}

	private List<VacunacionDTO> setVacunasDTO(List<VacunacionEntity> vacunacionesEntities) {
		List<VacunacionDTO> vacunacionDTOs = new ArrayList<>();

		for (VacunacionEntity vacunacionEntity : vacunacionesEntities) {
			VacunacionDTO vacunacionDTO = new VacunacionDTO();
			vacunacionDTO.setIdVacuna(vacunacionEntity.getIdVacuna());
			vacunacionDTO.setVacuna(vacunaService.findById(vacunacionEntity.getIdVacuna()).getNombreVacuna());
			vacunacionDTO.setFechaCita(Util.dateToUnixTime(vacunacionEntity.getFechaCita()));
			vacunacionDTO.setIdUbicacion(vacunacionEntity.getIdUbicacion());
			vacunacionDTO.setDni(vacunacionEntity.getDniHijo());
			vacunacionDTO.setNombres(hijoService.findById(vacunacionEntity.getDniHijo()).getNombres());
			vacunacionDTO.setApellidos(hijoService.findById(vacunacionEntity.getDniHijo()).getApellidos());
			vacunacionDTO.setFechaNacimiento(
					Util.dateToUnixTime(hijoService.findById(vacunacionEntity.getDniHijo()).getFechaNacimiento()));
			vacunacionDTOs.add(vacunacionDTO);
		}
		return vacunacionDTOs;
	}

}
