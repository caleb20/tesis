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
	@Column(name = "id")
	private Integer id;

	private String lote;

	private String dniHijo;

	private int idVacuna;

	private Date fechaCita;

	private Date fecha;

	private String lugar;

	private String dniVacunador;

	private String reaccion;

	private String estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
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

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
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

	public String getReaccion() {
		return reaccion;
	}

	public void setReaccion(String reaccion) {
		this.reaccion = reaccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
