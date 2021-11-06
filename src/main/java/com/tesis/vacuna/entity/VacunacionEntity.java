package com.tesis.vacuna.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacunacion")
public class VacunacionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvacunacion")
	private Integer idVacunacion;

	@Column(name = "dnihijo")
	private String dniHijo;

	@Column(name = "idvacuna")
	private int idVacuna;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "lugar")
	private String lugar;

	@Column(name = "dnivacunador")
	private String dniVacunador;

	public Integer getIdVacunacion() {
		return idVacunacion;
	}

	public void setIdVacunacion(Integer idVacunacion) {
		this.idVacunacion = idVacunacion;
	}

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
