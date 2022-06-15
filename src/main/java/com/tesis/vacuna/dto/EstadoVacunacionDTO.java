package com.tesis.vacuna.dto;

import java.util.List;

import lombok.Data;

@Data
public class EstadoVacunacionDTO {

	private String dni;
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private List<GrupoVacunaDTO> grupoVacunaDTO;

}
