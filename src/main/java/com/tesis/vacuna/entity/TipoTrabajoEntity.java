package com.tesis.vacuna.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipoTrabajo")
public class TipoTrabajoEntity {

	@Id
	private String valor;
	private String descripcion;

}
