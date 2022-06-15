package com.tesis.vacuna.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "apoderado")
public class ApoderadoEntity {

	@Id
	private String dni;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private String celular;
	private String correo;
	private String sexo;
	private String estadoCivil;
	private String nivelEducacion;
	private String tipoTrabajo;
	private String nivelSocioeconomico;
	private String tipoPoblacion;
	private Boolean habilitado;
	private Boolean baja;
	private String nivelRiesgo;

}
