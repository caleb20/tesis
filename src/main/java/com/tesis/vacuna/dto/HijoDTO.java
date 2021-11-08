package com.tesis.vacuna.dto;

public class HijoDTO {

	private String dni;
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private String dniPadre;

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

	public String getDniPadre() {
		return dniPadre;
	}

	public void setDniPadre(String dniPadre) {
		this.dniPadre = dniPadre;
	}

}
