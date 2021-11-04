package com.tesis.vacuna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apoderado")
public class ApoderadoEntity {

	@Id
	@Column(name = "dni")
	private String dni;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "celular")
	private String celular;

	@Column(name = "correo")
	private String correo;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "estadocivil")
	private String estadoCivil;

	@Column(name = "niveleducacion")
	private String nivelEducacion;

	@Column(name = "tipotrabajo")
	private String tipoTrabajo;

	@Column(name = "nivelsocioeconomico")
	private String nivelSocioEconomico;

	@Column(name = "tipopoblacion")
	private String tipoPoblacion;

	@Column(name = "numerohijos")
	private Integer numeroHijos;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNivelEducacion() {
		return nivelEducacion;
	}

	public void setNivelEducacion(String nivelEducacion) {
		this.nivelEducacion = nivelEducacion;
	}

	public String getTipoTrabajo() {
		return tipoTrabajo;
	}

	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

	public String getNivelSocioEconomico() {
		return nivelSocioEconomico;
	}

	public void setNivelSocioEconomico(String nivelSocioEconomico) {
		this.nivelSocioEconomico = nivelSocioEconomico;
	}

	public String getTipoPoblacion() {
		return tipoPoblacion;
	}

	public void setTipoPoblacion(String tipoPoblacion) {
		this.tipoPoblacion = tipoPoblacion;
	}

	public Integer getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(Integer numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

}
