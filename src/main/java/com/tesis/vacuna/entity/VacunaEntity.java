package com.tesis.vacuna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacuna")
public class VacunaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvacuna")
	private Integer idVacuna;

	@Column(name = "idedadaplica")
	private Integer idEdadAplica;

	@Column(name = "edadaplica")
	private String edadAplica;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(Integer idVacuna) {
		this.idVacuna = idVacuna;
	}

	public Integer getIdEdadAplica() {
		return idEdadAplica;
	}

	public void setIdEdadAplica(Integer idEdadAplica) {
		this.idEdadAplica = idEdadAplica;
	}

	public String getEdadAplica() {
		return edadAplica;
	}

	public void setEdadAplica(String edadAplica) {
		this.edadAplica = edadAplica;
	}

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

}
