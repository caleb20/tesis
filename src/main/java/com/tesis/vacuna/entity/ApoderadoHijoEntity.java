package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ApoderadoHijo")
public class ApoderadoHijoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String dniApoderado;

	private String dniHijo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDniApoderado() {
		return dniApoderado;
	}

	public void setDniApoderado(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	public String getDniHijo() {
		return dniHijo;
	}

	public void setDniHijo(String dniHijo) {
		this.dniHijo = dniHijo;
	}

}
