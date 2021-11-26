package com.tesis.vacuna.dto;

import java.util.List;

public class ApoderadoDTO {

	private String dni;
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private String celular;
	private String correo;
	private String sexo;
	private String estadoCivil;
	private String nivelEducacion;
	private String tipoTrabajo;
	private String nivelSocioeconomico;
	private String tipoPoblacion;
	private Integer numeroHijos;
	private List<String> roles;
	private Boolean habilitado;
	private Boolean baja;

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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getNivelSocioeconomico() {
		return nivelSocioeconomico;
	}

	public void setNivelSocioeconomico(String nivelSocioeconomico) {
		this.nivelSocioeconomico = nivelSocioeconomico;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Boolean getBaja() {
		return baja;
	}

	public void setBaja(Boolean baja) {
		this.baja = baja;
	}

}
