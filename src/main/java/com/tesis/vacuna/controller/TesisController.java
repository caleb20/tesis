package com.tesis.vacuna.controller;

import java.sql.SQLException;
import java.util.List;

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
import com.tesis.vacuna.dto.EstadoVacunacionDTO;
import com.tesis.vacuna.dto.HijoDTO;
import com.tesis.vacuna.dto.MessageDTO;
import com.tesis.vacuna.dto.VacunacionDTO;
import com.tesis.vacuna.entity.ApoderadoEntity;
import com.tesis.vacuna.entity.FrecuenciaEntity;
import com.tesis.vacuna.entity.HijoEntity;
import com.tesis.vacuna.entity.NivelRiesgoEntity;
import com.tesis.vacuna.entity.UbicacionCentrosEntity;
import com.tesis.vacuna.entity.VacunaEntity;
import com.tesis.vacuna.entity.VacunacionEntity;
import com.tesis.vacuna.security.entity.Rol;
import com.tesis.vacuna.security.service.RolService;
import com.tesis.vacuna.security.service.UsuarioService;
import com.tesis.vacuna.service.ApoderadoHijoService;
import com.tesis.vacuna.service.ApoderadoService;
import com.tesis.vacuna.service.EstadoCivilService;
import com.tesis.vacuna.service.FrecuenciaService;
import com.tesis.vacuna.service.HijoService;
import com.tesis.vacuna.service.MensajeriaService;
import com.tesis.vacuna.service.NivelEducacionService;
import com.tesis.vacuna.service.NivelRiesgoService;
import com.tesis.vacuna.service.NivelSocioEconomicoService;
import com.tesis.vacuna.service.TipoPoblacionService;
import com.tesis.vacuna.service.TipoTrabajoService;
import com.tesis.vacuna.service.UbicacionCentrosService;
import com.tesis.vacuna.service.VacunaService;
import com.tesis.vacuna.service.VacunacionService;

@RestController
@RequestMapping("/vacunas")
@CrossOrigin("*")
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

	@Autowired
	RolService rolService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	UbicacionCentrosService ubicacionCentrosService;

	@Autowired
	FrecuenciaService frecuenciaService;

	@Autowired
	MensajeriaService mensajeriaService;

	@Autowired
	NivelRiesgoService nivelRiesgoService;

	// APODERADO

	/*
	 * @GetMapping("/apoderados") public List<ApoderadoDTO> getApoderados() {
	 * List<ApoderadoDTO> apoderados = apoderadoService.listApoderados(); return
	 * apoderados; }
	 */
	@PreAuthorize("hasAnyRole('ADMIN','USER','MEDICO','HIJO')")
	@GetMapping("/apoderados/{habilitado}")
	public List<ApoderadoDTO> getApoderados(@PathVariable Boolean habilitado) {
		return apoderadoService.findByHabilitado(habilitado);
	}

	@PostMapping("/apoderado/nuevo")
	public MessageDTO addApoderado(@RequestBody ApoderadoDTO apoderado) throws SQLException {
		return apoderadoService.addApoderado(apoderado);
	}

	@PreAuthorize("hasAnyRole('ADMIN','USER','MEDICO','HIJO')")
	@GetMapping("/medicos")
	public List<ApoderadoDTO> getMedicos() {
		return apoderadoService.listMedicos();
	}

	@PreAuthorize("hasAnyRole('ADMIN','USER','MEDICO','HIJO')")
	@GetMapping("/apoderado/dni/{dni}")
	public ApoderadoEntity getApoderadoPorDni(@PathVariable String dni) {
		ApoderadoEntity apoderado = apoderadoService.findById(dni);
		return apoderado;
	}

	// HIJO
	@PreAuthorize("hasAnyRole('ADMIN','USER','MEDICO','HIJO')")
	@GetMapping("/hijos")
	public List<HijoEntity> getHijos() {
		List<HijoEntity> hijos = hijoService.findAll();
		return hijos;
	}

	@GetMapping("/hijo/dni/{dni}")
	public HijoEntity getHijoPorDni(@PathVariable String dni) {
		HijoEntity hijo = hijoService.findById(dni);
		return hijo;
	}

	@GetMapping("/hijo/{dniApoderado}")
	public List<HijoDTO> getHijosPorApoderado(@PathVariable String dniApoderado) {
		List<HijoDTO> hijos = apoderadoHijoService.findByDniApoderado(dniApoderado);
		return hijos;
	}

	@PostMapping("/hijo")
	public MessageDTO addHijo(@RequestBody HijoDTO hijo) {
		return hijoService.addHijo(hijo);
	}

	@GetMapping("/hijo/riesgo/{nivelRiesgo}")
	public List<HijoDTO> getHijosPorNivelRiesgo(@PathVariable String nivelRiesgo) {
		List<HijoDTO> hijos = hijoService.findByNivelRiesgo(nivelRiesgo);
		return hijos;
	}

	// VACUNA

	@GetMapping("/vacunas")
	public List<VacunaEntity> getVacunas() {
		return vacunaService.findAll();
	}

	// VACUNACION

	@GetMapping("/vacunaciones")
	public List<VacunacionEntity> getVacunaciones() {
		List<VacunacionEntity> vacunaciones = vacunacionService.findAll();
		return vacunaciones;
	}

	@GetMapping("/estadoVacunacion/{dniHijo}")
	public EstadoVacunacionDTO getVacunacionHijo(@PathVariable String dniHijo) {
		EstadoVacunacionDTO vacunaciones = vacunacionService.findVacunacionByDniHijo(dniHijo);

		return vacunaciones;
	}

	@PostMapping("/vacunacion")
	public MessageDTO addVacunacion(@RequestBody VacunacionDTO vacunacionDTO) {
		return vacunacionService.save(vacunacionDTO);
	}

	// @PreAuthorize("hasAnyRole('ADMIN','USER','MEDICO','HIJO')")
	@GetMapping("/vacunacion/{fechaIni}/{fechaFin}/{idVacuna}/{idUbicacion}")
	public List<VacunacionDTO> getVacunacionByFechaTipoVacuna(@PathVariable String fechaIni,
			@PathVariable String fechaFin, @PathVariable Integer idVacuna, @PathVariable Integer idUbicacion) {

		if (idVacuna.equals(0)) {
			return vacunacionService.findByFechaCitaBetweenAndEstado(fechaIni, fechaFin, "2", idUbicacion);
		} else {
			return vacunacionService.findByFechaCitaBetweenAndIdVacunaAndEstado(fechaIni, fechaFin, idVacuna, "2",
					idUbicacion);
		}

	}

	// ROLES
	@GetMapping("/roles")
	public List<Rol> getRoles() {
		return rolService.findAll();
	}

	// UBICACIONES
	@GetMapping("/ubicaciones")
	public List<UbicacionCentrosEntity> getUbicaciones() {
		return ubicacionCentrosService.findAll();
	}

	// UBICACIONES
	@GetMapping("/riesgos")
	public List<NivelRiesgoEntity> getRiesgos() {
		return nivelRiesgoService.findAll();
	}

	//

	// FRECUENCIAS
	@GetMapping("/frecuencias")
	public List<FrecuenciaEntity> getFrecuencias() {
		return frecuenciaService.findAll();
	}

	@PostMapping("/frecuencia")
	public FrecuenciaEntity addFrecuencia(@RequestBody FrecuenciaEntity frecuenciaEntity) {
		return frecuenciaService.addFrecuencia(frecuenciaEntity);
	}

	// MENSAJERIAS
	@GetMapping("/mensajerias")
	public void getMesajeria() {
		mensajeriaService.listadoPendientes();
	}
}
