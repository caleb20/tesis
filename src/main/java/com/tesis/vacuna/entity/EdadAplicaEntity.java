package com.tesis.vacuna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edadaplica")
public class EdadAplicaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idedadaplica")
	private Integer idEdadAplica;

	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdEdadAplica() {
		return idEdadAplica;
	}

	public void setIdEdadAplica(Integer idEdadAplica) {
		this.idEdadAplica = idEdadAplica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
