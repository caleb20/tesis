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
	@Column(name = "id")
	private Integer id;

	private Integer idEdadAplica;

	private String nombreVacuna;

	private String enfermedadesPreviene;

	private String descripcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdEdadAplica() {
		return idEdadAplica;
	}

	public void setIdEdadAplica(Integer idEdadAplica) {
		this.idEdadAplica = idEdadAplica;
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

}
