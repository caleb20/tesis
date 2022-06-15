package com.tesis.vacuna.dto;

import lombok.Data;

@Data
public class DetalleVacunacionDTO {

	private String tipo;
	private String descripcion;
	private boolean aplicado;
	private String fechaCita;
	private String fechaVacunacion;
	private String lugar;
	private String dniVacunador;
	private String reaccion;

}
