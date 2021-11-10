package com.tesis.vacuna.dto;

public class VacunaDTO {

	private String categoria;
	private String tipo;
	private String descripcion;
	private boolean aplicado;
	private String fechaCita;
	private String fechaVacunacion;
	private String lugar;
	private String dniVacunador;
	private String reaccion;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
