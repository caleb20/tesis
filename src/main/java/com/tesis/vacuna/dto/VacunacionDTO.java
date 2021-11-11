package com.tesis.vacuna.dto;

import java.util.List;

public class VacunacionDTO {

	private Integer idVacunacion;
	private Integer idVacuna;
	private String lote;
	private String dni;
	private String nombres;
	private String apellidos;
	private String vacuna;
	private String fechaCita;
	private String fechaVacunacion;
	private String lugar;
	private String dniVacunador;
	private String reaccion;

	List<GrupoVacunaDTO> grupoVacunaDTO;

	public Integer getIdVacunacion() {
		return idVacunacion;
	}

	public void setIdVacunacion(Integer idVacunacion) {
		this.idVacunacion = idVacunacion;
	}

	public Integer getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(Integer idVacuna) {
		this.idVacuna = idVacuna;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

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

	public String getVacuna() {
		return vacuna;
	}

	public void setVacuna(String vacuna) {
		this.vacuna = vacuna;
	}

	public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(String fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDniVacunador() {
		return dniVacunador;
	}

	public void setDniVacunador(String dniVacunador) {
		this.dniVacunador = dniVacunador;
	}

	public String getReaccion() {
		return reaccion;
	}

	public void setReaccion(String reaccion) {
		this.reaccion = reaccion;
	}

	public List<GrupoVacunaDTO> getGrupoVacunaDTO() {
		return grupoVacunaDTO;
	}

	public void setGrupoVacunaDTO(List<GrupoVacunaDTO> grupoVacunaDTO) {
		this.grupoVacunaDTO = grupoVacunaDTO;
	}

}
