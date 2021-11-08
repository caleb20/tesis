package com.tesis.vacuna.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacunacion")
public class VacunacionEntity {

	@Id
	private String dniHijo;

	private int idVacuna;

	private Date fecha;

	private String lugar;

	private String dniVacunador;

	public String getDniHijo() {
		return dniHijo;
	}

	public void setDniHijo(String dniHijo) {
		this.dniHijo = dniHijo;
	}

	public int getIdVacuna() {
		return idVacuna;
	}

	public void setIdVacuna(int idVacuna) {
		this.idVacuna = idVacuna;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

}
