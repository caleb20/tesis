package com.tesis.vacuna.dto;

import java.util.List;

import lombok.Data;

@Data
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
	private String nivelRiesgo;

}
