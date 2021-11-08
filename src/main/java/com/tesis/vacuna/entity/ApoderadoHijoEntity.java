package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ApoderadoHijo")
public class ApoderadoHijoEntity {

	@Id
	private String dniApoderado;

	private String dniHijo;

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
