package com.tesis.vacuna.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {

	@NotBlank
	private String dni;

	@NotBlank
	private String password;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}