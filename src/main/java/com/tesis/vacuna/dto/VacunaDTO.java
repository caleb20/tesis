package com.tesis.vacuna.dto;

public class VacunaDTO {

	private Integer idVacunacion;
	private Integer idVacuna;
	private String nombreVacuna;
	private String enfermedadesPreviene;
	private String descripcion;
	private boolean aplicado;
	private String fechaCita;
	private String fechaVacunacion;
	private String lugar;
	private String dniVacunador;
	private String reaccion;

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

	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	public String getEnfermedadesPreviene() {
		return enfermedadesPreviene;
	}

	public void setEnfermedadesPreviene(String enfermedadesPreviene) {
		this.enfermedadesPreviene = enfermedadesPreviene;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isAplicado() {
		return aplicado;
	}

	public void setAplicado(boolean aplicado) {
		this.aplicado = aplicado;
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

}
