package com.tesis.vacuna.dto;

import lombok.Data;

@Data
public class VacunaDTO {

	private Integer idVacunacion;
	private Integer idVacuna;
	private Integer idUbicacion;
	private String nombreVacuna;
	private String enfermedadesPreviene;
	private String descripcion;
	private boolean aplicado;
	private String fechaCita;
	private String fechaVacunacion;
	private String dniVacunador;
	private String reaccion;

}
