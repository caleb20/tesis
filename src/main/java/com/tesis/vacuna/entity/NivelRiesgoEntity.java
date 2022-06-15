package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "nivelRiesgo")
public class NivelRiesgoEntity {

	@Id
	private String valor;
	private String descripcion;
	private String frecuencia;

}
