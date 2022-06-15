package com.tesis.vacuna.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "hijo")
public class HijoEntity {

	@Id
	private String dni;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private String sexo;

}
