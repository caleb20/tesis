package com.tesis.vacuna.dto;

public class VacunaDTO {

	private String categoria;
	private String tipo;
	private String descripcion;
	private boolean aplicado;

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

}
