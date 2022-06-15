package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "frecuencia")
public class FrecuenciaEntity {

	@Id
	private String valor;
	private String descripcion;
	private String mensaje;
	private Integer intervalo;

}
