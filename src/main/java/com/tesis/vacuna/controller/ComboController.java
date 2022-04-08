package com.tesis.vacuna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.vacuna.entity.EstadoCivilEntity;
import com.tesis.vacuna.entity.NivelEducacionEntity;
import com.tesis.vacuna.entity.NivelRiesgoEntity;
import com.tesis.vacuna.entity.NivelSocioEconomicoEntity;
import com.tesis.vacuna.entity.TipoPoblacionEntity;
import com.tesis.vacuna.entity.TipoTrabajoEntity;
import com.tesis.vacuna.service.ApoderadoService;
import com.tesis.vacuna.service.EstadoCivilService;
import com.tesis.vacuna.service.HijoService;
import com.tesis.vacuna.service.NivelEducacionService;
import com.tesis.vacuna.service.NivelRiesgoService;
import com.tesis.vacuna.service.NivelSocioEconomicoService;
import com.tesis.vacuna.service.TipoPoblacionService;
import com.tesis.vacuna.service.TipoTrabajoService;

@RestController
@RequestMapping("/combos")
@CrossOrigin
public class ComboController {

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
	NivelRiesgoService nivelRiesgoService;
	
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

	@GetMapping("/nivelesRiesgo")
	public List<NivelRiesgoEntity> getNivelesRiesgo() {
		return nivelRiesgoService.findAll();
	}
	
}
