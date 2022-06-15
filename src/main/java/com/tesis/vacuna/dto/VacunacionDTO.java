package com.tesis.vacuna.dto;

import java.util.List;

import lombok.Data;

@Data
public class VacunacionDTO {

	private Integer idVacunacion;
	private Integer idVacuna;
	private Integer idUbicacion;
	private String lote;
	private String dni;
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private String vacuna;
	private String fechaCita;
	private String fechaVacunacion;
	private String lugar;
	private String dniVacunador;
	private String reaccion;

	private List<GrupoVacunaDTO> grupoVacunaDTO;

}
