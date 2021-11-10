package com.tesis.vacuna.dto;

import java.util.List;

public class EstadoVacunacionDTO {

	private String dni;
	private String nombres;
	private String apellidos;

	List<GrupoVacunaDTO> grupoVacunaDTO;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<GrupoVacunaDTO> getGrupoVacunaDTO() {
		return grupoVacunaDTO;
	}

	public void setGrupoVacunaDTO(List<GrupoVacunaDTO> grupoVacunaDTO) {
		this.grupoVacunaDTO = grupoVacunaDTO;
	}

}
