package com.tesis.vacuna.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.vacuna.dto.ApoderadoDTO;
import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.dto.VacunacionDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.entity.EstadoCivilEntity;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.entity.NivelEducacionEntity;
import com.tesis.vacuna.entity.NivelSocioEconomicoEntity;
import com.tesis.vacuna.entity.TipoPoblacionEntity;
import com.tesis.vacuna.entity.TipoTrabajoEntity;
import com.tesis.vacuna.entity.VacunaEntity;
import com.tesis.vacuna.entity.VacunacionEntity;
import com.tesis.vacuna.service.ApoderadoHijoService;
import com.tesis.vacuna.service.ApoderadoService;
import com.tesis.vacuna.service.EstadoCivilService;
import com.tesis.vacuna.service.HijoService;
import com.tesis.vacuna.service.NivelEducacionService;
import com.tesis.vacuna.service.NivelSocioEconomicoService;
import com.tesis.vacuna.service.TipoPoblacionService;
import com.tesis.vacuna.service.TipoTrabajoService;
import com.tesis.vacuna.service.VacunaService;
import com.tesis.vacuna.service.VacunacionService;

@RestController
@RequestMapping("/vacunas")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAnyRole('ADMIN','USER','MEDICO')")
public class TesisController {

	@Autowired
	ApoderadoService apoderadoService;

	@Autowired
	EstadoCivilService estadoCivilService;

	@Autowired
	HijoService hijoService;

	@Autowired
	NivelEducacionService nivelEducacionService;

	@Autowired
	NivelSocioEconomicoService nivelSocioEconomicoService;

	@Autowired
	TipoPoblacionService tipoPoblacionService;

	@Autowired
	TipoTrabajoService tipoTrabajoService;

	@Autowired
	VacunacionService vacunacionService;

	@Autowired
	VacunaService vacunaService;

	@Autowired
	ApoderadoHijoService apoderadoHijoService;

	// APODERADO

	@GetMapping("/apoderados")
	public List<ApoderadoDTO> getApoderados() {
		List<ApoderadoDTO> apoderados = apoderadoService.listApoderados();
		return apoderados;
	}

	@PostMapping("/apoderado")
	public MessageDTO addApoderado(@RequestBody ApoderadoDTO apoderado) {
		return apoderadoService.addApoderado(apoderado);
	}

	// HIJO

	@GetMapping("/hijos")
	public List<HijoEntity> getHijos() {
		List<HijoEntity> hijos = hijoService.findAll();
		return hijos;
	}

	@GetMapping("/hijo/{dniApoderado}")
	public List<HijoDTO> getHijosPorApoderado(@PathVariable String dniApoderado) {
		List<HijoDTO> hijos = apoderadoHijoService.findByDniApoderado(dniApoderado);
		return hijos;
	}

	@PostMapping("/hijo")
	public MessageDTO addHijo(@RequestBody HijoEntity hijo) {
		return hijoService.addHijo(hijo);
	}

	// VACUNA

	@GetMapping("/vacunas")
	public List<VacunaEntity> getVacunas() {
		List<VacunaEntity> vacunas = vacunaService.findAll();

		return vacunas;
	}

	// VACUNACION

	@GetMapping("/vacunaciones")
	public List<VacunacionEntity> getVacunaciones() {
		List<VacunacionEntity> vacunaciones = vacunacionService.findAll();

		return vacunaciones;
	}

	@GetMapping("/vacunacion/{dniHijo}")
	public VacunacionDTO getVacunacionHijo(@PathVariable String dniHijo) {
		VacunacionDTO vacunaciones = vacunacionService.findVacunacionByDniHijo(dniHijo);

		return vacunaciones;
	}

	// COMBOS

	@GetMapping("/estadosCivil")
	public List<EstadoCivilEntity> getEstadosCivil() {
		return estadoCivilService.findAll();
	}

	@GetMapping("/nivelesEducacion")
	public List<NivelEducacionEntity> getNivelesEducacion() {
		return nivelEducacionService.findAll();
	}

	@GetMapping("/nivelesSocioeconomico")
	public List<NivelSocioEconomicoEntity> getNivelesSocioeconomico() {
		return nivelSocioEconomicoService.findAll();
	}

	@GetMapping("/tiposPoblacion")
	public List<TipoPoblacionEntity> getTiposPoblacion() {
		return tipoPoblacionService.findAll();
	}

	@GetMapping("/tiposTrabajo")
	public List<TipoTrabajoEntity> getTiposTrabajo() {
		return tipoTrabajoService.findAll();
	}

}
