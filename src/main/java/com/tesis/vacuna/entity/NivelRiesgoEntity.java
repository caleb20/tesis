package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nivelRiesgo")
public class NivelRiesgoEntity {

	@Id
	private String valor;

	private String descripcion;

	private String frecuencia;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

}
